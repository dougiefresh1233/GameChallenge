package com.monochromatic.god_of_fire.items;

import java.awt.Point;



public class MeleeWeapon extends Weapon{
	
	Point playersLocation;
	
	

	public MeleeWeapon(String name, String description, String filePath,
			int value, boolean isEquippable, boolean isSellable, int range,
			int speed, int damage){
		super(name, description, filePath, value, isEquippable, isSellable, range,
				speed, damage);

		
	}

	public void equip(Point playersLocation){
		this.playersLocation=playersLocation;
	}
	
	public void attack(float startingAngle){
		itemImage.setRotation(startingAngle);
		itemImage.setCenterOfRotation(10, 35);
		
		for(int i=0; i<90; i++){
			itemImage.rotate(i);
			render();
		}
	}
	
	@Override
	public void render() {
		itemImage.draw((float)(playersLocation.getX()), 
				(float)playersLocation.getY()-25);
	}
	
	

}
