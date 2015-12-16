package com.monochromatic.god_of_fire.entity.nonliving;

import java.lang.annotation.ElementType;

import javax.vecmath.Vector2d;

import com.monochromatic.god_of_fire.enums.DamageType;
import com.monochromatic.god_of_fire.enums.Direction;
import com.monochromatic.god_of_fire.enums.ElementalType;
import com.monochromatic.god_of_fire.state.GameState;

public class EntityMagicBall extends EntityMagic{

	public EntityMagicBall(GameState g, int x, int y, Direction d, int s, int a, ElementalType type) {
		super(g, x, y, d, s, a, type);
		
		switch (type) {
		case IGNIS: 
			setImage("resources/Particle.png");
			setEmitterFilePath("resources/FireParticle.xml"); 
		break;
		case FLUMINIS: 
			setImage("resources/waterDrop.png");
			setEmitterFilePath("resources/WaterParticle.xml");
		break;
		case VIRENTIA: 
			setImage("resources/leaf.png");
			setEmitterFilePath("resources/PlantParticle.xml");
		break;
		case AERIS: 
			setImage("resources/Particle.png");
			setEmitterFilePath("resources/AirParticle.xml");
		break;
		}
		
		initParticles();
	}


}
