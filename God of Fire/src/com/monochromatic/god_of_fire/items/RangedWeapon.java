package com.monochromatic.god_of_fire.items;

public class RangedWeapon extends Weapon{
	
	private Arrows[] quiver;
	
	public RangedWeapon(){}
	
	public RangedWeapon(String name, String description, String filePath,
			int value, boolean isEquippable, boolean isSellable, int range,
			int speed, int damage){
		
		super(name, description, filePath, value, true, isSellable, 500, speed, damage);
		
		quiver= new Arrows[5];
		init();
	}
	
	public void init(){
		for(int i=0; i<quiver.length; i++){
			//quiver[i]=new Arrows(damage, range);
		}
	}
	

}
