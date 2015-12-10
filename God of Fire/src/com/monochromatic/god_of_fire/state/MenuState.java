package com.monochromatic.god_of_fire.state;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class MenuState  extends BasicGameState {

	private Rectangle playButton=new Rectangle(300,200,40,20);;
	private Circle cursor=new Circle(0,0,1/2);	//invisible circle at tip of cursor
	private boolean hover=false;
	private boolean click=false;
	public void init(GameContainer gc, StateBasedGame sbg) 
		throws SlickException {
			//playButton = new Rectangle(300,200,40,20);
			//cursor = new Circle(0,0,2);
			//pretty sure these^^^^ were supposed to be here
	}

	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) 
		throws SlickException {
			g.setColor(Color.white);
			g.drawString("God of Fire",270,100);
			g.draw(cursor);
			if(!hover){		//Button turns red if cursor is over it
				g.fill(playButton);
			}else{
				g.setColor(Color.red);
				g.fill(playButton);
			}
			g.setColor(Color.black);
			g.drawString("Play", 300, 200);
			
			
	}

	public void update(GameContainer gc, StateBasedGame sbg, int delta) 
		throws SlickException {
			cursor.setCenterX(gc.getInput().getMouseX());
			cursor.setCenterY(gc.getInput().getMouseY());
			hover=cursor.intersects(playButton);
			click=gc.getInput().isMousePressed(gc.getInput().MOUSE_LEFT_BUTTON);
			if(hover && click){
				sbg.enterState(1);	//begin game
			}
	}

	public int getID() {
		return 0;
	}

}
