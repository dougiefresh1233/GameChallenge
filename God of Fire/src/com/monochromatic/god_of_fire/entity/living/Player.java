package com.monochromatic.god_of_fire.entity.living;
import org.newdawn.slick.Input;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;

import com.monochromatic.god_of_fire.enums.Direction;
import com.monochromatic.god_of_fire.items.Inventory;

public class Player extends LivingEntity {
	/**
	 * Players inventory
	 */
	protected Inventory inventory;

	public Player(int x, int y, int h, int a, int d, int c) {
		super(x, y, h, a, d, c);
		movementSpeed=2;
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
			upwardsMovementAnimation.start();
			currentAnimation=upwardsMovementAnimation;
			location.translate(0, -movementSpeed);
		}else{
			upwardsMovementAnimation.stop();
		}
		
		if(userInput.isKeyDown(Input.KEY_A)){
			setOrientation(Direction.LEFT);
			leftMovementAnimation.start();
			currentAnimation=leftMovementAnimation;
			location.translate(-movementSpeed, 0);
		}else{
			leftMovementAnimation.stop();
		}
		
		if(userInput.isKeyDown(Input.KEY_S)){
			setOrientation(Direction.DOWN);
			downwardMovementAnimation.start();
			currentAnimation=downwardMovementAnimation;
			location.translate(0, movementSpeed);
		}else{
			downwardMovementAnimation.stop();
		}
		
		if(userInput.isKeyDown(Input.KEY_D)){
			setOrientation(Direction.RIGHT);
			rightMovementAnimation.start();
			currentAnimation=rightMovementAnimation;
			location.translate(movementSpeed, 0);
		}else{
			rightMovementAnimation.stop();
		}
		
	}

	@Override
	public void attackAnim() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void hurtAnim() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void healedAnim() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void deathAnim() {
		// TODO Auto-generated method stub
		
	}
	
	public Inventory getInventory() {
		return inventory;
	}

	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}

	@Override
	public void render() {
		// TODO Auto-generated method stub
		
	}
	
}