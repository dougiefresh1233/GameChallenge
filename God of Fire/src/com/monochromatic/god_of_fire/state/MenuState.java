package com.monochromatic.god_of_fire.state;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class MenuState  extends BasicGameState {

	//Buttons
	private Rectangle continueButton;
	private Rectangle newButton;
	private Rectangle loadButton;
	private Rectangle optionsButton;
	private Rectangle exitButton;
	
	private Circle cursor;	//invisible circle at tip of cursor
	//if mouse is over button
	private boolean hoverContinue=false;
	private boolean hoverNew=false;
	private boolean hoverLoad=false;
	private boolean hoverOptions=false;
	private boolean hoverExit=false;
	private boolean click=false;
	//menu background
	private Image menu;

	public void init(GameContainer gc, StateBasedGame sbg) 
		throws SlickException {
			menu = new Image("resources/menu_screen.png");
			continueButton=new Rectangle(265,178,120,20);
			newButton=new Rectangle(295,205,50,20);
			loadButton=new Rectangle(290,230,60,20);
			optionsButton=new Rectangle(270,255,100,20);
			exitButton=new Rectangle(295,280,55,20);
			
			cursor=new Circle(0,0,1/2);
			
	}

	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) 
		throws SlickException {
			g.drawImage(menu, 0, 0);	//attaches menu image
			g.setColor(Color.white);
			if(hoverContinue) g.draw(continueButton);
			if(hoverNew) g.draw(newButton);
			if(hoverLoad) g.draw(loadButton);
			if(hoverOptions) g.draw(optionsButton);
			if(hoverExit) g.draw(exitButton);
			
			g.drawString("God of Fire",270,100);
	}

	public void update(GameContainer gc, StateBasedGame sbg, int delta) 
		throws SlickException {
			//cursor follows mouse movement
			cursor.setCenterX(gc.getInput().getMouseX());
			cursor.setCenterY(gc.getInput().getMouseY());
			//collison detection
			hoverContinue=cursor.intersects(continueButton);
			hoverNew=cursor.intersects(newButton);
			hoverLoad=cursor.intersects(loadButton);
			hoverOptions=cursor.intersects(optionsButton);
			hoverExit=cursor.intersects(exitButton);
			
			click=gc.getInput().isMousePressed(gc.getInput().MOUSE_LEFT_BUTTON);
			if(hoverContinue && click){
				sbg.enterState(1);	//begin game
			}
	}

	public int getID() {
		return 0;
	}

}
