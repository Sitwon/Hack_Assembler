/**
 * An object-oriented solution to the Chapter 6 project using Java.
 *
 * @author		Ben "the Pyrate" Mendis
 */

package org.hacdc.tecs.project_6.assembler;

import java.io.*;

public class Main {
	protected static Code code = new Code();

	/**
	 * The entry-point for the application.
	 *
	 * Usage: java assembler.jar &lt;input file&gt;
	 *
	 * @param args The command-line arguments.
	 */
	public static void main (String[] args) {
		if (args.length != 1) {
			System.err.println(printUsage());
			System.exit(1);
		}
		try {
			Parser parser = new Parser(new FileInputStream(args[0]));
			while (parser.hasMoreCommands()) {
				try {
					System.out.println(code.translate(parser.nextCommand()));
				} catch (IllegalCommandException ex) {
					System.err.println(ex.getMessage());
					System.exit(3);
				}
			}
		} catch (FileNotFoundException ex) {
			System.err.println("Error: Input file was not found.");
			System.exit(2);
		}
	}

	protected static String printUsage () {
		return "Usage: java -jar assembler.jar <input file>";
	}
}

