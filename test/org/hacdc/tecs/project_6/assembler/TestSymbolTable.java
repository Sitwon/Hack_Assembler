package org.hacdc.tecs.project_6.assembler;

import junit.framework.*;

public class TestSymbolTable extends TestCase {
	public TestSymbolTable (String name) {
		super(name);
	}

	public void testPredefinedSymbols () {
		SymbolTable st = new SymbolTable();
		assertTrue(st.contains("SP"));
		assertTrue(0 == st.getAddress("SP"));
		assertTrue(st.contains("LCL"));
		assertTrue(1 == st.getAddress("LCL"));
		assertTrue(st.contains("ARG"));
		assertTrue(2 == st.getAddress("ARG"));
		assertTrue(st.contains("THIS"));
		assertTrue(3 == st.getAddress("THIS"));
		assertTrue(st.contains("THAT"));
		assertTrue(4 == st.getAddress("THAT"));
		assertTrue(st.contains("SCREEN"));
		assertTrue(16384 == st.getAddress("SCREEN"));
		assertTrue(st.contains("KBD"));
		assertTrue(24576 == st.getAddress("KBD"));
		assertTrue(st.contains("R0"));
		assertTrue(0 == st.getAddress("R0"));
		assertTrue(st.contains("R15"));
		assertTrue(15 == st.getAddress("R15"));
		assertFalse(st.contains("R16"));
	}

	public void testAddEntry () {
		SymbolTable st = new SymbolTable();
		st.addEntry("TEST", new Integer(7));
		assertTrue(st.contains("TEST"));
		assertTrue(7 == st.getAddress("TEST"));
		st.addEntry("NEW", 10);
		assertTrue(st.contains("NEW"));
		assertTrue(10 == st.getAddress("NEW"));
	}

	public void testRegisterVariable () {
		SymbolTable st = new SymbolTable();
		assertEquals(16, st.registerVariable("NEW"));
		assertTrue(16 == st.getAddress("NEW"));
		assertEquals(17, st.registerVariable("TEST"));
		assertTrue(17 == st.getAddress("TEST"));
		assertEquals(17, st.registerVariable("TEST"));
		assertEquals(18, st.registerVariable("another"));
		assertTrue(18 == st.getAddress("another"));
	}
}

