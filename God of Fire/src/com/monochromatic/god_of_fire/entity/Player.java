package com.monochromatic.god_of_fire.entity;
import org.newdawn.slick.Input;
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

	@Override
	public void attack() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void move() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render() {
		// TODO Auto-generated method stub
		
	}

}
