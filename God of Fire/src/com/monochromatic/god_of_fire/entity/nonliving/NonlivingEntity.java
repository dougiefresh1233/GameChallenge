package com.monochromatic.god_of_fire.entity.nonliving;

import org.newdawn.slick.GameContainer;

import com.monochromatic.god_of_fire.entity.Entity;
import com.monochromatic.god_of_fire.enums.Direction;
import com.monochromatic.god_of_fire.state.GameState;

/**
 * A non-living entity, represents any entity which does not have a health bar
 * and alive/dead state.
 * 
 * @author calmattier
 *
 */
public abstract class NonlivingEntity extends Entity {
	public boolean collidable;

	public NonlivingEntity(GameState g, int x, int y) {
		super(g, x, y);
		isLiving=false;
	}

	public NonlivingEntity(GameState g, int x, int y, Direction d) {
		super(g, x, y, d);
		isLiving=false;
	}

	public NonlivingEntity(GameState g, int x, int y, Direction d, int s) {
		super(g, x, y, d, s);
		isLiving=false;
	}

	public boolean isCollidable() {
		return collidable;
	}

	public void setCollidable(boolean collidable) {
		this.collidable = collidable;
	}
	
	@Override
	public void render() {
		// TODO Auto-generated method stub
	}
	
	@Override
	public void update(GameContainer g) {
		// TODO Auto-generated method stub
	}

}