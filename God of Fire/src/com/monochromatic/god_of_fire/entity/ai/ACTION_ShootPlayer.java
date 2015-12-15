package com.monochromatic.god_of_fire.entity.ai;

import javax.vecmath.Vector2d;

import com.monochromatic.god_of_fire.entity.Entity;

public class ACTION_ShootPlayer implements AI {

	@Override
	public void update(Entity e) {
		if (e instanceof Sniper && Math.random() <= 0.01) {
			Sniper sniper = (Sniper) e;
			double x = e.location().getX();
			double y = e.location().getY();
			double px = e.getGameState().getPlayer().location().getX();
			double py = e.getGameState().getPlayer().location().getY();
			double dx = px - x;
			double dy = py - y;
			Vector2d direction = new Vector2d(dx, dy);
			direction.normalize();
			sniper.shoot(direction);
		}
	}

}
