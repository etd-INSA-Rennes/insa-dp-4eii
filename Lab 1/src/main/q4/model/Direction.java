package q4.model;

import java.awt.event.KeyEvent;
import java.util.Random;

/**
 * Defines a direction used to move elements of the game. 
 * @author ablouin
 */
public enum Direction {
	NORTH, SOUTH, EAST, WEST, NE, NW, SE, SW;
	
	/**
	 * @return A random direction.
	 */
	public static Direction getRandomDirection() {
		switch(new Random().nextInt(7)) {
			case 0: return NW;
			case 1: return SW;
			case 2: return SOUTH;
			case 3: return SE;
			case 4: return WEST;
			case 5: return NORTH;
			case 6: return NE;
			default: return null;
		}
	}
	
	public static Direction getDirection(int keyCode) {
		switch (keyCode) {
		case KeyEvent.VK_UP:
			return NORTH;
			
		case KeyEvent.VK_DOWN:
			return SOUTH;
			
		case KeyEvent.VK_LEFT:
			return WEST;
			
		case KeyEvent.VK_RIGHT:
			return EAST;
		}
		
		return null;
	}
}
