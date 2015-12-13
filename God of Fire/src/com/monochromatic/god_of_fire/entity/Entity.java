package com.monochromatic.god_of_fire.entity;
import java.awt.*;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Animation;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SpriteSheet;

import com.monochromatic.god_of_fire.enums.Direction;

public abstract class Entity {
	/** Location of the entity */
	protected Point location;
	/** Orientation of the entity */
	protected Direction orientation;
	/** How fast the entity moves */
	protected int movementSpeed;
	
	protected boolean initComplete=false;
	/** Spritesheet for all images **/
	protected Image spriteSheet;
	/** Array of images for multidirectional movement **/
	protected SpriteSheet upwardsMovementImages, leftMovementImages, downwardMovementImages, rightMovementImages;
	
	/** What animation is currently being used **/
	protected Animation currentAnimation;
	
	/** Animations for the entity **/
	protected Animation upwardsMovementAnimation, downwardMovementAnimation, leftMovementAnimation, rightMovementAnimation  ;
	
	
	/**
	 * Array of images and animation for when the entity is not moving
	 */
	protected Image[] stationaryImages;
	protected Animation stationaryAnimation;
	
	/**
	 * Array of images and animation for entities physical attacks
	 */
	protected Image[] attackingImages, castingImages;
	protected Animation attackingAnimation, castingAnimation;
		
	public Entity(int x, int y){
		this(x, y, Direction.DOWN);
	}
	
	public Entity(int x, int y, Direction d){
		this(x, y, d, 0);
	}
	
	public Entity(int x, int y, Direction d, int s){
		this.location = new Point(x, y);
		this.orientation = d;
		this.movementSpeed = s;
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
		downwardMovementImages=new SpriteSheet(spriteSheet.getSubImage(0, 0, 192, 62), 32, 62);
		leftMovementImages=new SpriteSheet(spriteSheet.getSubImage(0, 64, 192, 64), 32, 64);
		upwardsMovementImages=new SpriteSheet(spriteSheet.getSubImage(0, 128, 192, 64), 32, 64);
		rightMovementImages=new SpriteSheet(spriteSheet.getSubImage(0, 192, 192, 64),32, 64);
		
		/**
		stationaryImages = new Image[] { 
				spriteSheet.getSubImage(x, y),
				spriteSheet.getSubImage(x, y)};
		attackingImages = new Image[] { 
				spriteSheet.getSubImage(x, y),
				spriteSheet.getSubImage(x, y)};
		castingImages = new Image[] { 
				spriteSheet.getSubImage(x, y),
				spriteSheet.getSubImage(x, y)};
		*/

		upwardsMovementAnimation=new Animation(upwardsMovementImages, 100);
		downwardMovementAnimation=new Animation(downwardMovementImages, 100);
		rightMovementAnimation=new Animation(rightMovementImages, 100);
		leftMovementAnimation=new Animation(leftMovementImages, 100);
		currentAnimation=upwardsMovementAnimation;
	
		/**
		stationaryAnimation=new Animation(stationaryImages, 1, false);
		attackingAnimation=new Animation(attackingImages, 1, false);
		castingAnimation=new Animation(castingImages, 1, false);
		*/
		initComplete=true;
	}
	
	/**
	 * Determines if the given entity has collided with this one.
	 * 
	 * @param entity
	 */
	public boolean isColliding(Entity entity){
		//TODO - Advanced collision logic
		Point them = entity.location();
		boolean collided = ((int) them.getX() == (int) location.getX() &&
							(int) them.getY() == (int) location.getY()) 
							? true : false;
		return collided;
	}
	
	/**
	 * Returns a copy of this entities location.
	 */
	public Point location() {
		return new Point((int) location.getX(), (int) location.getY());
	}
	
	/**
	 * Sets orientation of the entity
	 * @param d
	 */
	protected void setOrientation(Direction d){
		orientation = d;
	}
	
	protected void setImage(String filePath){
		try {
			spriteSheet=new SpriteSheet(filePath, 32, 64);
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void move() {
		//TODO
	}
	
	public abstract void render();
	
	public abstract void update(GameContainer gameScreen);
	
}