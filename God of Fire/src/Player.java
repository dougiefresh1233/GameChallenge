import java.awt.Point;

import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.Animation;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;

public class Player extends Entity{
	
	private int ignis;
	
	public Player(){
		super();
	}
	
	public Player(int xPosition, int yPosition, int attack, int maxHealth, int defense){
		super(xPosition, yPosition, attack, maxHealth, defense);
		movementSpeed=1;
	}
	
	
	public void userInput(GameContainer gameScreen) throws SlickException{
		Input userInput=gameScreen.getInput();
		
		if(userInput.isKeyDown(userInput.KEY_W)){
			setOrientation(direction.up);
			currentAnimation=upwardsMovementAnimation;
			playerLocation.translate(0, -movementSpeed);
		}
		
		if(userInput.isKeyDown(userInput.KEY_A)){
			setOrientation(direction.left);
			currentAnimation=leftMovementAnimation;
			playerLocation.translate(-movementSpeed, 0);
		}
		
		if(userInput.isKeyDown(userInput.KEY_S)){
			setOrientation(direction.down);
			currentAnimation=downwardMovementAnimation;
			playerLocation.translate(movementSpeed, 0);
		}
		
		if(userInput.isKeyDown(userInput.KEY_D)){
			setOrientation(direction.right);
			currentAnimation=rightMovementAnimation;
			playerLocation.translate(0, -movementSpeed);
		}
		
		
	}

}
