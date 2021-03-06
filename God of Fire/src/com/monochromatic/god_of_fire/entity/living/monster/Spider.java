	package com.monochromatic.god_of_fire.entity.living.monster;

	import javax.vecmath.Vector2d;

	import org.newdawn.slick.GameContainer;
	import org.newdawn.slick.SlickException;

	import com.monochromatic.god_of_fire.entity.Entity;
	import com.monochromatic.god_of_fire.entity.ai.ACTION_ShootPlayer;
	import com.monochromatic.god_of_fire.entity.ai.AI;
	import com.monochromatic.god_of_fire.entity.ai.PATH_Chase;
	import com.monochromatic.god_of_fire.entity.ai.PATH_Random;
	import com.monochromatic.god_of_fire.entity.ai.Sniper;
	import com.monochromatic.god_of_fire.entity.nonliving.EntityFireball;
	import com.monochromatic.god_of_fire.entity.nonliving.EntityMagicBall;
	import com.monochromatic.god_of_fire.enums.Direction;
	import com.monochromatic.god_of_fire.enums.ElementalType;
	import com.monochromatic.god_of_fire.state.GameState;
	
public class Spider extends Monster{





		public Spider(GameState g, int x, int y, int h, int a, int d, int c){
			super(g, x, y, h, a, d, c);
			movementSpeed=2;
			setHeight(1);
			setImage("resources/spiderSpriteSheet.png");
			try {
				init(32, 32, 4, 4);
			} catch (SlickException e) {
				e.printStackTrace();
			}

			this.attachAI(new PATH_Random());
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

		@Override
		public void render() {
			currentAnimation.draw((int)(location().getX()-gameState.getCamera().getxOffset()),
					(int)(location().getY()-gameState.getCamera().getyOffset()));
			
		}

		@Override
		public void collide(Entity e) {
			// TODO Auto-generated method stub
			
		}
		



}
