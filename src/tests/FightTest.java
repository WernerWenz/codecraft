package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import tests.creatures.TestCreature;
import de.se_rwth.codecraft.game.fight.Fight;

public class FightTest {

	@Test
	public void test() {
		// Test fight commands, using a deterministic Creature
		TestCreature t1 = new TestCreature();
		TestCreature t2 = new TestCreature();

		Fight fight = new Fight(t1, t2);

		assertEquals(80, t1.GetHealth());
		assertEquals(80, t2.GetHealth());

		fight.NextAction(); // Attack command (t1 attacks t2)
		assertEquals(80, t1.GetHealth());
		assertEquals(78, t2.GetHealth());

		fight.NextAction(); // Attack command (t2 attacks t1)
		assertEquals(78, t1.GetHealth());
		assertEquals(78, t2.GetHealth());

		fight.NextAction(); // Attack command (t1 attacks t2)
		assertEquals(78, t1.GetHealth());
		assertEquals(76, t2.GetHealth());

		fight.NextAction(); // Roll back command (t2 cancels t1's attack from before)
		assertEquals(78, t1.GetHealth());
		assertEquals(78, t2.GetHealth());

		fight.NextAction(); // Attack command (t1 attacks t2)
		assertEquals(78, t1.GetHealth());
		assertEquals(76, t2.GetHealth());

		fight.NextAction(); // Roll back command (t2 cancels t1's attack from before)
		assertEquals(78, t1.GetHealth());
		assertEquals(78, t2.GetHealth());

		fight.NextAction(); // Roll back command (t1 cancels t2's cancellation)
		assertEquals(78, t1.GetHealth());
		assertEquals(76, t2.GetHealth());

		fight.NextAction(); // Roll back command (t2 cancels t1's cancellation of the cancellation)
		assertEquals(78, t1.GetHealth());
		assertEquals(78, t2.GetHealth());

		fight.NextAction(); // Heal action (t1 heals itself by 1hp)
		assertEquals(79, t1.GetHealth());
		assertEquals(78, t2.GetHealth());

		fight.NextAction(); // Heal action (t2 heals itself by 100hp)
		assertEquals(79, t1.GetHealth());
		assertEquals(80, t2.GetHealth());

		// run till end of fight
		while (fight.NextAction()) {}
		assertEquals(1, t1.GetHealth());
		assertEquals(0, t2.GetHealth());
	}

}
