package de.se_rwth.codecraft.game.creatures;

import de.se_rwth.codecraft.exception.*;

public class Orc implements Creature
{
	public long getArmor(){ throw new NotImplementedException(); }
	public long getAttackPower() { throw new NotImplementedException(); }
	public long getHealth() { throw new NotImplementedException(); }
	public long getMaxHealth() { throw new NotImplementedException(); }
	public void takeDamage(long damage) { throw new NotImplementedException(); }
	public Orc Clone() { throw new NotImplementedException(); }
}
