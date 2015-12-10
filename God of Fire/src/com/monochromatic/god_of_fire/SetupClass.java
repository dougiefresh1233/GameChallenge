package com.monochromatic.god_of_fire;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import com.monochromatic.god_of_fire.state.GameState;
import com.monochromatic.god_of_fire.state.MenuState;

public class SetupClass extends StateBasedGame{

	public SetupClass(String title) {
		super(title);
		// TODO Auto-generated constructor stub
	}

	public void initStatesList(GameContainer container) throws SlickException {
		this.addState(new MenuState());
		this.addState(new GameState());
		
	}
	



}
