package de.se_rwth.codecraft.game.creatures;

import java.util.Observable;
import java.util.Observer;

public class Orc extends BasicCreature implements Observer
{
	public Boolean _aggressive = false;

	public long GetAttackPower()
	{
		return super.GetAttackPower() + (_aggressive ? 3 : 0);
	}

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

	public void update(Observable o, Object arg)
	{
		_aggressive = true;
	}
}
