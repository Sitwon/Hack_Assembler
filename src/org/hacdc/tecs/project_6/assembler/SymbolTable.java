/**
 * Provides a look-up table of symbols to addresses.
 *
 * @author Ben "the Pyrate" Mendis
 */

package org.hacdc.tecs.project_6.assembler;

import java.util.*;

public class SymbolTable extends HashMap<String, Integer> {
	protected int nextAddress = 16;

	/**
	 * Constructor for SymbolTable.
	 *
	 * Initializes the SymbolTable and sets up the predefined symbols.
	 */
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

	/**
	 * Register a new variable in the table.
	 *
	 * Register a new variable in the table. If the variable is already registered,
	 * return the existing address.
	 *
	 * @param symbol The new variable to be registered.
	 * @return The address of the registered variable.
	 */
	public int registerVariable (String symbol) {
		if (this.contains(symbol)) {
			return this.getAddress(symbol);
		}
		this.addEntry(symbol, this.nextAddress);
		return this.nextAddress++;
	}

	/**
	 * Add and entry into the table.
	 *
	 * @param symbol The new symbol to be added.
	 * @param address The corresponding address for the new symbol.
	 */
	public void addEntry (String symbol, Integer address) {
		this.put(symbol, address);
	}

	/**
	 * Check if a symbol exists in the table.
	 *
	 * @return True if the symbol exists in the table, otherwise False.
	 */
	public boolean contains (String symbol) {
		return this.containsKey(symbol);
	}

	/**
	 * Look up a symbol's address.
	 *
	 * @param symbol The symbol to look up.
	 * @return The corresponding address.
	 */
	public Integer getAddress (String symbol) {
		return this.get(symbol);
	}
}

