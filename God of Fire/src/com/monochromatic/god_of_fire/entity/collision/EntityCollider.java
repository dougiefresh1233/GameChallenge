package com.monochromatic.god_of_fire.entity.collision;

import java.util.ArrayList;
import com.monochromatic.god_of_fire.entity.Entity;

public class EntityCollider {
	protected ArrayList<Entity> entities;
	
	public EntityCollider(ArrayList<Entity> entities) {
		this.entities = entities;
	}
	
	public void collide(Entity e) {
		hardCollision(e);
		softCollision(e);
	}
	
	/**
	 * Determines if this entity is undergoing a hard collision, and performs
	 * the collision if so. Hard collisions occur before soft collisions, so
	 * that the final entity locations are correct when determining soft
	 * collisions.
	 */
	public void hardCollision(Entity entity) {
		for (Entity e : entities) {
			if (!e.isHardCollision())
				continue;
			if(colliding(entity, e)) {
				e.collide(entity);
				break;
			}
		}
	}
	
	/**
	 * Determines if this entity is undergoing a soft collision, and performs
	 * the collision if so.
	 */
	public void softCollision(Entity entity) {
		for (Entity e : entities) {
			if (e.isHardCollision())
				continue;
			if(colliding(entity, e))
				e.collide(entity);
		}
	}
	
	/**
	 * Determines if two entities are in a state of collision.
	 */
	public boolean colliding(Entity e1, Entity e2) {
		return e1.location().equals(e2.location());
	}
	
}