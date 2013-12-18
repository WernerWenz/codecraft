package de.se_rwth.codecraft.client;

import java.util.Observable;
import java.util.Observer;

import de.se_rwth.codecraft.exception.NotImplementedException;
import de.se_rwth.codecraft.game.fight.Fight;
import de.se_rwth.codecraft.game.fight.FightCommand;

public class CombatView implements Observer
{
	@Override
	public void update(Observable sender, Object arg)
	{
		Fight fight = (Fight)sender;
		FightCommand command = (FightCommand)arg;

		// Do some fancy UI here based on the current Fight state (fight)
		// and the currently executed fight action (command)
		//
		// In practice they need to expose little more information as of now.
		// We don't implement any fancy UI here as this is out of the scope of
		// the exercise. The View works identical to CombatLogView.

		throw new NotImplementedException();
	}
}
