package com.monochromatic.god_of_fire;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.SlickException;

import com.monochromatic.god_of_fire.graphics.LoadingScreen;
import com.monochromatic.god_of_fire.gui.GUI;
import com.monochromatic.god_of_fire.utility.Logger;

public class Main {

	static LoadingScreen lsc;

	public static void main(String[] args) throws SlickException {
		AppGameContainer app = new AppGameContainer(new SetupClass());
		app.setDisplayMode(640, 480, false);
		app.setAlwaysRender(true);
		app.setShowFPS(true);	//TODO change to false
		app.setVSync(true);
		app.setTargetFrameRate(60);
		app.start();
		
		/*lsc = new LoadingScreen();
		lsc.startLoadingScreen();
		LoadGame();
		lsc.closeLoadingScreen();
		QuitGame();
		//TODO Remove this ^*/
	}

	public static void LoadGame() {
		try {
			Logger.createLog();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println("Testing logging...");
		try {
			Logger.logWithoutSyso();
			System.out.println("Success!");
			System.out.println();
		} catch (IOException e) {
			System.out.println("Logging failed, please check the error log below.");
			Logger.disable();
			e.printStackTrace();
		}
		outputSystemInfo();
		Logger.log("##Start Log##");
		Logger.log("Initializing game...");
		GUI.startMenu();
	}

	public static void QuitGame() {
		lsc.closeLoadingScreen();
		System.exit(0);
	}

	public static void outputSystemInfo() {
		Logger.log();
		Logger.log(System.getProperty("os.name") + " "
				+ System.getProperty("os.arch") + " "
				+ System.getProperty("os.version"));
		Logger.log("Java Version " + System.getProperty("java.version"));
		Logger.log("Distributed by "
				+ System.getProperty("java.vendor"));
		Logger.log();
		Logger.log();
	}
}
