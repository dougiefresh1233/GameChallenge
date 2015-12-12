package com.monochromatic.god_of_fire.state;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import com.monochromatic.god_of_fire.SetupClass;
import com.monochromatic.god_of_fire.entity.living.Player;

public class GameState extends BasicGameState{
	
	Player player;
	
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		 player=new Player(100, 100, 10, 10, 10);
		
	}

	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		//Draw objects on screen
		g.setColor(Color.white);
		g.drawString("Game Start", 270, 100);
		player.render();
	}

	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		player.update(gc);
	}

	public int getID() {	//returns ID for SetupClass
		return SetupClass.gameState;
	}

}
