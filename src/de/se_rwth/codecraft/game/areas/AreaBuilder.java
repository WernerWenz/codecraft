package de.se_rwth.codecraft.game.areas;

import java.util.HashSet;

import de.se_rwth.codecraft.game.creatures.Creature;
import de.se_rwth.codecraft.game.creatures.CreatureBuilder;

public class AreaBuilder
{
	// Build context
	private CreatureBuilder _creatureBuilder = new CreatureBuilder();
	private HashSet<Creature> _creatures = new HashSet<Creature>();
	private String _name;
	private int _width;
	private int _height;
	
	public AreaBuilder SetWidth(int width)
	{
		_width = width;
		return this;
	}
	
	public AreaBuilder SetHeight(int height)
	{
		_height = height;
		return this;
	}
	
	public AreaBuilder SetName(String name)
	{
		_name = name;
		return this;
	}
	
	public AreaBuilder AddCreature(Creature prototype)
	{
		_creatureBuilder.AddPrototype(prototype);
		return this;
	}
	
	public AreaBuilder Populate(int count)
	{
		_creatures.addAll( _creatureBuilder.Create(count) );
		return this;
	}
	
	public Area Build()
	{
		return new Area(_name, _width, _height, _creatures);
	}
}
