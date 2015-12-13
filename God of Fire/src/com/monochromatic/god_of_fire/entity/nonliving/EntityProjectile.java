package com.monochromatic.god_of_fire.entity.nonliving;

import org.newdawn.slick.GameContainer;

import com.monochromatic.god_of_fire.enums.Direction;

/**
 * Represents a projectile entity.
 * 
 * @author calmattier
 */
public class EntityProjectile extends NonlivingEntity {
	protected int attack;

	public EntityProjectile(int x, int y, Direction d, int s, int a) {
		super(x, y, d, s);
		attack = a;
	}

	public int getAttack() {
		return attack;
	}

	public void setAttack(int attack) {
		this.attack = attack;
	}

	@Override
	public void update(GameContainer gameScreen) {
		switch(this.orientation) {
			case UP:
				location.translate(0, -movementSpeed);
			case DOWN:
				location.translate(0, movementSpeed);
			case LEFT:
				location.translate(-movementSpeed, 0);
			case RIGHT:
				location.translate(movementSpeed, 0);
		}
	}

}