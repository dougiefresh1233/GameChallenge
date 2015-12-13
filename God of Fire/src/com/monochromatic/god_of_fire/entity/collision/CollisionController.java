package com.monochromatic.god_of_fire.entity.collision;

import java.util.ArrayList;
import com.monochromatic.god_of_fire.entity.Entity;
import com.monochromatic.god_of_fire.state.GameState;

public class CollisionController {
	protected GameState state;
	protected ArrayList<Entity> entities;
	
	// Colliders
	protected MapCollider MAP;
	protected EntityCollider ENTITY;
		
	public CollisionController(GameState state, ArrayList<Entity> entities) {
		this.state = state;
		this.entities = entities;
		MAP = new MapCollider(state.getMap());
		ENTITY = new EntityCollider(entities);		
	}
	
	public void collide(Entity entity) {
		MAP.collide(entity);
		ENTITY.collide(entity);
	}
	
}
