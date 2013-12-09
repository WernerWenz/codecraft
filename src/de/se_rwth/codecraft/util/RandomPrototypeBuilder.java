package de.se_rwth.codecraft.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class RandomPrototypeBuilder<T extends Cloneable<T>>
{
	// We are not expecting many prototypes to be added during runtime thus a simple ArrayList suffices
	private List<T> _prototypes= new ArrayList<T>();

	// The rng used to generate Creatures
	private Random _random;

	public void AddPrototype(T prototype)
	{
		if (prototype == null)
			throw new IllegalArgumentException("Prototype must not be null");

		if (_prototypes.contains(prototype))
			throw new IllegalArgumentException("Prototype already added");
	}

	public RandomPrototypeBuilder(Random random)
	{
		_random = random;
	}

	public RandomPrototypeBuilder()
	{
		_random = new Random();
	}

	public T CreateOne()
	{
		int index = _random.nextInt(_prototypes.size());
		return _prototypes.get(index).Clone();
	}

	public List<T> Create(int count)
	{
		List<T> clones = new ArrayList<T>(count);
		for (int i = 0; i < count; i++)
			clones.add( CreateOne() );

		return clones;
	}
}
