/**
 * A parsed A-Command.
 *
 * Gives us tools for handling A-Commands.
 *
 * @author Ben "the Pyrate" Mendis
 */

package org.hacdc.tecs.project_6.assembler;

public class ACommand extends Command {
	protected final String address;

	/**
	 * Constructor for ACommand.
	 *
	 * A-Commands are address commands. They assign a vaule to the A register,
	 * which is a dual-purpose register used for both data and addressing RAM.
	 *
	 * @param command The raw, unparsed A-Command.
	 */
	public ACommand (String command) {
		this.command = command;
		this.address = command.substring(1);
	}

	/**
	 * Getter for the parsed address field.
	 */
	public String getAddress () {
		return this.address;
	}
}

