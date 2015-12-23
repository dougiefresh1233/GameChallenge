package com.monochromatic.god_of_fire.graphics;

import com.monochromatic.god_of_fire.entity.Entity;
import com.monochromatic.god_of_fire.state.GameState;

public class Camera{
	
	/** How many pixels the camera is away from 0,0*/
	private float xOffset, yOffset;
	
	private GameState game;
	
	public Camera(GameState game, float xOffset, float yOffset) {
		this.game=game;
		this.xOffset=xOffset;
		this.yOffset=yOffset;
	}
	
	public void centerCamera(Entity e){
		xOffset=(float)(e.location().getX() - game.getGameWidth()/2);
		yOffset=(float)(e.location().getY() - game.getGameHeight()/2);
	}

	/**
	 * How much the camera is supposed to move.
	 * @param diffX- Distance desired for the camera to move in the x direction
	 * @param diffY- Distance desired for the camera to move in the x direction
	 */
	public void move(float diffX, float diffY){
		xOffset+=diffX;
		yOffset+=diffY;
	}
	
	public float getxOffset() {
		return xOffset;
	}

	public void setxOffset(float xOffset) {
		this.xOffset = xOffset;
	}

	public float getyOffset() {
		return yOffset;
	}

	public void setyOffset(float yOffset) {
		this.yOffset = yOffset;
	}

}
