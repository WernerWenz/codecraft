package de.se_rwth.codecraft.game.creatures;

public class Goblin extends BasicCreature
{
	public Goblin()
	{
		super(80, 80, 3, 1);
	}

	public Goblin Clone()
	{
		Goblin goblin = new Goblin();
		goblin.CopyFrom(this); // clone this exact entity
		return goblin;
	}
}
