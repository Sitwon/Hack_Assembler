/**
 * A parsed L-Command.
 *
 * Gives us tools for handling L-Commands.
 *
 * @author Ben "the Pyrate" Mendis
 */

package org.hacdc.tecs.project_6.assembler;

public class LCommand extends Command {
	protected final String name;

	/**
	 * Constructor for LCommand.
	 *
	 * L-Commands are label commands. They are pseudo commands which
	 * indicate a jump location in the code.
	 *
	 * @param command The raw, unparsed L-Command.
	 */
	public LCommand (String command) {
		if ((command == null) || (command.length() < 3)) {
			throw new IllegalArgumentException("Invalid L-Command.");
		}
		this.command = command;
		this.name = command.substring(1, command.length() - 1);
	}

	/**
	 * Getter for the parsed address field.
	 */
	public String getName () {
		return this.name;
	}
}

