package com.monochromatic.god_of_fire.utility.files;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Files {
	/**
	 * Saves a String array into a file
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
		try {
			System.out.println("Attempting to create file at " + location
					+ File.separator + name + ".txt");
			File file = new File(location + File.separator + name + "."
					+ extension);
			file.getParentFile().mkdirs();
			PrintWriter out = new PrintWriter(file);
			for (int i = 0; i < s.length; i++) {
				out.println(s[i]);
			}
			out.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Reads a text file into a string array
	 * 
	 * @param filePath
	 *            -The filepath to the file to be read, including the extension
	 * @return A String array where each String is a line in the file
	 * @throws FileNotFoundException
	 *             If there is no file to be found at that location
	 */
	public String[] readFile(String filePath) throws FileNotFoundException {
		ArrayList<String> s = new ArrayList<String>();
		Scanner in = new Scanner(new FileReader(new File(filePath)));
		while (in.hasNext()) {
			s.add(in.next());
		}
		in.close();
		String[] temp = new String[s.size()];
		for (int i = 0; i < s.size(); i++) {
			temp[i] = s.get(i);
		}
		return temp;
	}

	/**
	 * Gets the root directory inside of the User's folder
	 * 
	 * @return The user's home directory
	 */
	public String getDir() {
		return System.getProperty("user.home");
	}
}
