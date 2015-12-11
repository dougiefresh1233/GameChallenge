package com.monochromatic.god_of_fire.entity.nonliving;

import com.monochromatic.god_of_fire.entity.Direction;

/**
 * Represents a projectile entity.
 * 
 * @author calmattier
 *
 */
public class EntityProjectile extends NonlivingEntity{
	protected int attack;
	
	public EntityProjectile(int x, int y, Direction d, int s, int a){
		super(x, y, d, s);
		attack = a;
	}

}
