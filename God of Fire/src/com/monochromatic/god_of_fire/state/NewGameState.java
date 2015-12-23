package com.monochromatic.god_of_fire.state;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import com.monochromatic.god_of_fire.SetupClass;

public class NewGameState extends BasicGameState{
	
	//declare variables here
	
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		 //All variables defined here
		
	}

	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		//Draw objects on screen
		g.setColor(Color.white);
		g.drawString("Gender Screem goes here", 270, 100);
	}

	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		//Do all calculations
	}

	public int getID() {	//returns ID for SetupClass
		return SetupClass.newGameState;
	}

}
