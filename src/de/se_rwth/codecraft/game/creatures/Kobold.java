package de.se_rwth.codecraft.game.creatures;

public class Kobold extends BasicCreature
{
	public Kobold()
	{
		super(70, 70, 2, 1);
	}

	public Kobold Clone()
	{
		Kobold kobold = new Kobold();
		kobold.CopyFrom(this); // clone this exact entity
		return kobold;
	}
}

