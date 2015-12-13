package com.monochromatic.god_of_fire.entity;
import java.awt.*;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Animation;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.tiled.TiledMap;

import com.monochromatic.god_of_fire.enums.Direction;

public abstract class Entity {
	/**Size of Map tiles*/
	int TILE_SIZE=32;
	/**Map data */
	TiledMap map;
	int floor1, stairs, floor2, walls;
	/**Floor that player is on*/
	int level=1;
	/** Location of the entity */
	protected Point location;
	/** Orientation of the entity */
	protected Direction orientation;
	/** How fast the entity moves */
	protected int movementSpeed;
	
	protected boolean setForRemoval;
	
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
		
	public Entity(TiledMap m, int x, int y){
		this(m, x, y, Direction.DOWN);
	}
	
	public Entity(TiledMap m, int x, int y, Direction d){
		this(m, x, y, d, 0);
	}
	
	public Entity(TiledMap m, int x, int y, Direction d, int s){
		this.location = new Point(x, y);
		this.orientation = d;
		this.movementSpeed = s;
		map=m;
		floor1=map.getLayerIndex("Floor1");
		stairs=map.getLayerIndex("Stairs");
		floor2=map.getLayerIndex("Floor2");
		walls=map.getLayerIndex("Walls");
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
	
	public boolean isSetForRemoval() {
		return setForRemoval;
	}
	
	public void setForRemoval(boolean b) {
		setForRemoval = b;
	}
	
	protected void setImage(String filePath){
		try {
			spriteSheet=new SpriteSheet(filePath, 32, 64);
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Returns a copy of this entities location.
	 */
	public Point location() {
		return new Point((int) location.getX(), (int) location.getY());
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
	
	public void move(Direction d) {
		if (d == Direction.UP) {
			orientation(Direction.UP);
			upwardsMovementAnimation.start();
			currentAnimation = upwardsMovementAnimation;
			if (!collides(Direction.UP))
				location.translate(0, -movementSpeed);
		} else if (!upwardsMovementAnimation.isStopped()) {
			upwardsMovementAnimation.stop();
		}

		if (d == Direction.LEFT) {
			orientation(Direction.LEFT);
			leftMovementAnimation.start();
			currentAnimation = leftMovementAnimation;
			if (!collides(Direction.LEFT))
				location.translate(-movementSpeed, 0);
		} else if (!leftMovementAnimation.isStopped()) {
			leftMovementAnimation.stop();
		}

		if (d == Direction.DOWN) {
			orientation(Direction.DOWN);
			downwardMovementAnimation.start();
			currentAnimation = downwardMovementAnimation;
			if (!collides(Direction.DOWN))
				location.translate(0, movementSpeed);
		} else if (!downwardMovementAnimation.isStopped()) {
			downwardMovementAnimation.stop();
		}

		if (d == Direction.RIGHT) {
			orientation(Direction.RIGHT);
			rightMovementAnimation.start();
			currentAnimation = rightMovementAnimation;
			if (!collides(Direction.RIGHT))
				location.translate(movementSpeed, 0);
		} else if (!rightMovementAnimation.isStopped()) {
			rightMovementAnimation.stop();
		}
	}
	

	public void move() {
		//TODO
	}
	public boolean collides(Direction d){	//layer based tile collision
		int x,y;
		switch(d){
		case UP:
			x= (int)Math.round(location.getX()/TILE_SIZE);
			y= (int)Math.ceil(location.getY()/TILE_SIZE)+1;
			if(map.getTileId(x, y-1,walls)!=0){
				return true;
			}else if(map.getTileId(x, y-1,floor2)!=0){
				if(level==2)level=3;
				return (level==1)?true:false;
			}else if (map.getTileId(x, y-1,stairs)!=0){
				level=2;
				return false;
			}else if(map.getTileId(x, y-1,floor1)!=0){
				if(level==2)level=1;
				return (level==1 || level==2)? false:true;
			}
		case DOWN:
			x= (int)Math.round(location.getX()/TILE_SIZE);
			y= (int)Math.floor(location.getY()/TILE_SIZE)+1;
			if(map.getTileId(x, y+1,walls)!=0){
				return true;
			}else if(map.getTileId(x, y+1,floor2)!=0){
				if(level==2)level=3;
				return (level==1)?true:false;
			}else if (map.getTileId(x, y+1,stairs)!=0){
				level=2;
				return false;
			}else if(map.getTileId(x, y+1,floor1)!=0){
				if(level==2)level=1;
				return (level==1 || level==2)? false:true;
			}
		case RIGHT:
			x= (int)Math.floor(location.getX()/TILE_SIZE);
			y= (int)Math.round(location.getY()/TILE_SIZE)+1;
			if(map.getTileId(x+1, y,walls)!=0){
				return true;
			}else if(map.getTileId(x+1, y,floor2)!=0){
				if(level==2)level=3;
				return (level==1)?true:false;
			}else if (map.getTileId(x+1, y,stairs)!=0){
				level=2;
				return false;
			}else if(map.getTileId(x+1, y,floor1)!=0){
				if(level==2)level=1;
				return (level==1 || level==2)? false:true;
			}
		case LEFT:
			x= (int)Math.ceil(location.getX()/TILE_SIZE);
			y= (int)Math.round(location.getY()/TILE_SIZE)+1;
			if(map.getTileId(x-1, y,walls)!=0){
				return true;
			}else if(map.getTileId(x-1, y,floor2)!=0){
				if(level==2)level=3;
				return (level==1)?true:false;
			}else if (map.getTileId(x-1, y,stairs)!=0){
				level=2;
				return false;
			}else if(map.getTileId(x-1, y,floor1)!=0){
				if(level==2)level=1;
				return (level==1 || level==2)? false:true;
			}
		}
		return true;
	}
	
	/**
	 * Determines if the given entity has collided with this one.
	 * 
	 * @param entity
	 */
	public boolean collides(Entity e){
		//TODO - Advanced collision logic
		Point them = e.location();
		boolean collided = ((int) them.getX() == (int) location.getX() &&
							(int) them.getY() == (int) location.getY()) 
							? true : false;
		return collided;
	}
	
	public abstract void render();
	
	public abstract void update(GameContainer gameScreen);
	
}