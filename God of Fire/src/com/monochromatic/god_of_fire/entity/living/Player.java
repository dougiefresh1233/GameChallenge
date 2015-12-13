package com.monochromatic.god_of_fire.entity.living;
import org.newdawn.slick.Input;

import java.awt.Point;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import com.monochromatic.god_of_fire.entity.Entity;
import com.monochromatic.god_of_fire.enums.Direction;
import com.monochromatic.god_of_fire.state.GameState;
import com.monochromatic.god_of_fire.items.Inventory;
import com.monochromatic.god_of_fire.items.MeleeWeapon;

public class Player extends LivingEntity {
	/**
	 * Players inventory
	 */
	protected Inventory inventory;
	
	Point cameraOffsetPoint=new Point(0,0);
	
	MeleeWeapon equippedWeapon;
	
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
		
		equippedWeapon=new MeleeWeapon("Sword", "A sword", "resources/shittysword.png",
				 c, true, true, 10, 10, 10);
		equippedWeapon.equip(cameraOffsetPoint);
	}
	

	public void update(GameContainer gameScreen){
		try {
			userInput(gameScreen);
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		equippedWeapon.update();
		gameState.getCamera().centerCamera(this);
		cameraOffsetPoint.setLocation((int)(location().getX()-gameState.getCamera().getxOffset()),
					(int)(location().getY()-gameState.getCamera().getyOffset()));
		
	
	}
	
	private void userInput(GameContainer gameScreen) throws SlickException{
		Input userInput = gameScreen.getInput();
		if(userInput.isKeyDown(Input.KEY_W))
			move(Direction.UP);
		else if(userInput.isKeyDown(Input.KEY_S))
			move(Direction.DOWN);
		else if (userInput.isKeyDown(Input.KEY_A))
			move(Direction.LEFT);
		else if (userInput.isKeyDown(Input.KEY_D))
			move(Direction.RIGHT);
		
		if(userInput.isKeyDown(Input.KEY_SPACE)){
			switch (orientation) {
			case UP:
				equippedWeapon.attack(180, 1);
				break;
			case DOWN:
				equippedWeapon.attack(180, -1);
				break;
			case LEFT:
				equippedWeapon.attack(270, -1);
				break;
			case RIGHT:
				equippedWeapon.attack(270, 1);
				break;
			}
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
		if(initComplete){
			currentAnimation.draw((int)(location().getX()-gameState.getCamera().getxOffset()),
					(int)(location().getY()-gameState.getCamera().getyOffset()));
			equippedWeapon.render();
		}
	}


	@Override
	public void collide(Entity e) {
		// TODO Auto-generated method stub
		
	}
}