package de.se_rwth.codecraft.game.fight.controllers;

import de.se_rwth.codecraft.game.creatures.Creature;
import de.se_rwth.codecraft.game.creatures.Ogre;
import de.se_rwth.codecraft.game.fight.FightCommand;
import de.se_rwth.codecraft.game.fight.FightContext;
import de.se_rwth.codecraft.game.fight.commands.AttackCommand;
import de.se_rwth.codecraft.game.fight.commands.TauntCommand;

public class OgreController implements CreatureController
{
	private Ogre _model;
	private AttackCommand _lastAttack;

	public OgreController(Ogre ogre)
	{
		_model = ogre;
	}

	@Override public Creature GetModel(){ return _model; }

	@Override
	public FightCommand SelectAction(FightContext context)
	{
		// Select a valid action for the Ogre here
		// Opponent Information can be retrieved via context.GetPassive().GetModel()

		AttackCommand lastAttack = _lastAttack; // used for consecutive attacks
		_lastAttack = null; // clear here so we don't accidentally forget this
							// in case we add more logic here

		if (context.Dice(100) < 20)
			return new TauntCommand();

		// Do a simple attack
		AttackCommand attack = new AttackCommand();
		if (lastAttack != null && lastAttack.WasSuccessful())
			attack.IncreaseSuccessRate(20);
		_lastAttack = attack;

		return _lastAttack;
	}
}
