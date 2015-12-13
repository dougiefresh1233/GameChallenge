package com.monochromatic.god_of_fire.entity.nonliving;

import org.newdawn.slick.GameContainer;

import com.monochromatic.god_of_fire.entity.Entity;
import com.monochromatic.god_of_fire.enums.Direction;

/**
 * A non-living entity, represents any entity which does not have a health bar
 * and alive/dead state.
 * 
 * @author calmattier
 *
 */
public abstract class NonlivingEntity extends Entity {

	public NonlivingEntity(int x, int y) {
		super(x, y);
	}

	public NonlivingEntity(int x, int y, Direction d) {
		super(x, y, d);
	}

	public NonlivingEntity(int x, int y, Direction d, int s) {
		super(x, y, d, s);
	}

	@Override
	public void move() {
		// TODO Auto-generated method stub
	}

	@Override
	public void render() {
		// TODO Auto-generated method stub
	}
	
	@Override
	public void update(GameContainer gameScreen) {
		// TODO Auto-generated method stub
	}

}