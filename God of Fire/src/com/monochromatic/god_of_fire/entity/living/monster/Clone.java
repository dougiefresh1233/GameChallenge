package com.monochromatic.god_of_fire.entity.living.monster;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;

import com.monochromatic.god_of_fire.entity.Entity;
import com.monochromatic.god_of_fire.entity.ai.PATH_Random;
import com.monochromatic.god_of_fire.state.GameState;

public class Clone extends Monster {
	
	public Clone(GameState g, int x, int y, int h, int a, int d, int c) {
		super(g, x, y, h, a, d, c);
		movementSpeed = 2;
		setImage("resources/spriteSheet.png");
		this.attachAI(new PATH_Random());
		
		try {
			init();
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void update(GameContainer gameScreen){
		super.update(gameScreen);
	}
	
	@Override
	public void render() {
		if(initComplete){
			currentAnimation.draw((int)(location().getX()-gameState.getCamera().getxOffset()),
					(int)(location().getY()-gameState.getCamera().getyOffset()));
		}
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