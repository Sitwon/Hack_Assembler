/**
 * A parsed Command.
 *
 * Abstract class from which all command types will inherit.
 *
 * @author Ben "the Pyrate" Mendis
 */

package org.hacdc.tecs.project_6.assembler;

public abstract class Command {
	protected String command;

	/**
	 * Getter for the raw, unparsed command string.
	 */
	public final String getCommand () {
		return command;
	}
}

