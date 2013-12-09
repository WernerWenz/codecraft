package de.se_rwth.codecraft.game.areas;

import de.se_rwth.codecraft.game.creatures.*;

import java.util.Set;
import java.util.HashSet;

public class AbstractArea implements Area
{
	protected Set<Creature> creatures;

	public AbstractArea()
	{
		creatures = new HashSet<Creature>();
	}
}
