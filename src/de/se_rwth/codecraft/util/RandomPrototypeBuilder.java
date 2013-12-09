package de.se_rwth.codecraft.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

// TODO: Rename, as this is not a Builder pattern, which might be confusing.
/**
 * This class realizes a generating system, which clones an arbitrary
 * number of randomly chosen Prototypes, given to the system.
 * @author WernerW
 *
 * @param <T> The cloneable base Type
 */
public class RandomPrototypeBuilder<T extends Cloneable<T>>
{
	// We are not expecting many prototypes to be added during runtime thus a simple ArrayList suffices
	private List<T> _prototypes= new ArrayList<T>();

	// The rng used to generate Creatures
	private Random _random;

	/**
	 * Adds a Prototype for cloning
	 * @param prototype The Prototype to be added
	 */
	public void AddPrototype(T prototype)
	{
		if (prototype == null)
			throw new IllegalArgumentException("Prototype must not be null");

		if (_prototypes.contains(prototype))
			throw new IllegalArgumentException("Prototype already added");

		_prototypes.add(prototype);
	}

	public RandomPrototypeBuilder(Random random)
	{
		_random = random;
	}

	public RandomPrototypeBuilder()
	{
		_random = new Random();
	}

	/**
	 * Selects a random Prototype and clones it.
	 * @return The cloned instance
	 */
	public T CreateOne()
	{
		int index = _random.nextInt(_prototypes.size());
		return _prototypes.get(index).Clone();
	}

	/**
	 * Selects count times a random Prototype and clones it
	 * @param count The number of clones to generate
	 * @return The clones.
	 */
	public List<T> Create(int count)
	{
		List<T> clones = new ArrayList<T>(count);
		for (int i = 0; i < count; i++)
			clones.add( CreateOne() );

		return clones;
	}
}
