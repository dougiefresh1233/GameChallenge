package com.monochromatic.god_of_fire.entity.collision;

import static com.monochromatic.god_of_fire.GameConstants.LAYER_FLOOR_1;
import static com.monochromatic.god_of_fire.GameConstants.LAYER_FLOOR_2;
import static com.monochromatic.god_of_fire.GameConstants.LAYER_STAIRS;
import static com.monochromatic.god_of_fire.GameConstants.LAYER_WALLS;
import static com.monochromatic.god_of_fire.GameConstants.TILE_SIZE;

import org.newdawn.slick.tiled.TiledMap;

import com.monochromatic.god_of_fire.entity.Entity;
import com.monochromatic.god_of_fire.enums.Direction;

public class MapCollider {
	protected TiledMap map;
	private int floor1, floor2, walls, stairs;
	
	public MapCollider(TiledMap map) {
		this.map = map;
		floor1		= map.getLayerIndex(LAYER_FLOOR_1);
		floor2		= map.getLayerIndex(LAYER_FLOOR_2);
		walls		= map.getLayerIndex(LAYER_WALLS);
		stairs		= map.getLayerIndex(LAYER_STAIRS);
	}
	
	public void collide(Entity e) {
		if(collides(e, e.orientation()));
			e.location(e.previous());
	}
	
	public boolean collides(Entity e, Direction d) {
		switch(d){
			case UP: 	return collidesTileUp(e);
			case DOWN: 	return collidesTileDown(e);
			case LEFT: 	return collidesTileLeft(e);
			default: 	return collidesTileRight(e);
		}
	}
	
	private boolean collidesTileUp(Entity e) {
		int x, y;
		x = (int) Math.round(e.previous().getX() / TILE_SIZE);
		y = (int) Math.ceil(e.previous().getY() / TILE_SIZE) + 1;
		if (map.getTileId(x, y - 1, walls) != 0) {
			return true;
		} else if (map.getTileId(x, y - 1, floor2) != 0) {
			if (e.getLevel() == 2) e.setLevel(3);
			return (e.getLevel() == 1) ? true : false;
		} else if (map.getTileId(x, y - 1, stairs) != 0) {
			e.setLevel(2); return false;
		} else if (map.getTileId(x, y - 1, floor1) != 0) {
			if (e.getLevel() == 2) e.setLevel(1);
			return (e.getLevel() == 1 || e.getLevel() == 2) ? false : true;
		} else {
			return true;
		}
	}
	
	private boolean collidesTileDown(Entity e) {
		int x, y;
		x= (int)Math.round(e.previous().getX()/TILE_SIZE);
		y= (int)Math.floor(e.previous().getY()/TILE_SIZE)+1;
		if(map.getTileId(x, y+1, walls) != 0) {
			return true;
		} else if(map.getTileId(x, y+1, floor2) != 0){
			if(e.getLevel() == 2) e.setLevel(3);
			return (e.getLevel() == 1) ? true : false;
		} else if (map.getTileId(x, y+1, stairs) != 0){
			e.setLevel(2); return false;
		} else if(map.getTileId(x, y+1, floor1) != 0){
			if(e.getLevel() == 2) e.setLevel(1);
			return (e.getLevel() == 1 || e.getLevel() == 2) ? false : true;
		} else {
			return true;
		}
	}
	
	private boolean collidesTileLeft(Entity e) {
		int x, y;
		x= (int)Math.ceil(e.previous().getX()/TILE_SIZE);
		y= (int)Math.round(e.previous().getY()/TILE_SIZE)+1;
		if (map.getTileId(x-1, y, walls) != 0) {
			return true;
		} else if(map.getTileId(x-1, y, floor2) != 0) {
			if(e.getLevel() == 2) e.setLevel(3);
			return (e.getLevel() == 1) ? true : false;
		} else if (map.getTileId(x-1, y, stairs) != 0) {
			e.setLevel(2); return false;
		} else if(map.getTileId(x-1, y, floor1) != 0) {
			if(e.getLevel() == 2) e.setLevel(1);
			return (e.getLevel() == 1 || e.getLevel() == 2) ? false : true;
		} else {
			return true;
		}
	}
	
	private boolean collidesTileRight(Entity e) {
		int x, y;
		x= (int)Math.floor(e.previous().getX()/TILE_SIZE);
		y= (int)Math.round(e.previous().getY()/TILE_SIZE)+1;
		if(map.getTileId(x+1, y, walls) != 0){
			return true;
		}else if(map.getTileId(x+1, y, floor2) != 0){
			if(e.getLevel() == 2) e.setLevel(3);
			return (e.getLevel() == 1) ? true : false;
		}else if (map.getTileId(x+1, y, stairs) != 0){
			e.setLevel(2); return false;
		}else if(map.getTileId(x+1, y, floor1) != 0){
			if(e.getLevel() == 2) e.setLevel(1);
			return (e.getLevel() == 1 || e.getLevel() == 2) ? false : true;
		} else {
			return true;
		}
	}
	
}