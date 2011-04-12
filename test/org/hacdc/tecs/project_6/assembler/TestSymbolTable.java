package org.hacdc.tecs.project_6.assembler;

import junit.framework.*;

public class TestSymbolTable extends TestCase {
	public TestSymbolTable (String name) {
		super(name);
	}

	public void testPredefinedSymbols () {
		SymbolTable st = new SymbolTable();
		assertTrue(st.contains("SP"));
		assertEquals(0, st.get("SP"));
		assertTrue(st.contains("LCL"));
		assertEquals(1, st.get("LCL"));
		assertTrue(st.contains("ARG"));
		assertEquals(2, st.get("ARG"));
		assertTrue(st.contains("THIS"));
		assertEquals(3, st.get("THIS"));
		assertTrue(st.contains("THAT"));
		assertEquals(4, st.get("THAT"));
		assertTrue(st.contains("SCREEN"));
		assertEquals(16384, st.get("SCREEN"));
		assertTrue(st.contains("KBD"));
		assertEquals(24576, st.get("KBD"));
		assertTrue(st.contains("R0"));
		assertEquals(0, st.get("R0"));
		assertTrue(st.contains("R15"));
		assertEquals(15, st.get("R15"));
		assertFalse(st.contains("R16"));
	}

	public void testAddEntry () {
		SymbolTable st = new SymbolTable();
		st.addEntry("TEST", new Integer(7));
		assertTrue(st.contains("TEST"));
		assertEquals(7, st.get("TEST"));
		st.addEntry("NEW", 10);
		assertTrue(st.contains("NEW"));
		assertEquals(10, st.get("NEW"));
	}

	public void testGet () {
		SymbolTable st = new SymbolTable();
		assertEquals(16, st.get("NEW"));
		assertEquals(17, st.get("TEST"));
		assertEquals(17, st.get("TEST"));
		assertEquals(18, st.get("another"));
		assertEquals(16, st.get("NEW"));
	}
}

