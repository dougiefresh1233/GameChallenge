package com.monochromatic.god_of_fire.items;

import java.awt.Point;
import java.io.File;
import java.io.IOException;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.particles.ConfigurableEmitter;
import org.newdawn.slick.particles.ParticleIO;
import org.newdawn.slick.particles.ParticleSystem;



public class MeleeWeapon extends Weapon{

	/**
	 * Where the player is located so the weapon can be located relative 
	 * to the player
	 */
	Point playersLocation;

	/**
	 * The angle to start the animation
	 */
	private float startingAngle;


	/**
	 * If the player is currently attacking
	 * Rotates and renders only when true
	 */
	private boolean attacking;
	
	/**
	 * How many times the weapon draws
	 */
	private int framesTillCompletion;

	private int direction;




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
	public MeleeWeapon(String name, String description, String filePath,
			int value, boolean isEquippable, boolean isSellable, int range,
			int speed, int damage){
		super(name, description, filePath, value, isEquippable, isSellable, range,
				speed, damage);
		itemImage.setCenterOfRotation(-10, 4*itemImage.getHeight()/10);
		

	}

	/**
	 * Put in on the player
	 * @param playersLocation
	 */
	public void equip(Point playersLocation){
		this.playersLocation=playersLocation;
	}
	

	
	/**
	 * Start the attack animation
	 * @param startingAngle
	 * @param endingAngle
	 */
	public void attack(float startingAngle, int direction){
		this.startingAngle=startingAngle;
		this.direction=direction;

		attacking=true;
		itemImage.setRotation(startingAngle);
		framesTillCompletion=0;
	}

	/**
	 * Update method which updates the weapons position
	 */
	public void update(){

		if(attacking){
			framesTillCompletion++;
			itemImage.rotate(15*direction);
			if(framesTillCompletion>11){
				attacking=false;
			}
		}
			
	}



	@Override
	public void render() {
		
		if(attacking){
			
		itemImage.draw((float)(playersLocation.getX()+25), 
				(float)playersLocation.getY());
	}


	}
}
