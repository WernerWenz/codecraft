package de.se_rwth.codecraft.game.creatures;

public class Orc extends BasicCreature
{
	public Orc()
	{
		super(100, 100, 4, 10);
	}

	public Orc Clone()
	{
		Orc orc = new Orc();
		orc.CopyFrom(this); // clone this exact entity
		return orc;
	}
}
