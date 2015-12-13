package com.monochromatic.god_of_fire.enums;

import com.monochromatic.god_of_fire.entity.living.LivingEntity;
import com.monochromatic.god_of_fire.entity.living.Player;
import com.monochromatic.god_of_fire.entity.living.monster.Monster;

/**
 * Determines the target of this damage for immunity purposes.
 * 
 * @author calmattier
 */
public enum DamageTarget {
	PLAYER (Player.class),/** Damages the player. */
	ENEMY (Monster.class), /** Damages monsters. */
	NEUTRAL (LivingEntity.class); /** Damages all living entities. */
	
	private Class<? extends LivingEntity> clazz;
	private DamageTarget(Class<? extends LivingEntity> clazz) {
		this.clazz = clazz;
	}
	
	public Class<? extends LivingEntity> value() {
		return clazz;
	}

}