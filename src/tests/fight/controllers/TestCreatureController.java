package tests.fight.controllers;

import tests.creatures.TestCreature;
import de.se_rwth.codecraft.game.creatures.Creature;
import de.se_rwth.codecraft.game.fight.FightCommand;
import de.se_rwth.codecraft.game.fight.FightContext;
import de.se_rwth.codecraft.game.fight.commands.AttackCommand;
import de.se_rwth.codecraft.game.fight.commands.HealCommand;
import de.se_rwth.codecraft.game.fight.commands.RollbackCommand;
import de.se_rwth.codecraft.game.fight.controllers.CreatureController;

public class TestCreatureController implements CreatureController
{
	private TestCreature _model;

	public TestCreatureController(TestCreature creature)
	{
		_model = creature;
	}

	@Override public Creature GetModel(){ return _model; }

	private AttackCommand Attack()
	{
		AttackCommand cmd = new AttackCommand();

		cmd.IncreaseSuccessRate(100);
		return cmd;
	}

	@Override
	public FightCommand SelectAction(FightContext context)
	{
		switch (context.Round())
		{
		case 0:
		case 1:
		case 2:
			return Attack();
		case 3:
			return new RollbackCommand();
		case 4:
			return Attack();
		case 5:
		case 6:
		case 7:
			return new RollbackCommand();
		case 8:
			return new HealCommand(1);
		case 9:
			return new HealCommand(100);
		}
		return Attack();
	}
}


