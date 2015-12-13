package com.monochromatic.god_of_fire.entity.nonliving;

import java.awt.Point;

import org.newdawn.slick.tiled.TiledMap;

import com.monochromatic.god_of_fire.entity.Entity;
import com.monochromatic.god_of_fire.entity.living.Player;
import com.monochromatic.god_of_fire.items.Item;

/**
 * This class represents a collectible item entity.
 * 
 * @author calmattier
 *
 */
public class EntityItem extends NonlivingEntity{
	/** Item added to inventory when this item is picked up. */
	protected Item item;

	public EntityItem(TiledMap m, int x, int y, Item i) {
		super(m, x, y);
		// TODO Auto-generated constructor stub
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}
	
	/**
	 * Determines if the given entity has collided with this one. And if the
	 * colliding entity is a player, add this item to their inventory.
	 */
	@Override
	public boolean isColliding(Entity entity){
		boolean result = super.isColliding(entity);
		if (result && entity instanceof Player)
			((Player) entity).getInventory().adjust(item);
		return result;
	}
	
}