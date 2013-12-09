package de.se_rwth.codecraft.game.creatures;

public interface Creature {
	public long getArmor();
	public long getAttackPower();
	public long getHealth();
	public long getMaxHealth();
	public void takeDamage(long damage);
}
