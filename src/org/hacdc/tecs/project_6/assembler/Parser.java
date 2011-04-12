/**
 * Encapsulates access to the input code.
 *
 * Encapsulates access to the input code. Reads an assembly language command,
 * parses it, and provides convenient access to the command's components
 * (fields and symbols). In addition, removes all white space and comments.
 *
 * @author Ben "the Pyrate" Mendis
 */

package org.hacdc.tecs.project_6.assembler;

import java.io.*;
import java.util.ArrayList;

public class Parser {
	protected ArrayList<Command> commandList = new ArrayList<Command>();
	protected int position = 0;

	/**
	 * Constructor.
	 *
	 * @param input An InputStream containing the assembly language commands.
	 */
	public Parser (InputStream input) {
		if (input == null) {
			throw new IllegalArgumentException("The input argument cannot be null.");
		}

		BufferedReader input_reader = new BufferedReader(new InputStreamReader(input));
		try {
			String line;
			int line_number = 0;
			while ((line = input_reader.readLine()) != null) {
				line = line.trim();

				// Strip off comments
				if (line.indexOf("//") != -1) {
					line = line.substring(0, line.indexOf("//")).trim();
				}

				// If the line was blank or only comments, skip it
				if (line.isEmpty()) {
					continue;
				}

				// Process the command
				Command command = CommandFactory.getCommand(line);
				if (command instanceof LCommand) {
					Main.symbol_table.addEntry(((LCommand) command).getName(), line_number);
				} else {
					// Add the command to the commandList
					this.commandList.add(command);
					line_number++;
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	/**
	 * Checks if there are any commands left in the stream.
	 *
	 * @return true if there are unread Commands, otherwise false.
	 */
	public boolean hasMoreCommands () {
		if (this.position >= this.commandList.size()) {
			return false;
		}
		return true;
	}

	/**
	 * Get the next command from the stream.
	 *
	 * @return the next Command in the stream, or null if no Commands are left.
	 */
	public Command nextCommand () {
		if (!this.hasMoreCommands()) {
			return null;
		}
		Command c = this.commandList.get(this.position);
		this.position += 1;
		return c;
	}
}

