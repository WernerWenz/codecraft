package de.se_rwth.codecraft.game.creatures;

public class CreatureDecorator implements Creature
{
	protected Creature decoratedCreature;

	public long GetArmor(){ return decoratedCreature.GetArmor();  }
	public long GetAttackPower() { return decoratedCreature.GetAttackPower(); }
	public long GetHealth() { return decoratedCreature.GetHealth(); }
	public void SetHealth(long damage) { decoratedCreature.SetHealth(damage); }
	public long GetMaxHealth() { return decoratedCreature.GetMaxHealth(); }

	CreatureDecorator(Creature decoratedCreature)
	{
		this.decoratedCreature = decoratedCreature;
	}

	public Creature Clone()
	{
		return new CreatureDecorator(decoratedCreature);
	}
}
