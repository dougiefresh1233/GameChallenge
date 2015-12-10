package com.monochromatic.god_of_fire.entity;
import java.awt.*;

import java.awt.image.BufferedImage;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Animation;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.tests.xml.Inventory;

public abstract class Entity {
	
	/**
	 * Location of the player
	 */
	protected Point playerLocation;
	
	/**
	 * Players inventory
	 */
	protected Inventory inventory;
	
	/**
	 * Spritesheet for all images
	 */
	protected SpriteSheet spriteSheet;
	
	/**
	 * Orientation of the character
	 * @author kaolinhart
	 *
	 */
	protected enum direction {up, down, left, right};
	
	protected direction orientation;
	
	/**
	 * Array of images for multidirectional movement
	 */
	protected Image[] upwardsMovementImages, downwardMovementImages, rightMovementImages, leftMovementImages;

	/**
	 * What animation is currently being used
	 */
	protected Animation currentAnimation;
	
	/**
	 * Animations for the entity
	 */
	protected Animation upwardsMovementAnimation, downwardMovementAnimation, leftMovementAnimation, rightMovementAnimation  ;
	
	
	/**
	 * Array of images and animation for when entities not moving
	 */
	protected Image[] stationaryImages;
	
	protected Animation stationaryAnimation;
	
	/**
	 * Array of images and animation for entities physical attacks
	 */
	protected Image[] attackingImages, castingImages;
	
	protected Animation attackingAnimation, castingAnimation;
	

	/**
	 * If entities alive or not
	 */
	protected boolean isDead;
	
	/**
	 * The entities current health
	 */
	protected int health;
	
	/**
	 * How fast the entity moves
	 */
	protected int movementSpeed;
	
	/**
	 * The entities maximum health
	 */
	protected int maximumHealth;
	
	/**
	 * Damage capable by player. Increase
	 */
	protected int attack;
	
	/**
	 * Defense modifier. Reduces damage taken
	 */
	protected int defense;
	
	/**
	 * Modifier for critical chance.
	 */
	protected int critChance;
	
	/**
	 * Default constructor
	 */
	public Entity(){
		this(0, 0, 0, 0, 0);
	}
	
	public Entity(int xPosition, int yPosition, int attack, int maxHealth, int defense){
		this.playerLocation=new Point(xPosition, yPosition);
		this.attack=attack;
		this.maximumHealth=maxHealth;
		this.defense=defense;
	}
	
	
	/**
	 * Looks like a clusterfuck now, but it will improve!
	 * Basically, if we can have the same format on all the sprite sheets, this one
	 * block of code will take care of it for every single entity.
	 * I just left it all as is for now as a place holder and so everyone can see whats to come
	 * @throws SlickException
	 */
	public void init() throws SlickException{
		// TODO
		int x=0, y=0, width=0, height=0;
		upwardsMovementImages = new Image[] { 
				spriteSheet.getSubImage(x, y, width, height),
				spriteSheet.getSubImage(x, y, width, height) };
		downwardMovementImages = new Image[] { 
				spriteSheet.getSubImage(x, y, width, height),
				spriteSheet.getSubImage(x, y, width, height) };
		rightMovementImages = new Image[] { 
				spriteSheet.getSubImage(x, y, width, height),
				spriteSheet.getSubImage(x, y, width, height) };
		leftMovementImages = new Image[] { 
				spriteSheet.getSubImage(x, y, width, height),
				spriteSheet.getSubImage(x, y, width, height) };
		stationaryImages = new Image[] { 
				spriteSheet.getSubImage(x, y, width, height),
				spriteSheet.getSubImage(x, y, width, height) };
		attackingImages = new Image[] { 
				spriteSheet.getSubImage(x, y, width, height),
				spriteSheet.getSubImage(x, y, width, height) };
		castingImages = new Image[] { 
				spriteSheet.getSubImage(x, y, width, height),
				spriteSheet.getSubImage(x, y, width, height) };

		upwardsMovementAnimation=new Animation(upwardsMovementImages, 1, false);
		downwardMovementAnimation=new Animation(downwardMovementImages, 1, false);
		rightMovementAnimation=new Animation(rightMovementImages, 1, false);
		leftMovementAnimation=new Animation(leftMovementImages, 1, false);
		stationaryAnimation=new Animation(stationaryImages, 1, false);
		attackingAnimation=new Animation(attackingImages, 1, false);
		castingAnimation=new Animation(castingImages, 1, false);
		
	}
	
	public boolean isColliding(Entity e){
		return isDead;
	}
	
	/**
	 * Sets orientation of the entity
	 * @param d
	 */
	protected void setOrientation(direction d){
		orientation=d;
	}
	
	/**
	 * Kills the target
	 */
	public void kill(){
		health=0;
		isDead=true;
	}
	 
	/**
	 * Returns if the entity is still alive
	 * @return
	 */
	public boolean isAlive(){
		if(!isDead){
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * For healing and taking damage
	 * @param value- amount to increase or decrease health by
	 */
	public void alterHealth(int value){
		health+=value;
	}
	
	public abstract void attack();
	
	public abstract void move();
	
	public abstract void render();
	
	
}