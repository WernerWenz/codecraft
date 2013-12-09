package tests;

import static org.junit.Assert.*;

import java.util.Collection;

import org.junit.Test;

import de.se_rwth.codecraft.game.areas.*;
import de.se_rwth.codecraft.game.creatures.*;

public class AreaBuilderTests {

	@Test
	public void test() {
		String name = "Ups, forest with pythons";
		int width = 10000;
		int height = 10001;
		int population = 10;
		
		AreaBuilder builder = new AreaBuilder();

		builder.SetName(name);
		builder.SetWidth(width).SetHeight(height);
		builder.AddCreature(new Orc());
		builder.AddCreature(new Ogre());
		builder.AddCreature(new Goblin());
		builder.Populate(population);
		
		Area fortranForest = builder.Build();
		Collection<Creature> creatures = fortranForest.GetCreatures();
		
		assertEquals("Population did not match", creatures.size(), population);
		assertEquals(fortranForest.GetWidth(), width);
		assertEquals(fortranForest.GetHeight(), height);
		assertEquals(fortranForest.GetName(), name);
	}

}
