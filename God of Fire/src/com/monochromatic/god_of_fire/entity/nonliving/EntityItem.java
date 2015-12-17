package com.monochromatic.god_of_fire.entity.nonliving;

import com.monochromatic.god_of_fire.entity.Entity;
import com.monochromatic.god_of_fire.entity.living.Player;
import com.monochromatic.god_of_fire.items.Item;
import com.monochromatic.god_of_fire.state.GameState;

/**
 * This class represents a collectible item entity.
 * 
 * @author calmattier
 */
public class EntityItem extends NonlivingEntity {
	/** Item added to inventory when this item is picked up. */
	protected Item item;

	public EntityItem(GameState g, int x, int y, Item i) {
		super(g, x, y);
		this.item = i;
	}

	/**
	 * Get the {@link Item} associated with this entity.
	 */
	public Item getItem() {
		return item;
	}

	/**
	 * Set the {@link Item} associated with this entity.
	 */
	public void setItem(Item item) {
		this.item = item;
	}

	@Override
	public void collide(Entity e) {
		if (e instanceof Player) {
			((Player) e).getInventory().adjust(item);
			this.setForRemoval(true);
		}
		else
			return; // Do Nothing
	}
	
	@Override
	public void render() {
		item.getImage().draw((int)(location().getX()-gameState.getCamera().getxOffset()),
				(int)(location().getY()-gameState.getCamera().getyOffset()));
	}

}