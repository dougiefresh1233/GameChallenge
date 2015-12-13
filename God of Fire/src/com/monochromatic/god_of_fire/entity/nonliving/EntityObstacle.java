package com.monochromatic.god_of_fire.entity.nonliving;

import org.newdawn.slick.tiled.TiledMap;

import com.monochromatic.god_of_fire.enums.Direction;

public class EntityObstacle  extends NonlivingEntity {
	public EntityObstacle(TiledMap m, int x, int y, Direction d){
		super(m, x, y, d);
	}
}
