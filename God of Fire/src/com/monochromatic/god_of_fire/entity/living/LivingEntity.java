package com.monochromatic.god_of_fire.entity.living;

import org.newdawn.slick.tiled.TiledMap;

import com.monochromatic.god_of_fire.entity.Entity;

public abstract class LivingEntity extends Entity {
	/** If entities alive or not */
	protected boolean alive;
	/** The entities current health */
	protected int currentHealth;
	/** The entities maximum health */
	protected int maximumHealth;
	/** Damage capable by player. Increase */
	protected int attack = 0;
	/** Defense modifier. Reduces damage taken */
	protected int defense = 0;
	/** Modifier for critical chance. */
	protected int critical = 0;

	public LivingEntity(TiledMap m, int x, int y, int h) {
		super(m, x, y);
		this.maximumHealth = h;
	}

	public LivingEntity(TiledMap m, int x, int y, int h, int a, int d, int c) {
		super(m, x, y);
		this.currentHealth = h;
		this.maximumHealth = h;
		this.attack = a;
		this.defense = d;
		this.critical = c;
	}

	/**
	 * Kills the target
	 */
	public void kill() {
		alive = false;
	}

	/**
	 * Returns if the entity is still alive.
	 */
	public boolean alive() {
		return alive;
	}

	
	// COMBAT METHODS //
	/**
	 * Method to calculate the attack value for this entity, including double
	 * damage attributed to a critical.
	 */
	public int calculateAttack() {
		int damage = attack;
		if (Math.random() <= critical)
			damage *= 2;
		return damage;
	}

	/**
	 * Method to update an entities health. Negative values represent entity
	 * healing.
	 * 
	 * @param d
	 *            - amount to damage
	 * @return boolean - killing blow
	 */
	public boolean adjustHealth(int d) {
		int damage = d > 0 ? Math.max(0, d - defense) : d;
		currentHealth = Math.min(maximumHealth, currentHealth - damage);
		return currentHealth <= 0 ? true : false;
	}

	/**
	 * Returns this entities current health.
	 */
	public int getHealth() {
		return currentHealth;
	}

	
	// ANIMATION METHODS //
	/**
	 * Plays the animation when this entity attacks.
	 */
	public abstract void attackAnim();

	/**
	 * Plays the animation when this entity is hurt. Sprite turns red
	 * momentarily.
	 */
	public abstract void hurtAnim();

	/**
	 * Plays the animation when this entity is healed. Sprite turns green
	 * momentarily.
	 */
	public abstract void healedAnim();

	/**
	 * Plays the animation when this entity dies. Puff of smoke.
	 */
	public abstract void deathAnim();

	
	// GETTERS/SETTERS //
	public int getMaximumHealth() {
		return maximumHealth;
	}

	public void setMaximumHealth(int maximumHealth) {
		this.maximumHealth = maximumHealth;
	}

	public int getAttack() {
		return attack;
	}

	public void setAttack(int attack) {
		this.attack = attack;
	}

	public int getDefense() {
		return defense;
	}

	public void setDefense(int defense) {
		this.defense = defense;
	}

	public int getCritical() {
		return critical;
	}

	public void setCritical(int critical) {
		this.critical = critical;
	}
}