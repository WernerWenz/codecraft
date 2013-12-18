package de.se_rwth.codecraft.game.fight.commands;

import de.se_rwth.codecraft.exception.FightException;
import de.se_rwth.codecraft.game.creatures.Creature;
import de.se_rwth.codecraft.game.fight.*;

// Generic Attack Action
public class AttackCommand implements FightCommand
{
	private long _originalHitpoints;
	private Creature _foe;
	private Boolean _successful;
	private long _successRate = 70;
	private String _log;

	public Boolean WasSuccessful()
	{
		return _successful;
	}

	public void IncreaseSuccessRate(int amount)
	{
		_successRate += amount;
	}

	@Override
	public void Execute(FightContext context)
	{
		// Consistency check (cannot execute a command twice in a row)
		if (_foe != null)
			throw new FightException();

		_successful = context.Dice(100) <= _successRate;
		if (!_successful)
		{
			_log = String.format("%1$s Attacked %2$s and missed.",
					context.GetActive().GetModel().GetName(), context.GetPassive().GetModel().GetName());
			return;
		}

		Creature me = context.GetActive().GetModel();
		_foe = context.GetPassive().GetModel();

		long attack = me.GetAttackPower();
		long defense = _foe.GetArmor();

		long damage = attack - defense;
		if (damage < 1)
			damage = 1;

		long health = _foe.GetHealth();
		_originalHitpoints = health;

		health -= damage;
		if (health < 0)
			health = 0;

		_log = String.format("%1$s Attacked %2$s and hit for %3$d.",
				context.GetActive().GetModel().GetName(), context.GetPassive().GetModel().GetName(), damage);

		_foe.SetHealth(health);
	}

	@Override
	public void Rollback()
	{
		if (!_successful)
			return; // nothing to roll back

		_foe.SetHealth(_originalHitpoints);
		_foe = null;
	}

	@Override
	public String GetTextLog()
	{
		return _log;
	}
}
