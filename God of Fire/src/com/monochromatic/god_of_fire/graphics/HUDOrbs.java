package com.monochromatic.god_of_fire.graphics;

import java.io.File;
import java.io.IOException;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.particles.ConfigurableEmitter;
import org.newdawn.slick.particles.ParticleIO;
import org.newdawn.slick.particles.ParticleSystem;

public class HUDOrbs {
	
	public ParticleSystem particleSystem;
	
	Image particleImage;
	
	Image image;
	
	private int xPosition, yPosition;
	
	public ConfigurableEmitter emitter;
	
	public HUDOrbs(String emitterFilePath, String imageFilePath, int xPosition,
			int yPosition){
		initParticles(emitterFilePath);
		this.xPosition=xPosition;
		this.yPosition=yPosition;
		
		try {
			image=new Image(imageFilePath);
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	
	protected void initParticles(String emitterFilePath){

		try {
			particleImage= new Image("resources/Particle.png");
		} catch (SlickException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		particleSystem= new ParticleSystem(particleImage, 1500);

		try {
			File xmlFile=new File(emitterFilePath);
			emitter = ParticleIO.loadEmitter(xmlFile);
			particleSystem.addEmitter(emitter);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void update(float i){
		particleSystem.update(100);
		setIntensity(i);
	}
	
	public void setIntensity(float i){
		emitter.startAlpha.setValue(i);;
	}
	
	
	public void render(){
		particleSystem.render(xPosition+image.getWidth()/2, 
					yPosition+image.getHeight()/2);
		image.draw(xPosition, yPosition);
	}

}
