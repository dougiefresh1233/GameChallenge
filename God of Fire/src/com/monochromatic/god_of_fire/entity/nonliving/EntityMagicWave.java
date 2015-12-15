package com.monochromatic.god_of_fire.entity.nonliving;

import com.monochromatic.god_of_fire.enums.DamageType;
import com.monochromatic.god_of_fire.enums.Direction;
import com.monochromatic.god_of_fire.state.GameState;

public class EntityMagicWave extends EntityMagic{

	public EntityMagicWave(GameState g, int x, int y, Direction d, int s, int a, DamageType type) {
		super(g, x, y, d, s, a, type);
		setEmitterFilePath("resources/FireParticle.xml");
		initParticles();
	}
	
	public void updatePosition(float xCoordinate, float yCoordinate){
		particleSystem.update(10);
		particleSystem.setPosition(xCoordinate, yCoordinate);
	}

}
