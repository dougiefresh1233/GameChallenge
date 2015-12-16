package com.monochromatic.god_of_fire.entity.living;
import org.newdawn.slick.Input;

import java.awt.Point;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.vecmath.Vector2d;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.particles.ConfigurableEmitter;
import org.newdawn.slick.particles.ParticleIO;
import org.newdawn.slick.particles.ParticleSystem;

import com.monochromatic.god_of_fire.entity.Entity;
import com.monochromatic.god_of_fire.entity.EntityUtility;
import com.monochromatic.god_of_fire.entity.living.monster.Monster;
import com.monochromatic.god_of_fire.entity.nonliving.EntityFireball;
import com.monochromatic.god_of_fire.entity.nonliving.EntityMagic;
import com.monochromatic.god_of_fire.entity.nonliving.EntityMagicBall;
import com.monochromatic.god_of_fire.enums.DamageType;
import com.monochromatic.god_of_fire.enums.Direction;
import com.monochromatic.god_of_fire.enums.ElementalType;
import com.monochromatic.god_of_fire.state.GameState;
import com.monochromatic.god_of_fire.items.Inventory;
import com.monochromatic.god_of_fire.items.MeleeWeapon;

public class Player extends LivingEntity {
	/**
	 * Players inventory
	 */

	protected Inventory inventory;

	Point cameraOffsetPoint=new Point(0,0);


	ParticleSystem particleSystem;
	Image particleImage;
	ConfigurableEmitter emitter;


	MeleeWeapon equippedWeapon;

	private boolean superPower;

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
		else
			upwardsMovementAnimation.stop();

		if(userInput.isKeyDown(Input.KEY_S))
			move(Direction.DOWN);
		else
			downwardMovementAnimation.stop();

		if (userInput.isKeyDown(Input.KEY_A))
			move(Direction.LEFT);
		else
			leftMovementAnimation.stop();

		if (userInput.isKeyDown(Input.KEY_D))
			move(Direction.RIGHT);
		else
			rightMovementAnimation.stop();


	if (userInput.isKeyPressed(Input.KEY_DOWN)){
		EntityMagicBall waterMagicBall= new EntityMagicBall(gameState, 
				(int)(this.location().getX()),
				(int)(this.location().getY()),
				Direction.UP, 1, 1, 
				ElementalType.FLUMINIS);
		
		
		switch (orientation) {
		case UP: waterMagicBall.setDirection(new Vector2d(0, -10)); 
		break;
		case DOWN: waterMagicBall.setDirection(new Vector2d(0, 10));
		break;
		case LEFT: waterMagicBall.setDirection(new Vector2d(-10, 0));
		break;
		case RIGHT: waterMagicBall.setDirection(new Vector2d(10, 0));
		break;
		}
		
		this.getGameState().getEC().register(waterMagicBall);
	}
		

	if (userInput.isKeyPressed(Input.KEY_RIGHT)){
		EntityMagicBall plantMagicBall= new EntityMagicBall(gameState, 
				(int)(this.location().getX()),
				(int)(this.location().getY()),
				Direction.UP, 1, 1, 
				ElementalType.VIRENTIA);
		
		
		switch (orientation) {
		case UP: plantMagicBall.setDirection(new Vector2d(0, -10)); 
		break;
		case DOWN: plantMagicBall.setDirection(new Vector2d(0, 10));
		break;
		case LEFT: plantMagicBall.setDirection(new Vector2d(-10, 0));
		break;
		case RIGHT: plantMagicBall.setDirection(new Vector2d(10, 0));
		break;
		}
		
		this.getGameState().getEC().register(plantMagicBall);
	}

	if (userInput.isKeyPressed(Input.KEY_LEFT)){
		EntityMagicBall fireMagicBall= new EntityMagicBall(gameState, 
				(int)(this.location().getX()),
				(int)(this.location().getY()),
				Direction.UP, 1, 1, 
				ElementalType.IGNIS);
		
		
		switch (orientation) {
		case UP: fireMagicBall.setDirection(new Vector2d(0, -10)); 
		break;
		case DOWN: fireMagicBall.setDirection(new Vector2d(0, 10));
		break;
		case LEFT: fireMagicBall.setDirection(new Vector2d(-10, 0));
		break;
		case RIGHT: fireMagicBall.setDirection(new Vector2d(10, 0));
		break;
		}
		
		this.getGameState().getEC().register(fireMagicBall);
	}
	
		if(userInput.isKeyPressed(Input.KEY_UP)){
			switch (orientation) {
			case UP: equippedWeapon.attack(180, 1); 
			break;
			case DOWN: equippedWeapon.attack(180, -1);
			break;
			case LEFT: equippedWeapon.attack(270, -1);
			break;
			case RIGHT: equippedWeapon.attack(270, 1);
			break;
			}
			List<Monster> targets = EntityUtility.intersectsMonsters(getGameState().getEC().getEntities(), 
					calculateAttackArea(orientation));
			for (Monster m : targets)
				if(m.adjustHealth(calculateAttack()))
					m.kill();
		}
	}

	private double[] calculateAttackArea(Direction d) {
		double[] area = new double[4];
		switch (orientation) {
		case UP: 
			area[0] = location().getX() - 48;
			area[1] = location().getY() + 16;
			area[2] = location().getX() + 48;
			area[3] = location().getY() + 48;
			break;
		case DOWN: 
			area[0] = location().getX() - 48;
			area[1] = location().getY() - 48;
			area[2] = location().getX() + 48;
			area[3] = location().getY() - 16;
			break;
		case LEFT:
			area[0] = location().getX() - 48;
			area[1] = location().getY() - 48;
			area[2] = location().getX() - 16;
			area[3] = location().getY() + 48;
			break;
		default:
			area[0] = location().getX() + 16;
			area[1] = location().getY() - 48;
			area[2] = location().getX() + 48;
			area[3] = location().getY() + 48;
			break;
		}
		return area;
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