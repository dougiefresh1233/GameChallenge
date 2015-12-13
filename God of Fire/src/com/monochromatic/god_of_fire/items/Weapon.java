package com.monochromatic.god_of_fire.items;

public abstract class Weapon extends Item{
	
	/**
	 * Range of the weapon in px
	 */
	private int range;
	
	/**
	 * Base damage for the weapon
	 */
	private int damage;
	
	/**
	 * Speed of the weapon in milliseconds
	 */
	private double speed, startOfCooldown;
	
	/**
	 * Default constructor
	 */
	public Weapon(){}
	
	/**
	 * Constructor
	 * @param name
	 * @param description
	 * @param filePath
	 * @param value
	 * @param isEquippable
	 * @param isSellable
	 * @param range
	 * @param speed
	 * @param damage
	 */
	public Weapon(String name, String description, String filePath,
				int value, boolean isEquippable, boolean isSellable, int range,
				int speed, int damage){
		
	
		super(name, description, filePath, value, isEquippable, isSellable);
		this.range=range;
		this.speed=speed;
		this.damage=damage;
	}
	
	/**
	 * Getter for the range
	 * @return
	 */
	public int getRange(){
		return range;
	}
	
	/**
	 * Getter for the damage
	 * @return
	 */
	public int getDamage(){
		return damage;
	}
	
	/**
	 * Getter method for the speed of the weapon
	 * @return
	 */
	public double getSpeed(){
		return speed;
	}
	
	/**
	 * Starts the cooldown
	 */
	public void startCooldown(){
		startOfCooldown=System.currentTimeMillis();
	}
	
	/**
	 * Tests if the attack is off cooldown
	 * @return
	 */
	public boolean isOffCooldown(){
		if((System.currentTimeMillis()-startOfCooldown)<speed)
			return false;
		else{
			return true;
		}	
	}


}
