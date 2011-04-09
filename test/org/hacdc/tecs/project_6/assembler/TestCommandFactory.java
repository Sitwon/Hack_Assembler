package org.hacdc.tecs.project_6.assembler;

import junit.framework.*;

public class TestCommandFactory extends TestCase {
	public TestCommandFactory (String name) {
		super(name);
	}

	public void testACommand () {
		Command c = CommandFactory.getCommand("@0");
		if (!(c instanceof ACommand)) {
			fail("Should be an instance of ACommand.");
		}
	}

	public void testCCommand () {
		Command c = CommandFactory.getCommand("0");
		if (!(c instanceof CCommand)) {
			fail("Should be an instance of CCommand.");
		}

		c = CommandFactory.getCommand("A=0");
		if (!(c instanceof CCommand)) {
			fail("Should be an instance of CCommand.");
		}

		c = CommandFactory.getCommand("0;JMP");
		if (!(c instanceof CCommand)) {
			fail("Should be an instance of CCommand.");
		}

		c = CommandFactory.getCommand("A=0;JMP");
		if (!(c instanceof CCommand)) {
			fail("Should be an instance of CCommand.");
		}
	}
}

