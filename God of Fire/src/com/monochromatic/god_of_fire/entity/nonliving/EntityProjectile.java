package com.monochromatic.god_of_fire.entity.nonliving;

import org.newdawn.slick.GameContainer;

import com.monochromatic.god_of_fire.entity.Entity;
import com.monochromatic.god_of_fire.entity.living.LivingEntity;
import com.monochromatic.god_of_fire.enums.DamageTarget;
import com.monochromatic.god_of_fire.enums.Direction;
import com.monochromatic.god_of_fire.state.GameState;

/**
 * Represents a projectile entity.
 * 
 * @author calmattier
 */
public class EntityProjectile extends NonlivingEntity {
	/** The damage value applied by this entity upon collision. */
	protected int attack;
	protected DamageTarget target;

	public EntityProjectile(GameState g, int x, int y, Direction d, int s, int a) {
		this(g, x, y, d, s, a, DamageTarget.NEUTRAL);
	}
	
	public EntityProjectile(GameState g, int x, int y, Direction d, int s, int a, DamageTarget t) {
		super(g, x, y, d, s);
		attack = a;
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
	public void update(GameContainer g) {
		move(this.orientation());
	}

	@Override
	public void collide(Entity e) {
		if (target.value().isInstance(e))
			((LivingEntity) e).adjustHealth(attack);
		setForRemoval(true);
	}
	
	@Override
	public void render() {
		// TODO - render sprite
	}

}