package com.monochromatic.god_of_fire.entity.living.monster;

import org.newdawn.slick.GameContainer;
import com.monochromatic.god_of_fire.entity.ai.AI_Controller;
import com.monochromatic.god_of_fire.entity.living.LivingEntity;
import com.monochromatic.god_of_fire.state.GameState;

public abstract class Monster extends LivingEntity {
	protected AI_Controller controller;
	
	public Monster(GameState g, int x, int y, int h) {
		this(g, x, y, h, 0, 0, 0);
	}
	
	public Monster(GameState g, int x, int y, int h, int a, int d, int c) {
		super(g, x, y, h, a, d, c);
		this.controller = new AI_Controller(this);
		attachAI();
	}
	
	@Override
	public void update(GameContainer gameScreen) {
		controller.update();
	}
	
	/** Attaches AI to this entities {@link AI_Controller}*/
	public abstract void attachAI();
	
}