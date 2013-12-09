package de.se_rwth.codecraft.game.creatures;

import java.util.List;
import java.util.ArrayList;

import de.se_rwth.codecraft.exception.NotImplementedException;

/**
 * Realizes a group of Creatures
 */
public class CompositeCreature implements Creature
{
	private List<Creature> _creatures = new ArrayList<Creature>();
	
	public void Add(Creature creature)
	{
		_creatures.add(creature);
	}
	
	public void Remove(Creature creature)
	{
		_creatures.remove(creature);
	}

	// In a real game's context, the following operations don't really make sense on "groups" of mobs.
	// What would for example be armor of a group?
	public long GetArmor() { throw new NotImplementedException(); }
	public long GetAttackPower() { throw new NotImplementedException(); }
	public long GetHealth() { throw new NotImplementedException(); }
	public long GetMaxHealth() { throw new NotImplementedException(); }
	
	// Do damage to all mobs, testing the composite
	public void TakeDamage(long damage) 
	{ 
		for (Creature creature : _creatures)
			creature.TakeDamage(damage);
	}
	
	public CompositeCreature Clone()
	{
		// Clone the group-state or clone every entity inside?
		throw new NotImplementedException();
	}
}
