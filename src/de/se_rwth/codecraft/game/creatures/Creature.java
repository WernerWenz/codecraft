package de.se_rwth.codecraft.game.creatures;

import de.se_rwth.codecraft.util.Cloneable;

public interface Creature extends Cloneable<Creature> {
	public long getArmor();
	public long getAttackPower();
	public long getHealth();
	public long getMaxHealth();
	public void takeDamage(long damage);
}
