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
	/**
	 * Constructor.
	 *
	 * @args input An InputStream containing the assembly language commands.
	 */
	public Parser (InputStream input) {
		if (input == null) {
			throw new IllegalArgumentException("The input argument cannot be null.");
		}

		BufferedReader input_reader = new BufferedReader(new InputStreamReader(input));
		try {
			String line;
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

				// Add the command to the commandList
				this.commandList.add(CommandFactory.getCommand(line));
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}

