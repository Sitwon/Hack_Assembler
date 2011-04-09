/**
 * A parsed Command.
 *
 * Abstract class from which all command types will inherit.
 *
 * @author Ben "the Pyrate" Mendis
 */

package org.hacdc.tecs.project_6.assembler;

public abstract class Command {
	protected final String command;

	public final String getCommand () {
		return command;
	}
}

