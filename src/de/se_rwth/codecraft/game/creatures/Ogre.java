package de.se_rwth.codecraft.game.creatures;

public class Ogre extends BasicCreature
{
	public Ogre()
	{
		super(200, 200, 20, 20);
	}

	public Ogre Clone()
	{
		Ogre ogre = new Ogre();
		ogre.CopyFrom(this); // clone this exact entity
		return ogre;
	}
}
