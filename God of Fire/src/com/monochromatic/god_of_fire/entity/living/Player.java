package com.monochromatic.god_of_fire.entity.living;
import org.newdawn.slick.Input;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
//import org.newdawn.slick.tests.xml.Inventory;
import org.newdawn.slick.tiled.TiledMap;
import com.monochromatic.god_of_fire.enums.Direction;
import com.monochromatic.god_of_fire.state.GameState;
import com.monochromatic.god_of_fire.items.Inventory;

public class Player extends LivingEntity {
	/**
	 * Players inventory
	 */
	protected Inventory inventory;
	GameState game;
	public Player(GameState game, int x, int y, int h, int a, int d, int c, TiledMap m) {
		super(m, x, y, h, a, d, c);
		this.game=game;
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
			orientation(Direction.UP);
			upwardsMovementAnimation.start();
			currentAnimation=upwardsMovementAnimation;
			if (!collides(Direction.UP)) location.translate(0, -movementSpeed);
		}else{
			upwardsMovementAnimation.stop();
		}
		
		if(userInput.isKeyDown(Input.KEY_A)){
			orientation(Direction.LEFT);
			leftMovementAnimation.start();
			currentAnimation=leftMovementAnimation;
			if (!collides(Direction.LEFT)) location.translate(-movementSpeed, 0);
		}else{
			leftMovementAnimation.stop();
		}
		
		if(userInput.isKeyDown(Input.KEY_S)){
			orientation(Direction.DOWN);
			downwardMovementAnimation.start();
			currentAnimation=downwardMovementAnimation;
			if (!collides(Direction.DOWN)) location.translate(0, movementSpeed);
		}else{
			downwardMovementAnimation.stop();
		}
		
		if(userInput.isKeyDown(Input.KEY_D)){
			orientation(Direction.RIGHT);
			rightMovementAnimation.start();
			currentAnimation=rightMovementAnimation;
			if (!collides(Direction.RIGHT)) location.translate(movementSpeed, 0);
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
		if(initComplete)
		currentAnimation.draw((int)(location.getX()-game.getCamera().getxOffset()), (int)(location.getY()-game.getCamera().getyOffset()));
	}
}