package de.se_rwth.codecraft.game.creatures;

public class CreatureDecorator implements Creature
{
	protected Creature decoratedCreature;

	public long GetArmor(){ return decoratedCreature.GetArmor();  }
	public long GetAttackPower() { return decoratedCreature.GetAttackPower(); }
	public long GetHealth() { return decoratedCreature.GetHealth(); }
	public long GetMaxHealth() { return decoratedCreature.GetMaxHealth(); }
	public void TakeDamage(long damage) { decoratedCreature.TakeDamage(damage); }

	CreatureDecorator(Creature decoratedCreature)
	{
		this.decoratedCreature = decoratedCreature;
	}

	public Creature Clone()
	{
		return new CreatureDecorator(decoratedCreature);
	}
}
