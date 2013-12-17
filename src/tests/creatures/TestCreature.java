package tests.creatures;

import de.se_rwth.codecraft.game.creatures.BasicCreature;

public class TestCreature extends BasicCreature
{
	public TestCreature()
	{
		super(80, 80, 1, 3);
	}

	public TestCreature Clone()
	{
		TestCreature test = new TestCreature();
		test.CopyFrom(this); // clone this exact entity
		return test;
	}
}
