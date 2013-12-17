package de.se_rwth.codecraft.game.fight.controllers;

import de.se_rwth.codecraft.game.creatures.Creature;
import de.se_rwth.codecraft.game.creatures.Goblin;
import de.se_rwth.codecraft.game.fight.FightCommand;
import de.se_rwth.codecraft.game.fight.FightContext;
import de.se_rwth.codecraft.game.fight.commands.AttackCommand;

public class GoblinController implements CreatureController
{
	private Goblin _model;

	public GoblinController(Goblin goblin)
	{
		_model = goblin;
	}

	@Override public Creature GetModel(){ return _model; }

	@Override
	public FightCommand SelectAction(FightContext context)
	{
		// Select a valid action for the Goblin here
		// Opponent Information can be retrieved via context.GetPassive().GetModel()

		// Goblins are stupid, they only may attack..
		return new AttackCommand();
	}

}
