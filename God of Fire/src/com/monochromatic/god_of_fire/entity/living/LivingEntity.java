package com.monochromatic.god_of_fire.entity.living;

import com.monochromatic.god_of_fire.entity.Entity;

public abstract class LivingEntity extends Entity {
	/** If entities alive or not */
	protected boolean alive;
	
	/** The entities current health */
	protected int currentHealth;
	/** The entities maximum health */
	protected int maximumHealth;
	
	/** Damage capable by player. Increase */
	protected int attack;
	/** Defense modifier. Reduces damage taken */
	protected int defense;
	/** Modifier for critical chance. */
	protected int critChance;
	
	public LivingEntity(int x, int y, int h, int a, int d){
		super(x, y);
		this.attack = a;
		this.maximumHealth = h;
		this.defense = d;
	}
	
	/**
	 * Kills the target
	 */
	public void kill(){
		alive = false;
	}
	 
	/**
	 * Returns if the entity is still alive
	 * @return
	 */
	public boolean alive(){
		return alive;
	}
	
	/**
	 * For healing and taking damage. Negative values represent
	 * entity healing.
	 * 
	 * @param d - amount to damage
	 * @return boolean - killing blow
	 */
	public boolean takeDamage(int d){
		//TODO use the Damage class to incorporate advanced damaging mechanics.
		//TODO - advanced defense algorithm
		int damage;
		if(d > 0) {
			damage = Math.max(0, d - defense);
			//TODO - play damaged animation
		} else {
			damage = d;
			//TODO - play healed animation
		}
		
		currentHealth = Math.min(maximumHealth, currentHealth - damage);
		return currentHealth <= 0 ? true : false;
	}
	
	// Primarily plays animation
	public abstract void attack();

	@Override
	public void render() {
		if(initComplete)
		currentAnimation.draw((int)location.getX(), (int)location.getY());
	}
	
}