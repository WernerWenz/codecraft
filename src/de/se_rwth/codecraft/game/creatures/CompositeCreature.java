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
	
	public void SetHealth(long damage)
	{ 
		// Doesn't make sense anymore when using the controller
		// But this composite was illogical and made up anyway.
		// It's sole purpose of existence were the requirements of the exercise.
		throw new NotImplementedException();
	}
	
	public CompositeCreature Clone()
	{
		// Clone the group-state or clone every entity inside?
		throw new NotImplementedException();
	}

	@Override
	public String GetName()
	{
		throw new NotImplementedException();
	}

	@Override
	public void SetName(String name)
	{
		throw new NotImplementedException();
	}
}
