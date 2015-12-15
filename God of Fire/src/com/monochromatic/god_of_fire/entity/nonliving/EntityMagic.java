package com.monochromatic.god_of_fire.entity.nonliving;

import java.io.File;
import java.io.IOException;

import javax.vecmath.Vector2d;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.particles.ConfigurableEmitter;
import org.newdawn.slick.particles.ParticleIO;
import org.newdawn.slick.particles.ParticleSystem;

import com.monochromatic.god_of_fire.enums.DamageType;
import com.monochromatic.god_of_fire.enums.Direction;
import com.monochromatic.god_of_fire.state.GameState;

public class EntityMagic extends EntityProjectile{

	private DamageType damageType;
	
	public ParticleSystem particleSystem;
	
	Image particleImage;
	
	public ConfigurableEmitter emitter;
	
	String emitterFilePath;

	private long startOfCooldown;

	public EntityMagic(GameState g, int x, int y, Direction d, 
			int s, int a, DamageType type) {
		super(g, x, y, d, s, a);
		this.damageType=type;
	}
	
	/**
	 * Precondition- setEmitterFilePath must be run first
	 */
	protected void initParticles(){

		try {
			particleImage= new Image("resources/Particle.png", false);
		} catch (SlickException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		particleSystem= new ParticleSystem(particleImage, 1500);

		try {
			File xmlFile=new File(emitterFilePath);
			emitter = ParticleIO.loadEmitter(xmlFile);
			particleSystem.addEmitter(emitter);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	protected void setEmitterFilePath(String string){
		this.emitterFilePath=string;
	}
	
	public void cast(Direction direction){
		startOfCooldown=System.currentTimeMillis();
		switch(orientation){
		case UP: emitter.angularOffset.setValue(0); 
		break;
		case DOWN: emitter.angularOffset.setValue(180);
		break;
		case LEFT: emitter.angularOffset.setValue(270);
		break;
		case RIGHT: emitter.angularOffset.setValue(90);
		break;
		}
	}
	
	public void resetMagicSkill(){
		if((System.currentTimeMillis()-startOfCooldown)>1000)
			emitter.reset();
	}
	
	public void render(){
		particleSystem.render();
	}
}
