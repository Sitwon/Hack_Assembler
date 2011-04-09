/**
 * An exception representing an illegal or malformed command.
 *
 * @author Ben "the Pyrate" Mendis
 */

package org.hacdc.tecs.project_6.assembler;

public class IllegalCommandException extends RuntimeException {
	public IllegalCommandException () {
		super();
	}

	public IllegalCommandException (String message) {
		super(message);
	}

	public IllegalCommandException (String message, Throwable cause) {
		super(message, cause);
	}

	public IllegalCommandException (Throwable cause) {
		super(cause);
	}
}

