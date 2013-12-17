package de.se_rwth.codecraft.game.fight.controllers;

import de.se_rwth.codecraft.game.creatures.Creature;
import de.se_rwth.codecraft.game.fight.FightCommand;
import de.se_rwth.codecraft.game.fight.FightContext;

/**
 * Any Creatures controller has to implement this Interface.
 * The CreatureController defines how a given Creature behaves during combat.
 * The combats history/context can be accessed via context, when
 * a new action is requested.
 *
 * Purpose of this interface is decoupling combat logic from the actual creature model.
 * Any CreatureController needs to supply a constructor of the form of
 * ActualCreatureTypeController(ActualCreatureType creature) {}
 * The actual model instance will be passed here.
 *
 * Due to the use of reflection we unfortunately can't validate the existence at compile time.
 * For details @see de.se_rwth.codecraft.game.fight.Fight
 */

public interface CreatureController
{
	/**
	 * @return The underlying model instance this controller instance takes care of
	 */
	public Creature GetModel();

	/**
	 *
	 * @param context the context of the fight
	 * @return a new action to perform next
	 */
	public FightCommand SelectAction(FightContext context);
}
