package de.se_rwth.codecraft.game.fight.commands;

import de.se_rwth.codecraft.game.fight.FightCommand;
import de.se_rwth.codecraft.game.fight.FightContext;

public class TauntCommand implements FightCommand
{
	@Override
	public void Execute(FightContext context)
	{
		// Currently has no effect
	}

	@Override
	public void Rollback()
	{
		// Nothing to rollback
	}
}
