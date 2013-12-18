package de.se_rwth.codecraft.game.creatures;

import de.se_rwth.codecraft.util.Cloneable;

public interface Creature extends Cloneable<Creature>
{
	public long GetArmor();
	public long GetAttackPower();
	public long GetHealth();
	public void SetHealth(long damage);
	public long GetMaxHealth();
	public String GetName();
	public void SetName(String name);
}
