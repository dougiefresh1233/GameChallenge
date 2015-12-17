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
	// TODO create paths for music
	private static org.newdawn.slick.Music currentSong;

	/**
	 * Begins playing a new a new song
	 * 
	 * @param songID
	 *            The id number of the song
	 * @param loop
	 *            Whether or not the song should loop when played
	 */
	public static void playMusic(int songID, boolean loop) {
		position = 0;
		try {
			currentSong = new org.newdawn.slick.Music(getFilePath(songID));
		} catch (SlickException e) {
			e.printStackTrace();
		}
		if (loop) {
			currentSong.loop();
		} else {
			currentSong.play();
		}
		currentSong.setVolume(volume);
	}

	/**
	 * Pauses the currently playing song
	 */
	public void pauseMusic() {
		position = currentSong.getPosition();
		currentSong.pause();
	}

	/**
	 * Resumes a currently paused song
	 */
	public void resumeMusic() {
		currentSong.resume();
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
	/**
	 * Causes the currently selected song to loop after it finishes
	 */
	public void loopSong(){
		position=currentSong.getPosition();
		currentSong.loop();
		currentSong.setVolume(volume);
		currentSong.setPosition(position);
	}

	private static String getFilePath(int songID) {

		String temp = "resources" + File.separator + "music" + File.separator + paths[songID];
		System.out.println(temp.toString());
		return temp;
	}
}
