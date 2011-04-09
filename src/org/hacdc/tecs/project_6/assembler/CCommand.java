/**
 * A parsed C-Command.
 *
 * Gives us tools for handling C-Commands.
 *
 * @author Ben "the Pyrate" Mendis
 */

package org.hacdc.tecs.project_6.assembler;

public class CCommand extends Command {
	protected final String dest;
	protected final String comp;
	protected final String jump;

	/**
	 * Constructor for CCommand.
	 *
	 * C-Commands are computation commands. They instruct the CPU to perform a
	 * computation. They result can be optionally stored into a register or
	 * RAM address. The command can also optionally jump to a different
	 * ROM location based on the result of the computation.
	 *
	 * @param command The raw, unparsed C-Command.
	 */
	public CCommand (String command) {
		this.command = command;
		int dest_pos = command.indexOf("=");
		if (dest_pos != -1) {
			this.dest = command.substring(0, dest_pos);
			command = command.substring(dest_pos + 1);
		} else {
			this.dest = null;
		}
		int jump_pos = command.indexOf(";");
		if (jump_pos != -1) {
			this.jump = command.substring(jump_pos + 1, command.length());
			command = command.substring(0, jump_pos);
		} else {
			this.jump = null;
		}
		this.comp = command;
	}

	/**
	 * Getter for the destination field.
	 *
	 * This field is optional. If the command has no destination this
	 * method will return null.
	 */
	public String getDest () {
		return this.dest;
	}

	/**
	 * Getter for the computation field.
	 *
	 * This field is mandatory.
	 */
	public String getComp () {
		return this.comp;
	}

	/**
	 * Getter for the jump field.
	 *
	 * This field is optional. If the command has no jump this method
	 * will return null.
	 */
	public String getJump () {
		return this.jump;
	}
}

