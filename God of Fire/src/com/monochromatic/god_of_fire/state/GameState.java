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

public class GameState extends BasicGameState{
		 
	//declare variables here
	TiledMap testMap;
	Player player;
	//int level=0;
	//Polygon wall;
	
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		 //All variables defined here
		testMap=new TiledMap("resources/TestMap.tmx");//TODO Replace with real map
		player=new Player(150, 150, 10, 10, 10,testMap);
		/*wall= new Polygon();
		wall.addPoint(0,0);
		wall.addPoint(0,480);
		wall.addPoint(640,480);
		wall.addPoint(640,0);*/
	}

	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		//Draw objects on screen
		testMap.render(0,0);
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

}
