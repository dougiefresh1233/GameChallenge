package com.monochromatic.god_of_fire.entity.living;
import org.newdawn.slick.Input;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;

import com.monochromatic.god_of_fire.entity.Entity;
import com.monochromatic.god_of_fire.enums.Direction;
import com.monochromatic.god_of_fire.state.GameState;
import com.monochromatic.god_of_fire.items.Inventory;

public class Player extends LivingEntity {
	/**
	 * Players inventory
	 */
	protected Inventory inventory;
	
	
	GameState game;
	public Player(GameState g, int x, int y, int h, int a, int d, int c) {
		super(g, x, y, h, a, d, c);
		movementSpeed=2;
		setImage("resources/spriteSheet.png");
		//values for collision
		try {
			init();
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	public void update(GameContainer gameScreen){
		userInput(gameScreen);
		game.getCamera().centerCamera(this);
	}
	
	private void userInput(GameContainer gameScreen) {
		Input userInput = gameScreen.getInput();
		if(userInput.isKeyDown(Input.KEY_W))
			move(Direction.UP);
		else if(userInput.isKeyDown(Input.KEY_S))
			move(Direction.DOWN);
		else if (userInput.isKeyDown(Input.KEY_A))
			move(Direction.LEFT);
		else if (userInput.isKeyDown(Input.KEY_D))
			move(Direction.RIGHT);
		else
			return;
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
		if (initComplete)
			currentAnimation.draw((int) (location().getX() - game.getCamera().getxOffset()),
					(int) (location().getY() - game.getCamera().getyOffset()));
	}


	@Override
	public void collide(Entity e) {
		// TODO Auto-generated method stub
		
	}
	
}