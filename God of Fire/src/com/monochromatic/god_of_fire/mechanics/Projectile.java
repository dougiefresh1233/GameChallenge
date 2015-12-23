package com.monochromatic.god_of_fire.mechanics;

import com.monochromatic.god_of_fire.enums.DamageType;
import com.monochromatic.god_of_fire.enums.ElementalType;
import com.monochromatic.god_of_fire.enums.RangeType;

public class Projectile extends Damage {
	private double distance;

	/**
	 * Create a Projectile Object containing all information necessary for any
	 * damage taking formula, including range
	 * 
	 * @param amount
	 *            The amount of damage taken
	 * @param dType
	 *            The type of damage taken
	 * @param range
	 *            The ranged type of the damage
	 * @param eType
	 *            The element of the damage
	 * @param projectileDistance
	 *            The range of the projectile
	 */
	public Projectile(int amount, double projectileDistance, DamageType dType, RangeType range, ElementalType eType) {
		super(amount, dType, range, eType);
		distance = projectileDistance;
	}
	/**
	 * Create a Projectile Object containing all information necessary for any
	 * damage taking formula, including range
	 * 
	 * @param amount
	 *            The amount of damage taken
	 * @param dType
	 *            The type of damage taken
	 * @param range
	 *            The ranged type of the damage
	 * @param projectileDistance
	 *            The range of the projectile
	 */
	public Projectile(int amount, double projectileDistance, DamageType dType, RangeType range) {
		super(amount, dType, range);
		distance = projectileDistance;
	}

	public double getProjectileDistance() {
		return distance;
	}

	public void setProjectileDistance(double distance) {
		this.distance = distance;
	}
}
