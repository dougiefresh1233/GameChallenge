package com.monochromatic.god_of_fire.enums;

import java.util.Random;

/**
 * Direction of objects in the game world.
 * 
 * @author calmattier
 * @author kaolinhart
 */
public enum Direction {
	UP, DOWN, LEFT, RIGHT;
	
	/**
	 * Return a random Direction.
	 */
	public static Direction random() {
        Random random = new Random();
        return values()[random.nextInt(values().length)];
    }
	
	/**
	 * Return a random Direction, excluding the provided direction.
	 */
	public static Direction change(Direction d) {
        Random random = new Random();
        Direction change = values()[random.nextInt(values().length)];
        if (change == d)
        	return change(d);
        return change;
    }
	
	/**
	 * Invert the direction.
	 */
	public static Direction invert(Direction d) {
		switch(d) {
			case UP: 	return DOWN;
			case DOWN: 	return UP;
			case LEFT: 	return RIGHT;
			default: 	return LEFT;
		}
	}
	
	/**
	 * Rotate the direction Clockwise.
	 */
	public static Direction rotateCW(Direction d) {
		switch(d) {
			case UP: 	return RIGHT;
			case RIGHT: return DOWN;
			case DOWN: 	return LEFT;
			default: 	return UP;
		}
	}
	
	/**
	 * Rotate the direction Counter Clockwise.
	 */
	public static Direction rotateCCW(Direction d) {
		switch(d) {
			case UP: 	return LEFT;
			case LEFT: 	return DOWN;
			case DOWN: 	return RIGHT;
			default: 	return UP;
		}
	}
	
};