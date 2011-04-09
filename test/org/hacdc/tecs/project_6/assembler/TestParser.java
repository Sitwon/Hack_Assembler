package org.hacdc.tecs.project_6.assembler;

import junit.framework.*;
import java.io.*;

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

	public void testEmptyLine () {
		String s = "\n"
			+ " \n"
			+ "    \n"
			+ "	\n"
			+ " 	\n"
			+ "	 ";
		Parser p = new Parser(new ByteArrayInputStream(s.getBytes()));
		assertEquals("commandList should be empty.", 0, p.commandList.size());
	}

	public void testOnlyComments () {
		String s = "// this is a comment\n"
			+ " // comment\n"
			+ "  //comment\n"
			+ "///comment\n"
			+ "	// comment\n"
			+ "//";
		Parser p = new Parser(new ByteArrayInputStream(s.getBytes()));
		assertEquals("commandList should be empty.", 0, p.commandList.size());
	}

	public void testSimpleACommand () {
		String s = "@0\n"
			+ " @0\n"
			+ "@0 \n"
			+ " @0 \n"
			+ "@0 // comment\n"
			+ " @0 //comment\n"
			+ " @0//comment\n"
			+ "@0	//comment";
		Parser p = new Parser(new ByteArrayInputStream(s.getBytes()));
		assertEquals("commandList should have 8 entries.", 8, p.commandList.size());
		for (Command c: p.commandList) {
			assertEquals("All command should be equal to '@0'.", "@0", c.getCommand());
		}
	}

	public void testSimpleCCommand () {
		String s = "0\n"
			+ "  0\n"
			+ "0  \n"
			+ " 0 \n"
			+ " 0 //comment \n"
			+ "0//comment";
		Parser p = new Parser(new ByteArrayInputStream(s.getBytes()));
		assertEquals("commandList should have 6 entries.", 6, p.commandList.size());
		for (Command c: p.commandList) {
			assertEquals("All command should be equal to '0'.", "0", c.getCommand());
		}
	}
}

