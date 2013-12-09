package tests;

import static org.junit.Assert.*;

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

		// This test reveals a Problem, we got ourself with using a Decorator:
		// ArmoredCreature only overrode the GetArmor() but
		// delegates the TakeDamage to wrapped Goblin (BaseCreature)
		// which of course, does not know anything about being wrapped.
		// Thats why we'd either need to override TakeDamage and rewrite
		// it's logic, or do the Creature Logic at a different place,
		// like a Creature Controller, which operates only on the wrapped objects.
		boomBoltBlackpowder.TakeDamage(expectedArmor + 4);
		assertEquals(boomBoltBlackpowder.GetMaxHealth() - 4, boomBoltBlackpowder.GetHealth());
	}

	@Test
	public void test2() {
		Creature goblin = new Goblin();
		Creature armoredGoblin = new ArmoredCreature(goblin, 0);
		armoredGoblin.TakeDamage(14);
		assertEquals(69, armoredGoblin.Clone().GetHealth());
	}

}
