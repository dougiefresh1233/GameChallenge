package com.monochromatic.god_of_fire.entity.ai;

import java.util.ArrayList;
import java.util.List;

import com.monochromatic.god_of_fire.entity.Entity;

public class AI_Controller {
	protected List<AI> ai;
	protected Entity e;
	
	public AI_Controller(Entity e) {
		this.ai = new ArrayList<AI>();
		this.e = e;
	}
	
	public void update() {
		for (AI ai : this.ai) {
			ai.update(e);
		}
	}
	
	public void addAI(AI ai) {
		this.ai.add(ai);
	}
}
