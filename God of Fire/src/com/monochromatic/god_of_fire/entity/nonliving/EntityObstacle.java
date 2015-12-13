package com.monochromatic.god_of_fire.entity.nonliving;

import com.monochromatic.god_of_fire.entity.Entity;
import com.monochromatic.god_of_fire.enums.Direction;
import com.monochromatic.god_of_fire.state.GameState;

public class EntityObstacle  extends NonlivingEntity {
	
	public EntityObstacle(GameState g, int x, int y, Direction d){
		super(g, x, y, d);
		setHardCollision(true);
	}

	@Override
	public void collide(Entity e) {
		// TODO Auto-generated method stub
		
	}

}
