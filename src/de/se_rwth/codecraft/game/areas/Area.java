package de.se_rwth.codecraft.game.areas;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import de.se_rwth.codecraft.game.creatures.Creature;

public class Area
{
	private String _name;
	private int _width;
	private int _height;
	private Set<Creature> _creatures = new HashSet<Creature>();

	public int GetWidth() { return _width; }
	public int GetHeight() { return _height; }
	public String GetName() { return _name; }
	public Collection<Creature> GetCreatures() { return _creatures; }

	public void SpawnCreatures(Collection<Creature> creatures)
	{
		_creatures.addAll(creatures);
	}

	public Area(String name, int width, int height, HashSet<Creature> creatures)
	{
		_name = name;
		_width = width;
		_height = height;
		_creatures = creatures;
	}
}
