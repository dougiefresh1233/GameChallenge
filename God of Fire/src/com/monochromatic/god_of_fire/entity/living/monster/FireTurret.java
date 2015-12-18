package com.monochromatic.god_of_fire.entity.living.monster;

import java.io.File;
import java.io.IOException;

import javax.vecmath.Vector2d;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.particles.ConfigurableEmitter;
import org.newdawn.slick.particles.ParticleIO;
import org.newdawn.slick.particles.ParticleSystem;

import com.monochromatic.god_of_fire.entity.Entity;
import com.monochromatic.god_of_fire.entity.ai.ACTION_ShootPlayer;
import com.monochromatic.god_of_fire.entity.ai.Sniper;
import com.monochromatic.god_of_fire.entity.nonliving.EntityFireball;
import com.monochromatic.god_of_fire.enums.Direction;
import com.monochromatic.god_of_fire.state.GameState;

public class FireTurret extends Monster implements Sniper {
	ParticleSystem particleSystem;
	Image particleImage;
	ConfigurableEmitter emitter;
	
	public FireTurret(GameState g, int x, int y, int h, int a, int d, int c) {
		super(g, x, y, h, a, d, c);
		setImage("resources/KillerEye.png");
		try {
			initSingleSpriteSheet(32, 32);
		} catch (SlickException e) {
			e.printStackTrace();
		}
		initParticles();
		//setSprite("resources/fireball.png");
		//setSprite("resources/fireTurret.png");
		//this.attachAI(new FireAtPlayer());
		//this.attachAI(new PATH_Chase());
		this.attachAI(new ACTION_ShootPlayer());
	}
	
	protected void initParticles(){

		try {
			particleImage= new Image("resources/Particle.png", false);
		} catch (SlickException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} 
		particleSystem= new ParticleSystem(particleImage, 1500);

		try {
			File xmlFile=new File("resources/BlackCloud.xml");
			emitter = ParticleIO.loadEmitter(xmlFile);
			particleSystem.addEmitter(emitter);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void shoot(Vector2d direction) {
		EntityFireball fireball = new EntityFireball(getGameState(), 
				(int) location().getX(), (int) location().getY(),
				Direction.DOWN, 3, 0);
		fireball.setDirection(direction);
		this.getGameState().getEC().register(fireball);
	}
	
	public void update(GameContainer gameScreen){
		particleSystem.update(100);
		super.update(gameScreen);
	}
	
	@Override
	public void render() {
		particleSystem.render((int)(location().getX()-gameState.getCamera().getxOffset()+16),
				(int)(location().getY()-gameState.getCamera().getyOffset()+16));
		currentAnimation.draw((int)(location().getX()-gameState.getCamera().getxOffset()),
				(int)(location().getY()-gameState.getCamera().getyOffset()));

	}

	
	@Override
	public void attackAnim() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hurtAnim() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void healedAnim() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deathAnim() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void collide(Entity e) {
		// TODO Auto-generated method stub
		
	}
	
}