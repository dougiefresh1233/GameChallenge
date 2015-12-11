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
	private Image itemImage;
	
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
	 * Getter for the value of the item
	 * @return
	 */
	public int getValue(){
		return value;
	}
	
	/**
	 * Getter for the description
	 * @return
	 */
	public String getDesciption(){
		return description;
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

}
