package de.se_rwth.codecraft.game.fight;

import java.lang.reflect.InvocationTargetException;

import de.se_rwth.codecraft.exception.FightException;
import de.se_rwth.codecraft.game.creatures.Creature;
import de.se_rwth.codecraft.game.fight.controllers.CreatureController;

public class Fight
{
	private Creature _left;
	private Creature _right;
	private FightContext _context;
	private int _steps;

	private static final int MAX_STEPS = 10000;

	private CreatureController CreateControllerFor(Creature creature)
	{
		// This is probably a really nasty place.
		// We need to instance a FightController for given Creature
		// But at the same time we want to have the Creature to be decoupled
		// from the FightController i.e.: We don't want some Creature.CreateController().
		// Neither do we want some nasty switch() over the Creatures Type.
		// Thus we use some reflection magic here.
		//
		// The largest design disadvantage here is, that we imply a loose contract
		// That cannot be enforced by the compiler.
		// For any .game.CreatureName we expect the existence
		// of a .fight.controllers.CreatureNameController with a constructor taking .game.CreatureName.
		//
		// However this is still superior to having a large switch(typename) here, which needs
		// manual maintenance, or having fight logic coupled with the creatures.
		//
		// The big advantage of this "hack" shows up in the Unit test for example, where
		// we can define a TestCreature and TestCreatureController without being intrusive
		// to any of the code here.

		String name = creature.getClass().getCanonicalName();
		String[] names = name.split("\\.");

		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < names.length - 2; i++)
		{
			builder.append(names[i]);
			builder.append('.');
		}
		builder.append("fight.controllers.");
		builder.append(names[names.length - 1]);
		builder.append("Controller");
		String controllerClassName = builder.toString();
		try
		{
			Class<?> controllerClass = Class.forName(controllerClassName);
			return (CreatureController)controllerClass.getConstructors()[0].newInstance(creature);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| IllegalArgumentException | InvocationTargetException | SecurityException e)
		{
			// TODO: should associate some fail information with the FightException
			System.out.println(e.toString());

			throw new FightException();
		}
	}

	public Fight(Creature leftCreature, Creature rightCreature)
	{
		_left = leftCreature;
		_right = rightCreature;

		// Left always starts (we could randomize this or add some rule for it)
		_context = new FightContext(CreateControllerFor(_left), CreateControllerFor(_right));
	}

	public Boolean NextAction()
	{
		if (_left.GetHealth() <= 0 || _right.GetHealth() <= 0)
		{
			return false;
		}

		// Guard against infinite or too long battle
		// In fact we can't really detect infinite battles due to halting problem.
		// Thus we just abort after a maximum number of Actions is exceeded.
		_steps++;
		if (_steps > MAX_STEPS)
			throw new FightException();

		_context.GenerateRound();
		_context.SwapCreatures();

		return true; // just a stub for now
	}
}
