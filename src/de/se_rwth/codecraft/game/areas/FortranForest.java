package de.se_rwth.codecraft.game.areas;

import de.se_rwth.codecraft.game.creatures.*;

import java.util.Random;

public class FortranForest extends AbstractArea {
	private String name = "Ups, forest with pythons";
	private Integer numberOfCreatures = 10;
	private Integer length = 10000;
	private Integer width = 10000;
	
	private Random randomNumbers;
	
	public FortranForest() {
		randomNumbers = new Random();
		
		for (int i = 0; i < 10; i++) {
			Creature creature = null;
			
			switch (randomNumbers.nextInt(3)) {
				case 0:
					creature = new Orc();
					break;
				case 1:
					creature = new Ogre();
					break;
				case 2:
					creature = new Goblin();
					break;
			}
			
			creatures.add(creature);
		}
	}
}
