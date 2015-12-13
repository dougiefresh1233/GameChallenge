package com.monochromatic.god_of_fire.entity.nonliving;

import org.newdawn.slick.GameContainer;

import com.monochromatic.god_of_fire.enums.Direction;

/**
 * Represents a static hazard entity (ie. spikes or lava).
 * 
 * @author calmattier
 */
public class EntityHazard extends NonlivingEntity{
	protected int attack;
	
	public EntityHazard(int x, int y, Direction d, int a){
		super(x, y, d, 0);
	}
	
	public int getAttack() {
		return attack;
	}

	public void setAttack(int attack) {
		this.attack = attack;
	}

	@Override
	public void update(GameContainer gameScreen) {
		// TODO Auto-generated method stub
		
	}
	
}