package com.monochromatic.god_of_fire.entity.nonliving;

import com.monochromatic.god_of_fire.enums.DamageTarget;
import com.monochromatic.god_of_fire.enums.DamageType;
import com.monochromatic.god_of_fire.enums.Direction;
import com.monochromatic.god_of_fire.state.GameState;

public class EntityMagicBall extends EntityMagic{

	private DamageType damageType;

	public EntityMagicBall(GameState g, int x, int y, Direction d, 
			int s, int a, DamageType type) {
		super(g, x, y, d, s, a, type);
		this.damageType=type;
	}
	
	

}
