package com.monochromatic.god_of_fire.entity.living;
import org.newdawn.slick.Input;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.tests.xml.Inventory;

import com.monochromatic.god_of_fire.enums.Direction;
import com.monochromatic.god_of_fire.state.GameState;

public class Player extends LivingEntity {
	/**
	 * Players inventory
	 */
	protected Inventory inventory;
	
	GameState game;
	
	public Player(GameState game, int x, int y, int h, int a, int d) {
		super(x, y, h, a, d);
		this.game=game;
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

		game.getCamera().centerCamera(this);
	
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
	public void attack() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void render() {
		if(initComplete)
		currentAnimation.draw((int)(location.getX()-game.getCamera().getxOffset()), (int)(location.getY()-game.getCamera().getyOffset()));
	}
	
}