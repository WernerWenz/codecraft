package de.se_rwth.codecraft.game.creatures;


public class Swordsman extends CreatureDecorator
{
	public Swordsman(Creature decoratedCreature) { super(decoratedCreature); }

	@Override
	public long GetAttackPower()
	{
		return super.GetAttackPower() + 10;
	}

	@Override
	public Creature Clone()
	{
		return new Swordsman(decoratedCreature);
	}
}
