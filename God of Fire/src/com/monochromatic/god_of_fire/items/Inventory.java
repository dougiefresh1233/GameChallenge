package com.monochromatic.god_of_fire.items;

import java.util.HashMap;

public class Inventory {
	protected HashMap<String, Item> inventory;
	
	public Inventory() {
		inventory = new HashMap<String, Item>();
	}
	
	/**
	 * Adjusts the inventory by the specified item. A negative
	 * quantity item will remove items from the inventory.
	 */
	public void adjust(Item i) {
		Item existing = inventory.get(i.getName());
		
		if (existing != null)
			existing.adjustQuantity(i.getQuantity());
		else if (i.getQuantity() >= 0)
			inventory.put(i.getName(), i);
	}
	
}