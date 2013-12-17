package de.se_rwth.codecraft.game.fight.commands;

import de.se_rwth.codecraft.game.fight.FightCommand;
import de.se_rwth.codecraft.game.fight.FightContext;

public class RollbackCommand implements FightCommand
{
	private FightCommand _command;
	private FightContext _context;

	@Override
	public void Execute(FightContext context)
	{
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
}
