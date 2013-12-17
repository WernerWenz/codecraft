package de.se_rwth.codecraft.game.fight;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import de.se_rwth.codecraft.game.fight.controllers.CreatureController;

// This is in fact a command queue logging the whole fight sequence
// This defines the context of a fight.
// Creature Controllers can, with help of this, act depending on past actions.

public class FightContext
{
	private Random _rand = new Random();
	private CreatureController _active;
	private CreatureController _passive;
	private List<FightCommand> _rounds = new ArrayList<FightCommand>();

	public CreatureController GetActive() { return _active; }
	public CreatureController GetPassive() { return _passive; }

	// Swaps active/passive
	public void SwapCreatures()
	{
		CreatureController tmp = _active;
		_active = _passive;
		_passive = tmp;
	}

	public FightContext(CreatureController active, CreatureController passive)
	{
		_active = active;
		_passive = passive;
	}

	public FightCommand GetLastCommand()
	{
		int size = _rounds.size();
		if (size == 0)
			return null;
		return _rounds.get(size - 1);
	}

	public void GenerateRound()
	{
		FightCommand action = GetActive().SelectAction(this);
		action.Execute(this);
		_rounds.add(action);
	}

	public int Dice(int max)
	{
		return _rand.nextInt(max);
	}

	public int Round()
	{
		return _rounds.size();
	}
}
