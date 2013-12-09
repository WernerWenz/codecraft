package de.se_rwth.codecraft.game.areas;

import de.se_rwth.codecraft.game.creatures.*;

import java.util.Random;

public class FortranForest extends AbstractArea {
	private String name = "Ups, forest with pythons";
	private Integer numberOfCreatures = 10;
	private Integer length = 10000;
	private Integer width = 10000;
	
	public FortranForest() {
		CreatureBuilder creatureBuilder = new CreatureBuilder();
		creatureBuilder.AddPrototype(new Orc());
		creatureBuilder.AddPrototype(new Ogre());
		creatureBuilder.AddPrototype(new Goblin());

		creatures.addAll(creatureBuilder.Create(numberOfCreatures));
	}
}
