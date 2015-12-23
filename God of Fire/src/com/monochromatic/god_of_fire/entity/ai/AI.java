package com.monochromatic.god_of_fire.entity.ai;

import com.monochromatic.god_of_fire.entity.Entity;

public interface AI {

	/**
	 * Updates this entity based upon the AI mechanics attached to its
	 * {@link AI_Controller}
	 */
	public void update(Entity e);

}
