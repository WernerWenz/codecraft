package de.se_rwth.codecraft.client;

import java.util.HashMap;
import java.util.Observable;
import java.util.Observer;

import de.se_rwth.codecraft.game.creatures.BasicCreature;
import de.se_rwth.codecraft.game.creatures.Creature;

public class HealthView implements Observer
{
	// represents the Labels for HP
	HashMap<Creature, Long> _creatures = new HashMap<Creature, Long>();

	public void Track(Creature creature)
	{
		BasicCreature basicCreature = (BasicCreature)creature;
		basicCreature.addObserver(this);

		// Create the initial label here
		_creatures.put(creature, creature.GetHealth());
	}

	@Override
	public void update(Observable sender, Object arg)
	{
		BasicCreature creature = (BasicCreature)sender;
		long health = creature.GetHealth();

		// remove the label and don't track the creature anymore
		if (health == 0)
			creature.deleteObserver(this);

		// update the label, in a real UI this would likely be a method call
		_creatures.put(creature, health);
	}

	/**
	 * Only for Unit testing
	 */
	public long	LookupHealthFor(Creature creature)
	{
		return _creatures.get(creature);
	}

}
