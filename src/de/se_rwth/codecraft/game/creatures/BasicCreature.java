package de.se_rwth.codecraft.game.creatures;

import java.util.Observable;

public abstract class BasicCreature extends Observable implements Creature
{
	private long _health;
	private long _maxHealth;
	private long _armor;
	private long _attackPower;

	public long GetArmor() { return _armor; }
	public long GetAttackPower() { return _attackPower; }
	public long GetHealth() { return _health; }
	public long GetMaxHealth() { return _maxHealth; }

	public void SetHealth(long health)
	{
		if (_health == health)
			return;
		_health = health;
		setChanged();
		notifyObservers();
	}

	public BasicCreature(long health, long maxHealth, long armor, long attackPower)
	{
		_health = health;
		_maxHealth = maxHealth;
		_armor = armor;
		_attackPower = attackPower;
	}

	protected void CopyFrom(BasicCreature prototype)
	{
		_health = prototype._health;
		_maxHealth = prototype._maxHealth;
		_armor = prototype._armor;
		_attackPower = prototype._armor;
	}
}
