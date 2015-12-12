package com.monochromatic.god_of_fire.entity.living;
import org.newdawn.slick.Input;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.tests.xml.Inventory;

import com.monochromatic.god_of_fire.enums.Direction;

public class Player extends LivingEntity {
	/**
	 * Players inventory
	 */
	protected Inventory inventory;
	
	public Player(int x, int y, int h, int a, int d) {
		super(x, y, h, a, d);
		movementSpeed=4;
		setImage("resources/spriteSheet.png");
		try {
			init();
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	public void update(GameContainer gameScreen){
		try {
			userInput(gameScreen);
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}
	
	private void userInput(GameContainer gameScreen) throws SlickException{
		Input userInput=gameScreen.getInput();
		
		
		
		if(userInput.isKeyDown(Input.KEY_W)){
			setOrientation(Direction.UP);
			currentAnimation=upwardsMovementAnimation;
			location.translate(0, -movementSpeed);
		}
		
		if(userInput.isKeyDown(Input.KEY_A)){
			setOrientation(Direction.LEFT);
			currentAnimation=leftMovementAnimation;
			location.translate(-movementSpeed, 0);
		}
		
		if(userInput.isKeyDown(Input.KEY_S)){
			setOrientation(Direction.DOWN);
			currentAnimation=downwardMovementAnimation;
			location.translate(0, movementSpeed);
		}
		
		if(userInput.isKeyDown(Input.KEY_D)){
			setOrientation(Direction.RIGHT);
			currentAnimation=rightMovementAnimation;
			location.translate(movementSpeed, 0);
		}
		

		
	}
	
	@Override
	public void attack() {
		// TODO Auto-generated method stub
		
	}
	
}