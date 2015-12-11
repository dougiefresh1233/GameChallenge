import java.awt.*;
import java.awt.image.BufferedImage;

import org.newdawn.slick.tests.xml.Inventory;

public abstract class Entity {
	
	/**
	 * Location of the player
	 */
	private Point playerLocation;
	
	/**
	 * Players inventory
	 */
	private Inventory inventory;
	
	/**
	 * Array of images for multidirectional movement
	 */
	private BufferedImage[] movementImages;
	
	/**
	 * Array of images for when entities not moving
	 */
	private BufferedImage[] stationaryImages;
	
	/**
	 * Array of images for entities physical attacks
	 */
	private BufferedImage[] attackingImages;
	
	/**
	 * Array of images for entities casting
	 */
	private BufferedImage[] castingImages;
	
	/**
	 * If entities alive or not
	 */
	private boolean isDead;
	
	/**
	 * The entities current health
	 */
	private int health;
	
	/**
	 * The entities maximum health
	 */
	private int maximumHealth;
	
	/**
	 * Damage capable by player. Increase
	 */
	private int attack;
	
	/**
	 * Defense modifier. Reduces damage taken
	 */
	private int defense;
	
	/**
	 * Modifier for critical chance.
	 */
	private int critChance;
	
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
	
	public boolean isColliding(Entity e){
		return isDead;
		
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
