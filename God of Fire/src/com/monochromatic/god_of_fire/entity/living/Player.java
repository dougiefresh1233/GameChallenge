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
	TiledMap map;
	int TILE_SIZE=32;
	int walls, floor1, floor2, stairs, level;
	GameState game;
	public Player(GameState game, int x, int y, int h, int a, int d, int c, TiledMap m) {
		super(x, y, h, a, d, c);
		this.game=game;
		movementSpeed=2;
		setImage("resources/spriteSheet.png");
		//values for collision
		map=m;
		floor1=map.getLayerIndex("Floor1");
		stairs=map.getLayerIndex("Stairs");
		floor2=map.getLayerIndex("Floor2");
		walls=map.getLayerIndex("Walls");
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
			if (!collides(Direction.UP)) location.translate(0, -movementSpeed);
		}else{
			upwardsMovementAnimation.stop();
		}
		
		if(userInput.isKeyDown(Input.KEY_A)){
			setOrientation(Direction.LEFT);
			leftMovementAnimation.start();
			currentAnimation=leftMovementAnimation;
			if (!collides(Direction.LEFT)) location.translate(-movementSpeed, 0);
		}else{
			leftMovementAnimation.stop();
		}
		
		if(userInput.isKeyDown(Input.KEY_S)){
			setOrientation(Direction.DOWN);
			downwardMovementAnimation.start();
			currentAnimation=downwardMovementAnimation;
			if (!collides(Direction.DOWN)) location.translate(0, movementSpeed);
		}else{
			downwardMovementAnimation.stop();
		}
		
		if(userInput.isKeyDown(Input.KEY_D)){
			setOrientation(Direction.RIGHT);
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
	
	private boolean collides(Direction d){
		int x= (int)Math.round(location.getX()/TILE_SIZE);
		int y= (int)Math.round(location.getY()/TILE_SIZE)+1;
		System.out.println(y);
		System.out.println(location.getY());
		switch(d){
		case UP:
			if(map.getTileId(x, y-1,walls)==0)
			if(map.getTileId(x, y-1,walls)==0) return false;
			/*else*/ return true;
		case DOWN:
			if(map.getTileId(x, y+1, walls)==0) return false;
			/*else*/ return true;
		case RIGHT:
			if(map.getTileId(x+1, y, walls)==0) return false;
			/*else*/ return true;
		case LEFT:
			if(map.getTileId(x-1, y, walls)==0) return false;
			/*else*/ return true;
		}
		
		return true;
	}
	
	@Override
	public void render() {
		if(initComplete)
		currentAnimation.draw((int)(location.getX()-game.getCamera().getxOffset()), (int)(location.getY()-game.getCamera().getyOffset()));
	}
}