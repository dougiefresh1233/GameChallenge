package com.monochromatic.god_of_fire.state;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
//import org.newdawn.slick.geom.Polygon;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.tiled.TiledMap;

import com.monochromatic.god_of_fire.SetupClass;
import com.monochromatic.god_of_fire.entity.living.Player;
import com.monochromatic.god_of_fire.graphics.Camera;

public class GameState extends BasicGameState{
		 
	//declare variables here
	TiledMap testMap;
	Player player;
	
	private final int gameWidth=640;
	private final int gameHeight=480;
	
	Camera playersPerspective;
	//int level=0;
	//Polygon wall;
	
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		 //All variables defined here
		testMap=new TiledMap("resources/Map.tmx");//TODO Replace with real map
		player=new Player(this, 150, 150, 10, 10, 10,5,testMap);
		playersPerspective=new Camera(this, 0,0);

		/*wall= new Polygon();
		wall.addPoint(0,0);
		wall.addPoint(0,480);
		wall.addPoint(640,480);
		wall.addPoint(640,0);*/
	}

	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		//Draw objects on screen
		testMap.render(0 - (int)playersPerspective.getxOffset(), 
				0- (int)playersPerspective.getyOffset());
		g.setColor(Color.white);
		g.drawString("Game Start", 270, 100);
		player.render();
		/*
		g.setColor(Color.red);
		g.draw(wall);
		*/
	}

	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		player.update(gc);

	}

	public int getID() {	//returns ID for SetupClass
		return SetupClass.gameState;
	}
	

	public int getGameWidth() {
		return gameWidth;
	}

	public int getGameHeight() {
		return gameHeight;
	}
	
	public Camera getCamera(){
		return playersPerspective;
	}

	


}
