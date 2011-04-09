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

	public String getDest () {
		return this.dest;
	}

	public String getComp () {
		return this.comp;
	}

	public String getJump () {
		return this.jump;
	}
}

