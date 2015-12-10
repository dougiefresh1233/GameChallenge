package com.monochromatic.god_of_fire.utility;
import java.io.FileNotFoundException;

import com.monochromatic.god_of_fire.utility.encryption.Encryption;

public class EncryptedFiles {
	Files f = new Files();
	Encryption e = new Encryption();

	/**
	 * Saves a String array into an encrypted file
	 * 
	 * @param s
	 *            -A String array with each String as a line to be written
	 * @param location
	 *            -The filepath to the file to be written
	 * @param name
	 *            -The name of the file, without the extension
	 * @param extension
	 *            -The extension that the written file will use
	 * @return Writes a text file to the location
	 *         <code>[location]/[name].[extension]</code>
	 */
	public void saveFile(String[] s, String location, String name,
			String extension) {
		for (int i = 0; i < s.length; i++) {
			s[i] = e.encode(s[i]);
		}
		int i = 0;
		String temp;
		// swap lines
		while (s.length > i + 1) {
			temp = s[i];
			s[i] = s[i + 1];
			s[i + 1] = temp;
			i += 2;
		}
		// increment or decrement alternatively
		i = 0;
		while (s.length > i + 1) {
			s[i] = e.incrementNums(s[i]);
			s[i + 1] = e.decrementNums(s[i + 1]);
			i += 2;
		}
		// shift every other column of chars
		s = shiftDown(s);
		f.saveFile(s, location, name, extension);
	}

	/**
	 * Reads an encrypted text file into a String array
	 * 
	 * @param filePath
	 *            -The filepath to the file to be read, including the extension
	 * @return A String array where each String is a line in the file
	 * @throws FileNotFoundException
	 *             If there is no file to be found at that location
	 */
	public String[] readFile(String filePath) throws FileNotFoundException {
		String[] s = f.readFile(filePath);
		int i = 0;
		String temp;
		// shift every other column of chars
		s = shiftUp(s);
		// swap lines
		while (s.length > i + 1) {
			temp = s[i];
			s[i] = s[i + 1];
			s[i + 1] = temp;
			i += 2;
		}
		i = 0;
		// increment or decrement alternatively
		while (s.length > i + 1) {
			s[i] = e.incrementNums(s[i]);
			s[i + 1] = e.decrementNums(s[i + 1]);
			i += 2;
		}
		for (int j = 0; j < s.length; j++) {
			s[j] = e.decode(s[j]);
		}
		return s;
	}

	/**
	 * Used to find path to the user's home directory
	 * 
	 * @return The path to the user's home directory
	 */
	public String getDir() {
		return f.getDir();
	}

	/**
	 * 
	 * @param s
	 *            The String array to be modified
	 * @return A modified String array where every other column of characters is
	 *         shifted one index upward.
	 */
	private String[] shiftUp(String[] s) {
		if (s.length != 0) {
			int k = s[0].length();
			for (int j = 0; j < s.length; j++) {
				if (k > s[j].length()) {
					k = s[j].length();
				}
			}
			String t;
			for (int i = 0; i < k; i++) {
				if (i % 2 == 1) {
					t = s[0].substring(i, i + 1);
					for (int j = 0; j < s.length - 1; j++) {
						s[j] = s[j].substring(0, i)
								+ s[j + 1].substring(i, i + 1)
								+ s[j].substring(i + 1);
					}
					s[s.length - 1] = s[s.length - 1].substring(0, i) + t
							+ s[s.length - 1].substring(i + 1);
				}
			}
		}
		return s;
	}

	/**
	 * 
	 * @param s
	 *            The String array to be modified
	 * @return A modified String array where every other column of characters is
	 *         shifted one index downward.
	 */
	private String[] shiftDown(String[] s) {
		String[] temp = s;
		if (temp.length != 0) {
			int k = s[0].length();
			for (int j = 0; j < s.length; j++) {
				if (k > s[j].length()) {
					k = s[j].length();
				}
			}
			String t;
			for (int i = 0; i < k; i++) {
				if (i % 2 == 1) {
					t = s[s.length - 1].substring(i, i + 1);
					for (int j = s.length - 1; j > 0; j--) {
						temp[j] = temp[j].substring(0, i)
								+ s[j - 1].substring(i, i + 1)
								+ temp[j].substring(i + 1);
					}
					temp[0] = temp[0].substring(0, i) + t
							+ temp[0].substring(i + 1);
				}
			}
		}
		return temp;
	}
}
