package com.monochromatic.god_of_fire.graphics;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class LoadingScreen {
	JFrame loadingscreen; 
	JLabel loading;
	public boolean isLoaded = false;

	public LoadingScreen() {
	}

	public void startLoadingScreen() {
		ImageIcon pie = getImg("Logo", File.separator + "resources", "png");
		loadingscreen = new JFrame();
		loadingscreen.setAlwaysOnTop(true);
		loadingscreen.setLayout(null);
		loadingscreen.setUndecorated(true);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		loadingscreen.getContentPane().setPreferredSize(
				new Dimension(pie.getIconWidth(), pie.getIconHeight()));
		loadingscreen.setResizable(false);
		loadingscreen.pack();
		loadingscreen.setLocation(
				(int) (dim.getWidth() - loadingscreen.getWidth()) / 2,
				(int) (dim.getHeight() - loadingscreen.getHeight()) / 2);
		loadingscreen = transparent(loadingscreen);
		loadingscreen.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		loading = new JLabel(pie);
		loading.setSize(new Dimension(pie.getIconWidth(), pie.getIconHeight()));
		loading.setLocation(0, 0);
		loadingscreen.add(loading);
		loadingscreen.setVisible(true);
		isLoaded = true;
	}

	public void closeLoadingScreen() {
		if (isLoaded) {
			if (loading != null) {
				loading.setVisible(false);
			}
			if (loadingscreen != null) {
				loadingscreen.setVisible(false);
				loadingscreen.dispose();
			}
			isLoaded = false;
		}
	}

	private ImageIcon getImg(String filename, String pathname, String filetype) {
		ImageIcon ic = new ImageIcon(getClass().getResource(
				pathname + File.separator + filename + "." + filetype));
		return ic;
	}

	private JFrame transparent(JFrame frame) {
		frame.setBackground(new Color(0, 255, 0, 0));
		frame.setContentPane(new ContentPane());
		frame.getContentPane().setBackground(Color.BLACK);
		frame.setLayout(new BorderLayout());
		return frame;
	}
}
