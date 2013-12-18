package de.se_rwth.codecraft.game.fight.commands;

import de.se_rwth.codecraft.game.fight.FightCommand;
import de.se_rwth.codecraft.game.fight.FightContext;

public class RollbackCommand implements FightCommand
{
	private FightCommand _command;
	private FightContext _context;
	private String _log;

	@Override
	public void Execute(FightContext context)
	{
		_log = String.format("%1$s casted TempusRetorque and cancelled the last action.",
				context.GetActive().GetModel().GetName());

		if (_command == null)
		{
			_command = context.GetLastCommand();
			if (_command == null)
				return;
			_context = context;
			_command.Rollback();
		}
		else
			_command.Rollback();
	}

	@Override
	public void Rollback()
	{
		// WARNING: This may exhibit potential side effects due to _context being mutable
		// Rolling back an Undo (= REDO) after changes were applied afterwards
		// Are not well defined after all.
		if (_command == null)
			return;

		_command.Execute(_context);
	}

	@Override
	public String GetTextLog()
	{
		return _log;
	}
}
