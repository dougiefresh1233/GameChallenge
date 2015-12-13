package com.monochromatic.god_of_fire.entity.ai;

import java.util.ArrayList;
import java.util.List;

import org.newdawn.slick.GameContainer;

import com.monochromatic.god_of_fire.entity.Entity;

public class AI_Controller {
	protected List<AI> ai;
	protected Entity e;
	
	public AI_Controller(Entity e) {
		this.ai = new ArrayList<AI>();
		this.e = e;
	}
	
	public void update(GameContainer gameScreen) {
		for (AI ai : this.ai) {
			ai.update(e, gameScreen);
		}
	}
	
	public void addAI(AI ai) {
		this.ai.add(ai);
	}
}
