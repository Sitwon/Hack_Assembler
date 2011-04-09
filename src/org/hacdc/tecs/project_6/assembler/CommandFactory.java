/**
 * A Factory for generating Command objects.
 *
 * This class is responsible for generating an appropriate Command object for
 * the current command string.
 *
 * @author Ben "the Pyrate" Mendis
 */

package org.hacdc.tecs.project_6.assembler;

public class CommandFactory {
	/**
	 * Factory method for Command objects.
	 *
	 * Return an appropriate Command object based on the command string.
	 *
	 * @param command The raw, unparsed command string.
	 */
	public static Command getCommand (String command) {
		if (command.startsWith("@")) {
			return (Command) new ACommand(command);
		}
		return (Command) new CCommand(command);
	}
}

