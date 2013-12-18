package de.se_rwth.codecraft.game.fight.commands;

import de.se_rwth.codecraft.game.fight.FightCommand;
import de.se_rwth.codecraft.game.fight.FightContext;

public class TauntCommand implements FightCommand
{
	private String _log;

	@Override
	public void Execute(FightContext context)
	{
		// Currently has no effect
		_log = String.format("%1$s taunts %2$s.",
				context.GetActive().GetModel().GetName(), context.GetPassive().GetModel().GetName());
	}

	@Override
	public void Rollback()
	{
		// Nothing to rollback
	}

	@Override
	public String GetTextLog()
	{
		return _log;
	}
}
