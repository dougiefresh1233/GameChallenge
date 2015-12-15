package com.monochromatic.god_of_fire.entity.ai;

import javax.vecmath.Vector2d;

/**
 * This interface denotes that the implementing entity contains a method
 * to 'shoot' a projectile at a specified point.
 * 
 * @author calmattier
 */
public interface Sniper {

	public void shoot(Vector2d direction);
	
}
