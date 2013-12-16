package de.se_rwth.codecraft.game.creatures;

public class CreatureController
{
	private Creature _model;
	
	public CreatureController(Creature model)
	{
		_model = model;
	}
	
	public void TakeDamage(long damage)
	{
		damage -= _model.GetArmor(); 
		long health = _model.GetHealth();
		
		if (damage >= health)
		{
			// Creature died
		}
		else
		{
			health -= damage;
		}

		_model.SetHealth(health);
	}
}
