package com.monochromatic.god_of_fire.entity.ai;

import javax.vecmath.Vector2d;

import com.monochromatic.god_of_fire.entity.Entity;

public class PATH_Chase implements AI {

	@Override
	public void update(Entity e) {
		if(Math.random() <= 0.1) {
			double x = e.location().getX();
			double y = e.location().getY();
			double px = e.getGameState().getPlayer().location().getX();
			double py = e.getGameState().getPlayer().location().getY();
			double dx = px - x;
			double dy = py - y;
			Vector2d velocity = new Vector2d(dx, dy);
			velocity.normalize();
			velocity.scale(e.getSpeed());
			e.setVelocity(velocity);
		}
		e.move();
	}
	
}