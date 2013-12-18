package de.se_rwth.codecraft.client;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;


//import de.se_rwth.codecraft.game.fight.Fight;
import de.se_rwth.codecraft.game.fight.FightCommand;

public class CombatLogView implements Observer
{
	private List<String> _backlog = new ArrayList<String>();

	@Override
	public void update(Observable sender, Object data)
	{
		//Fight fight = (Fight)sender;
		FightCommand round = (FightCommand)data;

		String log = round.GetTextLog();
		_backlog.add(log);
		System.out.println(log);
	}

	public int LogSize()
	{
		return _backlog.size();
	}

}
