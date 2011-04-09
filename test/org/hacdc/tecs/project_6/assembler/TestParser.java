package org.hacdc.tecs.project_6.assembler;

import junit.framework.*;

public class TestParser extends TestCase {
	public TestParser (String name) {
		super(name);
	}

	public void testConstructor () {
		try {
			Parser parser = new Parser(null);
			fail("Passing null should throw an exception.");
		} catch (IllegalArgumentException ex) {
			assertTrue(true);
		}
	}
}

