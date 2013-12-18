package de.se_rwth.codecraft.game.creatures;

public class ArmoredCreature extends CreatureDecorator
{
	private long _armor;

	public ArmoredCreature(Creature decoratedCreature, long armor)
	{
		super(decoratedCreature);
		_armor = armor;
	}

	@Override
	public long GetArmor()
	{
		return super.GetArmor() + _armor;
	}

	@Override
	public Creature Clone()
	{
		return new ArmoredCreature(decoratedCreature, _armor);
	}

	@Override
	public String GetName()
	{
		return String.format("%1$s with an Armor", super.GetName());
	}
}
