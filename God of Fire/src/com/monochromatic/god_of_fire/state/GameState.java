package com.monochromatic.god_of_fire.state;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.tiled.TiledMap;

import com.monochromatic.god_of_fire.SetupClass;
import com.monochromatic.god_of_fire.entity.living.Player;
import com.monochromatic.god_of_fire.entity.living.monster.Monster;
import com.monochromatic.god_of_fire.graphics.Camera;

public class GameState extends BasicGameState{
		 
	//declare variables here
	TiledMap map;
	Player player;
	Monster monster;
	
	private final int gameWidth=640;
	private final int gameHeight=480;
	
	Camera playersPerspective;
	
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		 //All variables defined here
		map=new TiledMap("resources/Map.tmx");//TODO Replace with real map
		player=new Player(this, 800, 1020, 10, 10, 10,5,map);
		//monster = new Monster(map, 150, 150, 200, 10, 20, 3); 
		playersPerspective=new Camera(this, 0,0);
	}

	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		//Draw objects on screen
		map.render(0 - (int)playersPerspective.getxOffset(), 
				0- (int)playersPerspective.getyOffset());
		player.render();
		//monster.render();
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
