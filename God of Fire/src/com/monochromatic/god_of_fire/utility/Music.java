/**
* @Author Diego Vera
* Dec 16, 2015 5:20:33 PM
*/

package com.monochromatic.god_of_fire.utility;

import java.io.File;
import java.net.URL;

import org.newdawn.slick.SlickException;

public final class Music {
	public static final int TEST = 0;
	public static final int TITLE = 1;
	public static final int MAIN = 2;
	public static final int INVENTORY = 3;
	public static final int MAP = 4;

	private static float volume = (float) .5;
	private static float position = 0;
	private static final String[] paths = { "test.ogg", "title", "main", "inv", "map" };
	//TODO create paths for music
	private static org.newdawn.slick.Music currentSong;

	public static void playMusic(int songID) {
		position = 0;
		try {
			currentSong = new org.newdawn.slick.Music(getFilePath(songID));
		} catch (SlickException e) {
			e.printStackTrace();
		}
		currentSong.loop();
		currentSong.setVolume(volume);
	}

	public void pauseMusic() {
		position=currentSong.getPosition();
		currentSong.pause();
	}

	/**
	 * Changes the volume of the music
	 * 
	 * @param volume
	 *            Minimum input is 0, Maximum is 1.
	 */
	public void setVolume(float volume) {
		this.volume = volume;
		currentSong.setVolume(this.volume);
	}

	private static String getFilePath(int songID) {

		String temp = "resources" + File.separator + "music" + File.separator + paths[songID];
		System.out.println(temp.toString());
		return temp;
	}
}
