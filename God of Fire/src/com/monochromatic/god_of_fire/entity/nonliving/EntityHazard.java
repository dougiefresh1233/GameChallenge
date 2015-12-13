package com.monochromatic.god_of_fire.entity.nonliving;

import com.monochromatic.god_of_fire.entity.Entity;
import com.monochromatic.god_of_fire.entity.living.LivingEntity;
import com.monochromatic.god_of_fire.enums.DamageTarget;
import com.monochromatic.god_of_fire.enums.Direction;
import com.monochromatic.god_of_fire.state.GameState;

/**
 * Represents a static hazard entity (ie. spikes or lava).
 * 
 * @author calmattier
 */
public class EntityHazard extends NonlivingEntity{
	/** The damage value applied by this entity upon collision. */
	protected int attack;
	protected DamageTarget target;
	
	public EntityHazard(GameState g, int x, int y, Direction d, int a){
		this(g, x, y, d, a, DamageTarget.NEUTRAL);
	}
	
	public EntityHazard(GameState g, int x, int y, Direction d, int a, DamageTarget t){
		super(g, x, y, d, 0);
	}
	
	/**
	 * Get the damage applied by this entity upon collision.
	 */
	public int getAttack() {
		return attack;
	}

	/**
	 * Get the {@link DamageTarget target} for this source of damage.
	 */
	public DamageTarget getTarget() {
		return target;
	}

	@Override
	public void collide(Entity e) {
		if (target.value().isInstance(e))
			((LivingEntity) e).adjustHealth(attack);
	}
	
	public void render() {
		//TODO - Render Sprite
	}
	
}