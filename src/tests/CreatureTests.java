package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import de.se_rwth.codecraft.game.creatures.*;

public class CreatureTests {

	@Test
	public void test1() {
		long armor = 3;
		Creature goblin = new Goblin();
		Creature armoredGoblin = new ArmoredCreature(goblin, armor);

		// Create an armored Goblin
		Creature boomBoltBlackpowder = armoredGoblin.Clone();

		long expectedArmor = goblin.GetArmor() + armor;
		assertEquals(expectedArmor, armoredGoblin.GetArmor());
		assertEquals(expectedArmor, boomBoltBlackpowder.GetArmor());

		(new CreatureController(boomBoltBlackpowder)).TakeDamage(expectedArmor + 4);
		assertEquals(boomBoltBlackpowder.GetMaxHealth() - 4, boomBoltBlackpowder.GetHealth());
	}

	@Test
	public void test2() {
		Creature goblin = new Goblin();
		Creature armoredGoblin = new ArmoredCreature(goblin, 0);

		(new CreatureController(armoredGoblin)).TakeDamage(14);
		assertEquals(69, armoredGoblin.Clone().GetHealth());
	}

	@Test
	public void test3() {
		Creature goblin = new Goblin();
		
		List<Creature> goblins = new ArrayList<Creature>();
		CompositeCreature army = new CompositeCreature();
		for (int i = 0; i < 5; i++)
		{
			Creature gob = goblin.Clone();
			goblins.add(gob);
			army.Add(gob);
		}

		// We don't have any meaningful operation on an army..
		//army.TakeDamage(7);
		//for (Creature creature : goblins)
		//	assertEquals(76, creature.GetHealth());
	}

	@Test
	public void test4() {
		Goblin goblin = new Goblin();
		Orc orc = new Orc();

		long power = orc.GetAttackPower();
		goblin.addObserver(orc);
		(new CreatureController(goblin)).TakeDamage(13);

		assertEquals(power + 3, orc.GetAttackPower());
	}
}
