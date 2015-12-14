package com.monochromatic.god_of_fire.entity;

import java.util.ArrayList;
import java.util.Iterator;

import org.newdawn.slick.GameContainer;
import com.monochromatic.god_of_fire.entity.Entity;
import com.monochromatic.god_of_fire.entity.collision.CollisionController;
import com.monochromatic.god_of_fire.state.GameState;

public class EntityController {
	protected GameState state;
	protected ArrayList<Entity> entities;

	// Sub-Controllers
	protected CollisionController collision;
	
	public EntityController(GameState state) {
		this.state = state;
		this.entities = new ArrayList<Entity>();
		collision = new CollisionController(state, entities);
		
	}
	
	/**
	 * Updates all entities, as well as removes all entities which are set for
	 * removal.
	 */
	public void update(GameContainer gameScreen) {
		Iterator<Entity> iterate = entities.iterator();
		while(iterate.hasNext()) {
			Entity e = iterate.next();
			if (!e.isSetForRemoval())
				update(e, gameScreen);
			else
				iterate.remove();
		}
	}
	
	/**
	 * Renders all entities.
	 */
	public void render() {
		for (Entity e : entities)
			e.render();
	}
	
	/**
	 * Calls all the methods associated with updating an entity.
	 */
	public void update(Entity e, GameContainer gameScreen) {
		e.update(gameScreen);
		collision.collide(e);
	}
	
	/**
	 * Registers an entity with this controller.
	 */
	public void register(Entity e) {
		if(!entities.contains(e))
			entities.add(e);
	}
	
	/**
	 * Removes an entity from this controller. The proper way to remove an
	 * entity, is to mark it for removal and the controller will take care of
	 * calling this method.
	 */
	public void remove(Entity e) {
		if(entities.contains(e))
			entities.remove(e);
	}
	
	public ArrayList<Entity> getEntities() {
		return entities;
	}
	
}