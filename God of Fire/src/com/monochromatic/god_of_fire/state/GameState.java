package com.monochromatic.god_of_fire.state;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class GameState extends BasicGameState{
	
	public void init(GameContainer arg0, StateBasedGame arg1) throws SlickException {
		 
		
	}

	public void render(GameContainer arg0, StateBasedGame sbg, Graphics g) throws SlickException {
		g.drawString("Game Start", 300, 400);
	}

	public void update(GameContainer arg0, StateBasedGame arg1, int arg2) throws SlickException {
		
	}

	public int getID() {
		return 0;
	}

}
