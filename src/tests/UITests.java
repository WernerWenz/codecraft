package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import tests.creatures.TestCreature;
import de.se_rwth.codecraft.client.CombatLogView;
import de.se_rwth.codecraft.client.HealthView;
import de.se_rwth.codecraft.game.creatures.Swordsman;
import de.se_rwth.codecraft.game.fight.Fight;

public class UITests
{
	/**
	 * Validates CombatLog view
	 */
	@Test
	public void test1() {
		CombatLogView combatLog = new CombatLogView();
		
		// Warning: In case of locating a bug:
		// Actual fight is not deterministic here due to Swordsman.
		Swordsman t1 = new Swordsman(new TestCreature());
		TestCreature t2 = new TestCreature();
		Fight fight = new Fight(t1, t2);

		t1.SetName("Foo");
		t2.SetName("Bar");

		fight.addObserver(combatLog);
		for (int i = 0; fight.NextAction(); i++)
		{
			assertEquals(i+1, combatLog.LogSize());
		}
	}

	/**
	 * Validates synchronization of Creature Model with HealthTracker view
	 */
	@Test
	public void test2() {
		HealthView healthView = new HealthView();
		
		TestCreature t1 = new TestCreature();
		TestCreature t2 = new TestCreature();
		Fight fight = new Fight(t1, t2);

		t1.SetName("Foo");
		t2.SetName("Bar");
		
		healthView.Track(t1);
		healthView.Track(t2);

		while (fight.NextAction()) 
		{
			assertEquals(t1.GetHealth(), healthView.LookupHealthFor(t1));
			assertEquals(t2.GetHealth(), healthView.LookupHealthFor(t2));
		}
	}
}
