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

	public ACommand (String command) {
		this.command = command;
		this.address = command.substring(1);
	}

	public String getAddress () {
		return this.address;
	}
}

