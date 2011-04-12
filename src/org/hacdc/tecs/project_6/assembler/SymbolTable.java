/**
 * Provides a look-up table of symbols to addresses.
 *
 * @author Ben "the Pyrate" Mendis
 */

package org.hacdc.tecs.project_6.assembler;

import java.util.*;

public class SymbolTable extends HashMap<String, Integer> {
	protected int nextAddress = 16;

	public SymbolTable () {
		super();
		this.put("SP", 0);
		this.put("LCL", 1);
		this.put("ARG", 2);
		this.put("THIS", 3);
		this.put("THAT", 4);
		for (int i = 0; i <= 15; i++) {  // Set R0 through R15
			this.put("R" + String.valueOf(i), i);
		}
		this.put("SCREEN", 16384);
		this.put("KBD", 24576);
	}

	public int registerVariable (String symbol) {
		if (this.contains(symbol)) {
			return this.getAddress(symbol);
		}
		this.addEntry(symbol, this.nextAddress);
		return this.nextAddress++;
	}

	public void addEntry (String symbol, Integer address) {
		this.put(symbol, address);
	}

	public boolean contains (String symbol) {
		return this.containsKey(symbol);
	}

	public Integer getAddress (String symbol) {
		return this.get(symbol);
	}
}

