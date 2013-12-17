package de.se_rwth.codecraft.game.fight.controllers;

import de.se_rwth.codecraft.game.creatures.Creature;
import de.se_rwth.codecraft.game.creatures.Kobold;
import de.se_rwth.codecraft.game.fight.FightCommand;
import de.se_rwth.codecraft.game.fight.FightContext;
import de.se_rwth.codecraft.game.fight.commands.AttackCommand;
import de.se_rwth.codecraft.game.fight.commands.RollbackCommand;

public class KoboldController implements CreatureController
{
	private Kobold _model;

	public KoboldController(Kobold kobold)
	{
		_model = kobold;
	}

	@Override public Creature GetModel(){ return _model; }

	@Override
	public FightCommand SelectAction(FightContext context)
	{
		// Select a valid action for the Goblin here
		// Opponent Information can be retrieved via context.GetPassive().GetModel()

		if (context.Dice(100) < 20)
			return new RollbackCommand();

		return new AttackCommand();
	}

}
