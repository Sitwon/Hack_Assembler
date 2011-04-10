package org.hacdc.tecs.project_6.assembler;

import junit.framework.*;

public class TestACommand extends TestCase {
	public TestACommand (String name) {
		super(name);
	}

	public void testACommand () {
		ACommand ac = new ACommand("@0");
		assertEquals("The address should be '0'.", "0", ac.getAddress());
		try {
			ac = new ACommand("@");
			fail("This should fail, address is missing.");
		} catch (IllegalArgumentException ex) {
			assertTrue(true);
		}
	}
}

