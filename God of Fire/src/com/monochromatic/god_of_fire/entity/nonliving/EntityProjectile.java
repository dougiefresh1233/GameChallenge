package com.monochromatic.god_of_fire.entity.nonliving;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.tiled.TiledMap;

import com.monochromatic.god_of_fire.enums.Direction;

/**
 * Represents a projectile entity.
 * 
 * @author calmattier
 */
public class EntityProjectile extends NonlivingEntity {
	protected int attack;

	public EntityProjectile(TiledMap m, int x, int y, Direction d, int s, int a) {
		super(m, x, y, d, s);
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
				if (collides(Direction.UP))
					setForRemoval(true);
			case DOWN:
				if (collides(Direction.DOWN))
					setForRemoval(true);
				location.translate(0, movementSpeed);
			case LEFT:
				if (collides(Direction.LEFT))
					setForRemoval(true);
				location.translate(-movementSpeed, 0);
			case RIGHT:
				if (collides(Direction.RIGHT))
					setForRemoval(true);
				location.translate(movementSpeed, 0);
		}
	}

}