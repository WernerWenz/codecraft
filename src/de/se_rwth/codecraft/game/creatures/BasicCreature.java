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

	public void TakeDamage(long damage)
	{
		damage -= GetArmor(); // This will horribly break the Decorator usage!
		// This bug is here in place on purpose, in order to demonstrate
		// a downside for 7.3e)

		if (damage >= GetHealth())
		{
			// The poor creature died
			_health = 0;
		}
		else
			_health -= damage;

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
