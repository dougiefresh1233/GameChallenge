package com.monochromatic.god_of_fire.entity.ai;

import com.monochromatic.god_of_fire.entity.Entity;
import com.monochromatic.god_of_fire.enums.Direction;

public class PATH_Random implements AI {

	@Override
	public void update(Entity e) {
		Direction d;
		if((Math.random() <= 0.01) || (e.location().equals(e.previous())))
			d = Direction.exclude(e.orientation());
		else
			d = e.orientation();
		e.move(d);
	}

}