package de.se_rwth.codecraft.game.fight;

/**
 * This interfaces defines a Fight command.
 * For certain situations, like the "TempusRetorqueo" it shall be
 * possible to roll back any operation.
 *
 * Rather than making a copy of the creature states after each Turn,
 * we expect the actual commands to store any state differences,
 * or, if required, make a full snapshot.
 */
public interface FightCommand
{
	/**
	 * @param context Context to execute the command within.
	 * This can be used to query information about the participating Creatures.
	 */
	void Execute(FightContext context);

	/**
	 * Rolls back a previous Executed()'d command.
	 * Implementors must guarantee that it is possible to re-execute a command
	 * after a rollback is issued in order to allow rollbacks of rollbacks.
	 */
	void Rollback();

	/**
	 * @return A Textual Log of the Fight action
	 */
	String GetTextLog();
}
