package com.monochromatic.god_of_fire.entity.nonliving;

import java.io.File;
import java.io.IOException;
import java.lang.annotation.ElementType;
import java.util.List;

import javax.vecmath.Vector2d;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.particles.ConfigurableEmitter;
import org.newdawn.slick.particles.ParticleIO;
import org.newdawn.slick.particles.ParticleSystem;

import com.monochromatic.god_of_fire.entity.EntityUtility;
import com.monochromatic.god_of_fire.entity.living.monster.Monster;
import com.monochromatic.god_of_fire.enums.DamageType;
import com.monochromatic.god_of_fire.enums.Direction;
import com.monochromatic.god_of_fire.enums.ElementalType;
import com.monochromatic.god_of_fire.state.GameState;

public class EntityMagic extends EntityProjectile{

	private ElementalType elementType;
	
	public ParticleSystem particleSystem;
	
	Image particleImage;
	
	public ConfigurableEmitter emitter;
	
	private boolean isIntersected=false;
	
	String emitterFilePath;

	private long startOfCooldown;

	public EntityMagic(GameState g, int x, int y, Direction d, int s, int a, int l, ElementalType type) {
		super(g, x, y, d, s, l, a);
		this.elementType=type;
	}
	
	/**
	 * Precondition- setEmitterFilePath must be run first
	 */
	protected void initParticles(){

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
	
	
	public void setRotation(int value){
		emitter.angularOffset.setValue(value);
	}
	
	protected void setEmitterFilePath(String string){
		this.emitterFilePath=string;
	}
	

	public void update(GameContainer gc){
		particleSystem.update(100);
		if(!isIntersected){
			super.update(gc);
		}

		List<Monster> targets = EntityUtility.intersectsMonsters(getGameState().getEC().getEntities(), 
				calculateAttackArea());
		for (Monster m : targets){
			if(m.adjustHealth(getAttack()))
				isIntersected=true;
				emitter.spawnCount.setMax(300);
				emitter.speed.setMax(50);
				emitter.spread.setValue(360);
				emitter.initialDistance.setMax(10);
				m.kill();
		}
	}
	

	
	private double[] calculateAttackArea() {
		double[] area = new double[4];
			area[0] = (location().getX());
			area[1] = (location().getY());
			area[2] = (location().getX() + 64);
			area[3] = (location().getY() + 64);
			System.out.println(area[0]);
		return area;
	}

	
	public void setImage(String filePath){
		try {
			particleImage= new Image(filePath, false);
		} catch (SlickException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	
	public void render(){
		particleSystem.render((int)(location().getX()-gameState.getCamera().getxOffset()),
				(int)(location().getY()-gameState.getCamera().getyOffset()));
	}
}
