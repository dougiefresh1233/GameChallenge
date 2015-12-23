package com.monochromatic.god_of_fire.entity.nonliving;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import com.monochromatic.god_of_fire.enums.Direction;
import com.monochromatic.god_of_fire.state.GameState;

public class EntityFireball extends EntityProjectile {

	Image image;
	
	public EntityFireball(GameState g, int x, int y, Direction d, int s, int l, int a) {
		super(g, x, y, d, s, l, a);
		//this.setSprite("resources/fireball.png");
		try {
			image = new Image("resources/fireball.png");
		} catch (SlickException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void render() {
		image.draw((int)(location().getX()-gameState.getCamera().getxOffset()),
				(int)(location().getY()-gameState.getCamera().getyOffset()));
	}
	
}
