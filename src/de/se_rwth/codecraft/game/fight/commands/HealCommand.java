package de.se_rwth.codecraft.game.fight.commands;

import de.se_rwth.codecraft.game.creatures.Creature;
import de.se_rwth.codecraft.game.fight.*;

// Generic Heal Action
public class HealCommand implements FightCommand
{
	private long _hitpoints;
	private long _originalHP;
	private Creature _me;

	public HealCommand(int hitpoints)
	{
		_hitpoints = hitpoints;
	}

	@Override
	public void Execute(FightContext context)
	{
		_me = context.GetActive().GetModel();

		_originalHP = _me.GetHealth();
		long maxHealth = _me.GetMaxHealth();
		long newHP = _originalHP + _hitpoints;
		if (newHP > maxHealth)
			newHP = maxHealth;

		_me.SetHealth(newHP);
	}

	@Override
	public void Rollback()
	{
		_me.SetHealth(_originalHP);
	}
}
