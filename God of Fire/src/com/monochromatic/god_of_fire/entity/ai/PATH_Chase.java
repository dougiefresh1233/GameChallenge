package com.monochromatic.god_of_fire.entity.ai;

import com.monochromatic.god_of_fire.entity.Entity;
import com.monochromatic.god_of_fire.enums.Direction;

public class PATH_Chase implements AI {

	@Override
	public void update(Entity e) {
		Direction d;
		double x = e.location().getX();
		double y = e.location().getY();
		double px = e.getGameState().getPlayer().location().getX();
		double py = e.getGameState().getPlayer().location().getY();
		if(Math.random() <= 0.1) {
			double dx = x - px;
			double dy = y - py;
			if (Math.abs(dx) > Math.abs(dy)) {
				if (dx <= 0)
					d = Direction.RIGHT;
				else
					d = Direction.LEFT;
			} else {
				if (dy <= 0)
					d = Direction.DOWN;
				else
					d = Direction.UP;
			}
		} else
			d = e.orientation();
		e.move(d);
	}
	
}