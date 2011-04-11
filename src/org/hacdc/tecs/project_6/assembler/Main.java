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
		try {
			Parser parser = new Parser(new FileInputStream(args[0]));
			while (parser.hasMoreCommands()) {
				System.out.println(code.translate(parser.nextCommand()));
			}
		} catch (FileNotFoundException ex) {
			System.err.println("Error: Input file was not found.");
		}
	}
}

