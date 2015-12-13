package com.monochromatic.god_of_fire.entity;
import java.awt.*;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Animation;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SpriteSheet;
import com.monochromatic.god_of_fire.enums.Direction;
import com.monochromatic.god_of_fire.state.GameState;

/**
 * Base entity class. All entities need to be registered with the
 * {@link EntityController} if they are to be interactive with the rest of the
 * game world.
 * 
 * @author calmattier
 */
public abstract class Entity {
	protected GameState gameState; /**Game State */
	
	private Point location; /** Current location of the entity */
	private Point previous; /** Previous location of the entity */
	protected int level = 1; /**Current floor level. */
	protected Direction orientation; /** Orientation of the entity. */
	protected int movementSpeed;
	
	protected boolean hardCollision = false;
	protected boolean setForRemoval = false;
	protected boolean initComplete=false;
	
	/** Spritesheet for all images **/
	protected Image spriteSheet;
	/** Array of images for multidirectional movement **/
	protected SpriteSheet 	upwardsMovementImages, 
							leftMovementImages, 
							downwardMovementImages, 
							rightMovementImages;
	/** What animation is currently being used **/
	protected Animation currentAnimation;
	/** Animations for the entity **/
	protected Animation 	upwardsMovementAnimation, 
							downwardMovementAnimation, 
							leftMovementAnimation,
							rightMovementAnimation;
	
	/** Array of images and animation for when the entity is not moving */
	protected Image[] stationaryImages;
	protected Animation stationaryAnimation;
	
	/** Array of images and animation for entities physical attacks */
	protected Image[] attackingImages, castingImages;
	protected Animation attackingAnimation, castingAnimation;
		
	
	public Entity(GameState g, int x, int y){
		this(g, x, y, Direction.DOWN);
	}
	
	public Entity(GameState g, int x, int y, Direction d){
		this(g, x, y, d, 0);
	}
	
	public Entity(GameState g, int x, int y, Direction d, int s){
		gameState = g;
		this.location = new Point(x, y);
		this.orientation = d;
		this.movementSpeed = s;
	}
	
	/**
	 * Updates this entity. Movement and AI happen at this step.
	 */
	public abstract void update(GameContainer g);
	
	/**
	 * Renders this entity.
	 */
	public abstract void render();
	
	/**
	 * Applies the effects on the given entity, if it were to collide with
	 * this entity.
	 */
	public abstract void collide(Entity e);
	
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
	
	public void setImage(String filePath){
		try {
			spriteSheet=new SpriteSheet(filePath, 32, 64);
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Moves the entity in the given direction and changes to the corresponding
	 * animation.
	 */
	public void move(Direction d) {
		previous = location;
		if (d == Direction.UP) moveUp();
		else if (!upwardsMovementAnimation.isStopped())
			upwardsMovementAnimation.stop();

		if (d == Direction.LEFT) moveLeft();
		else if (!leftMovementAnimation.isStopped())
			leftMovementAnimation.stop();

		if (d == Direction.DOWN) moveDown();
		else if (!downwardMovementAnimation.isStopped())
			downwardMovementAnimation.stop();

		if (d == Direction.RIGHT) moveRight();
		else if (!rightMovementAnimation.isStopped())
			rightMovementAnimation.stop();
	}
	
	/**
	 * Moves the entity up and changes corresponding animations.
	 */
	private void moveUp() {
		orientation(Direction.UP);
		upwardsMovementAnimation.start();
		currentAnimation = upwardsMovementAnimation;
		location.translate(0, -movementSpeed);
	}
	
	/**
	 * Moves the entity down and changes corresponding animations.
	 */
	private void moveDown() {
		orientation(Direction.DOWN);
		downwardMovementAnimation.start();
		currentAnimation = downwardMovementAnimation;
		location.translate(0, movementSpeed);
	}
	
	/**
	 * Moves the entity to the left and changes corresponding animations.
	 */
	private void moveLeft() {
		orientation(Direction.LEFT);
		leftMovementAnimation.start();
		currentAnimation = leftMovementAnimation;
		location.translate(-movementSpeed, 0);
	}
	
	/**
	 * Moves the entity to the right and changes corresponding animations.
	 */
	private void moveRight() {
		orientation(Direction.RIGHT);
		rightMovementAnimation.start();
		currentAnimation = rightMovementAnimation;
		location.translate(movementSpeed, 0);
	}
	
	/**
	 * Sets this entities location.
	 */
	public void location(Point p) {
		previous = location;
		location = p;
	}
	
	/**
	 * Returns a copy of this entities location.
	 */
	public Point location() {
		return new Point((int) location.getX(), (int) location.getY());
	}
	
	/**
	 * Returns a copy of this entities previous location.
	 */
	public Point previous() {
		return new Point((int) previous.getX(), (int) previous.getY());
	}
	
	/**
	 * Gets orientation of the entity
	 */
	public Direction orientation(){
		return orientation;
	}
	
	/**
	 * Sets orientation of the entity
	 * @param d
	 */
	public void orientation(Direction d){
		orientation = d;
	}
	
	/**
	 * Retrieves the current room level for this entity.
	 */
	public int getLevel() {
		return level;
	}

	/**
	 * Sets the current room level for this entity.
	 */
	public void setLevel(int level) {
		this.level = level;
	}
	
	/**
	 * Checks the hard collision value for this entity. If set to true, this
	 * entity cannot occupy the same tile as another entity and will act
	 * like a wall.
	 */
	public boolean isHardCollision() {
		return hardCollision;
	}

	/**
	 * Sets the hard collision value for this entity. If set to true, this
	 * entity cannot occupy the same tile as another entity and will act
	 * like a wall.
	 */
	public void setHardCollision(boolean hardCollision) {
		this.hardCollision = hardCollision;
	}
	
	/**
	 * Checks to see if this entity has been flagged for removal.
	 */
	public boolean isSetForRemoval() {
		return setForRemoval;
	}
	
	/**
	 * Sets this entities removal flag.
	 */
	public void setForRemoval(boolean b) {
		setForRemoval = b;
	}
	
}