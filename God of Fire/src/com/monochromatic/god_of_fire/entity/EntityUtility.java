package com.monochromatic.god_of_fire.entity;

import java.util.ArrayList;

import com.monochromatic.god_of_fire.entity.living.monster.Monster;

public class EntityUtility {
	
	/**
	 * Returns a list of entities located within a rectangle described by two
	 * diagonal corners.
	 */
	public static ArrayList<Entity> intersectsEntities(ArrayList<Entity> entities, double[] rect) {
		ArrayList<Entity> contains = new ArrayList<Entity>();
		for (Entity e : entities) {
			double x = e.location().getX();
			double y = e.location().getY(); 
			if (isBetween(rect[0], rect[2], x) && isBetween(rect[1], rect[3], y))
				contains.add(e);
		}
		return contains;
	}
	
	/**
	 * Returns a list of monsters located within a rectangle described by two
	 * diagonal corners.
	 */
	public static ArrayList<Monster> intersectsMonsters(ArrayList<Entity> entities, double[] rect) {
		ArrayList<Monster> contains = new ArrayList<Monster>();
		for (Entity e : entities) {
			if (!(e instanceof Monster))
				continue;
			double x = e.location().getX();
			double y = e.location().getY(); 
			if (isBetween(rect[0], rect[2], x) && isBetween(rect[1], rect[3], y))
				contains.add((Monster) e);
		}
		return contains;
	}
	
	/**
	 * Determines whether a value is located between two others.
	 */
	public static boolean isBetween(double a, double b, double c) {
	    return b > a ? c > a && c < b : c > b && c < a;
	}
	
}