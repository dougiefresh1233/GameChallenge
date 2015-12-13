package com.monochromatic.god_of_fire.entity.ai;

import com.monochromatic.god_of_fire.entity.Entity;
import com.monochromatic.god_of_fire.enums.Direction;

public class PATH_Random implements AI {

	@Override
	public void update(Entity e) {
		Direction d = Direction.random();
		if (e.collides(d))
			d = Direction.change(d);
		e.move(Direction.random());
	}

}