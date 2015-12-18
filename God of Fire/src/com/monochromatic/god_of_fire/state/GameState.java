package com.monochromatic.god_of_fire.state;
import javax.vecmath.Vector2d;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.tiled.TiledMap;

import com.monochromatic.god_of_fire.SetupClass;
import com.monochromatic.god_of_fire.entity.EntityController;
import com.monochromatic.god_of_fire.entity.living.Player;
import com.monochromatic.god_of_fire.entity.living.monster.Clone;
import com.monochromatic.god_of_fire.entity.living.monster.FireTurret;
import com.monochromatic.god_of_fire.entity.living.monster.Hydra;
import com.monochromatic.god_of_fire.entity.living.monster.Spider;
import com.monochromatic.god_of_fire.entity.nonliving.EntityFireball;
import com.monochromatic.god_of_fire.entity.nonliving.EntityItem;
import com.monochromatic.god_of_fire.enums.Direction;
import com.monochromatic.god_of_fire.graphics.Camera;
import com.monochromatic.god_of_fire.items.Item;

public class GameState extends BasicGameState{
	EntityController EC;
	TiledMap map;
	Player player;
	Image HUD;
	
	private final int gameWidth=640;
	private final int gameHeight=480;
	
	Camera playersPerspective;
	
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		 //All variables defined here
		map = new TiledMap("resources/Map.tmx");//TODO Replace with real map
		EC = new EntityController(this); // Must be declared AFTER map
		HUD = new Image("resources/HUD.png");
		
		player = new Player(this, 800, 1020, 10, 10, 10, 5);
		//EntityFireball fireball = new EntityFireball(this, 
		//		300, 800,
		//		Direction.DOWN, 3, 0);
		//fireball.setDirection(new Vector2d(.5, .5));
		Clone clone1 = new Clone(this, 800, 1020, 10, 10, 8, 5);
		Clone clone2 = new Clone(this, 800, 1020, 10, 10, 8, 5);
		FireTurret turret = new FireTurret(this, 300, 800, 10, 1, 1, 1);
		
		Spider[] arrayOfSpider= new Spider[360];
		for(int i = 0; i<arrayOfSpider.length; i++){
			arrayOfSpider[i]= new Spider(this, 800, 1020, 10, 10, 8, 5);
			EC.register(arrayOfSpider[i]);
		}
		Hydra hydra1 = new Hydra(this, 100, 100, 10, 1, 1, 1);
		
		Hydra hydra2 = new Hydra(this, 700, 300, 10, 1, 1, 1);
		
		Hydra hydra3 = new Hydra(this, 200, 600, 10, 1, 1, 1);
		
		Item itemLeaf = new Item("Leaf", "It's a leaf.", "resources/leaf.png", 0, false, false);
		EntityItem entityLeaf = new EntityItem(this, 1000, 1020, itemLeaf);
		
		EC.register(player);
		//EC.register(fireball);
		EC.register(clone1);
		EC.register(clone2);

		EC.register(turret);
		EC.register(hydra1);
		EC.register(hydra2);
		EC.register(hydra3);
		EC.register(entityLeaf);
		
		playersPerspective=new Camera(this, 0,0);
		
		//Test this 
		//EntityHazard hazard = new EntityHazard(this, 100, 100, Direction.DOWN, 1);
		//hazard.setImage("someImage");
		//EC.register(hazard);
	}

	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		//Draw objects on screen
		map.render(0 - (int)playersPerspective.getxOffset(), 
				0- (int)playersPerspective.getyOffset());
		EC.render();
		g.drawImage(HUD,0,0);
	}

	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		EC.update(gc);
	}

	public int getID() {	//returns ID for SetupClass
		return SetupClass.gameState;
	}
	

	public int getGameWidth() {
		return gameWidth;
	}

	public int getGameHeight() {
		return gameHeight;
	}
	
	public Camera getCamera(){
		return playersPerspective;
	}

	public TiledMap getMap() {
		return map;
	}

	public void setMap(TiledMap map) {
		this.map = map;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}
	
	public EntityController getEC() {
		return EC;
	}

}