package org.hacdc.tecs.project_6.assembler;

import junit.framework.*;

public class TestCCommand extends TestCase {
	public TestCCommand (String name) {
		super(name);
	}

	public void testComp () {
		CCommand cc = new CCommand("0");
		assertEquals("The comp should be '0'.", "0", cc.getComp());
	}

	public void testDest () {
		CCommand cc = new CCommand("A=0");
		assertEquals("The comp should be '0'.", "0", cc.getComp());
		assertEquals("The dest should be 'A'.", "A", cc.getDest());
	}

	public void testJump () {
		CCommand cc = new CCommand("0;JMP");
		assertEquals("The comp should be '0'.", "0", cc.getComp());
		assertEquals("The jump should be 'JMP'.", "JMP", cc.getJump());
	}

	public void testAll () {
		CCommand cc = new CCommand("A=0;JMP");
		assertEquals("The comp should be '0'.", "0", cc.getComp());
		assertEquals("The dest should be 'A'.", "A", cc.getDest());
		assertEquals("The jump should be 'JMP'.", "JMP", cc.getJump());
	}
}

