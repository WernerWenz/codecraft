package de.se_rwth.codecraft.game.fight.controllers;

import de.se_rwth.codecraft.game.creatures.Creature;
import de.se_rwth.codecraft.game.creatures.Swordsman;
import de.se_rwth.codecraft.game.fight.Fight;
import de.se_rwth.codecraft.game.fight.FightCommand;
import de.se_rwth.codecraft.game.fight.FightContext;
import de.se_rwth.codecraft.game.fight.commands.AttackCommand;

public class SwordsmanController implements CreatureController
{
	private Swordsman _model;
	private CreatureController _parentController;

	public SwordsmanController(Swordsman swordsman)
	{
		_model = swordsman;
		_parentController = Fight.CreateControllerFor(swordsman.GetDecoratedCreature());
	}

	@Override public Creature GetModel(){ return _model; }

	@Override
	public FightCommand SelectAction(FightContext context)
	{
		// Any Swordsman also gets melee attacks!
		if (context.Dice(100) <= 20)
			return new AttackCommand();
		
		return _parentController.SelectAction(context);
	}
}