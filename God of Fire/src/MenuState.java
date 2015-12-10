import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class MenuState  extends BasicGameState {

	private Shape playButton;
	private Shape cursor;
	private boolean hover=false;
	private boolean click=false;
	public void init(GameContainer container, StateBasedGame sbg) 
		throws SlickException {
			playButton = new Rectangle(300,400,50,20);
			cursor = new Circle(0,0,2);
	}

	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) 
		throws SlickException {
			g.drawString("Title",300,300);
			g.draw(playButton);
			g.drawString("Play", 300, 400);
	}

	public void update(GameContainer gc, StateBasedGame sbg, int delta) 
		throws SlickException {
			cursor.setCenterX(gc.getInput().getMouseX());
			cursor.setCenterY(gc.getInput().getMouseY());
			hover=cursor.intersects(playButton);
			click=gc.getInput().isMousePressed(gc.getInput().MOUSE_LEFT_BUTTON);
			if(hover && click){
				sbg.enterState(1);
			}
	}

	public int getID() {
		return 0;
	}

}
