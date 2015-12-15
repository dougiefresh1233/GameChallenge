package com.monochromatic.god_of_fire.entity.living.monster;

import javax.vecmath.Vector2d;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import com.monochromatic.god_of_fire.entity.Entity;
import com.monochromatic.god_of_fire.entity.ai.ACTION_ShootPlayer;
import com.monochromatic.god_of_fire.entity.ai.Sniper;
import com.monochromatic.god_of_fire.entity.nonliving.EntityFireball;
import com.monochromatic.god_of_fire.enums.Direction;
import com.monochromatic.god_of_fire.state.GameState;

public class FireTurret extends Monster implements Sniper {
	Image image;
	
	public FireTurret(GameState g, int x, int y, int h, int a, int d, int c) {
		super(g, x, y, h, a, d, c);
		
		try {
			image = new Image("resources/shittysword.png");
		} catch (SlickException e) {
			e.printStackTrace();
		}
		//setSprite("resources/fireball.png");
		//setSprite("resources/fireTurret.png");
		//this.attachAI(new FireAtPlayer());
		//this.attachAI(new PATH_Chase());
		this.attachAI(new ACTION_ShootPlayer());
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
		super.update(gameScreen);
	}
	
	@Override
	public void render() {
		image.draw((int)(location().getX()-gameState.getCamera().getxOffset()),
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