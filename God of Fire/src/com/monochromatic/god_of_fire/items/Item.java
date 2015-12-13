package com.monochromatic.god_of_fire.items;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public abstract class Item {
	
	/**
	 * Name of the item
	 */
	private String name;
	
	/**
	 * Brief description of the item
	 */
	private String description;
	
	/**
	 * Number of items in the stack. Defaults to 1.
	 */
	private int quantity = 1;
	
	/**
	 * Value in gold of the item
	 */
	private int value;
	
	/**
	 * Can it be equipped
	 */
	private boolean isEquippable;
	
	/**
	 * Can you sell it
	 */
	private boolean isSellable;
	
	/**
	 * Image for the item
	 */
	protected Image itemImage;
	
	public Item(){
		
	}
	
	/**
	 * Constructor
	 * @param name
	 * @param description
	 * @param value
	 * @param isEquippable
	 * @param isSellable
	 */
	public Item(String name, String description, String filePath,
						int value, boolean isEquippable, boolean isSellable){
		this.name=name;
		this.description=description;
		this.setImage(filePath);
		this.value=value;
		this.isEquippable=isEquippable;
		this.isSellable=isSellable;
	}
	
	/**
	 * Gets the unique name of this item.
	 */
	public String getName(){
		return name;
	}
	
	/**
	 * Getter for the description
	 * @return
	 */
	public String getDesciption(){
		return description;
	}
	
	/**
	 * Gets the quantity of this item.
	 */
	public int getQuantity() {
		return quantity;
	}

	/**
	 * Adjusts the current quantity of this item.
	 */
	public void adjustQuantity(int quantity) {
		this.quantity += quantity;
		if (quantity < 0)
			quantity = 0;
	}
	
	/**
	 * Sets the quantity of this item.
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	/**
	 * Getter for the value of the item
	 * @return
	 */
	public int getValue(){
		return value;
	}
	
	/**
	 * Getter for isEquippable
	 * @return
	 */
	public boolean getIsEquippable(){
		return isEquippable;
	}
	
	/**
	 * Getter for isSellable
	 * @return
	 */
	public boolean getIsSellable(){
		return isSellable;
	}
	
	/**
	 * Sets the image for the item
	 * @param filePath
	 */
	protected void setImage(String filePath){
		try {
			itemImage=new Image(filePath);
		} catch (SlickException e) {
			System.exit(1);
			e.printStackTrace();
		}
	}
	
	abstract protected void render();

}
