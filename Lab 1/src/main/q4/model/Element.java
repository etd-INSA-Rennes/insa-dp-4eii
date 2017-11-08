package q4.model;

import java.awt.Point;
import java.util.Objects;

import q4.view.Zone;

/**
 * An element of the game.
 * @author ablouin
 */
public class Element {
	/** The position of the element on the zone. */
	protected Point position;
	
	/** The zone where the Element evolves. */
	protected Zone zone;
	
	/**
	 * Creates an Element.
	 * @param x Its x-position. Must be in the zone.
	 * @param y Its y-position. Must be in the zone.
	 * @param zone The zone where the Element evolves.
	 * @throws NullPointerException If zone is null.
	 * @throws IllegalArgumentException If the given position does not match the size of the zone.
	 */
	public Element(final int x, final int y, final Zone zone) {
		super();
		if(x<0 || x>=zone.getNbSquaresX() || y<0 || y>zone.getNbSquaresY())
			throw new IllegalArgumentException();
		
		this.zone = Objects.requireNonNull(zone);
		position = new Point(x, y);
	}
	

	/**
	 * Moves the element (1 move).
	 * @param dir The direction to follow.
	 * @return True: the move has been successfully executed. False otherwise.
	 */
	public boolean move(final Direction dir) {
		boolean moved = false;
		// Locking the position to avoid concurrency issues.
		synchronized(position) {
			switch(dir) {
				case EAST:
					if(position.getX()<(zone.getNbSquaresX()-1)) {
						position.x++;
						moved = true;
					}
					return moved;
				case NE:
					if(position.getX()<(zone.getNbSquaresX()-1) && position.getY()>0) {
						position.x++;
						position.y--;
						moved = true;
					}
					return moved;	
				case NORTH:
					if(position.getY()>0) {
						position.y--;
						moved = true;
					}
					return moved;
				case NW:
					if(position.getX()>0 && position.getY()>0) {
						position.x--;
						position.y--;
						moved = true;
					}
					return moved;
				case SE:
					if(position.getX()<(zone.getNbSquaresX()-1) && position.getY()<(zone.getNbSquaresY()-1)) {
						position.x++;
						position.y++;
						moved = true;
					}
					return moved;
				case SOUTH:
					if(position.getY()<(zone.getNbSquaresY()-1)) {
						position.y++;
						moved = true;
					}
					return moved;
				case SW:
					if(position.getX()>0 && position.getY()<(zone.getNbSquaresY()-1)) {
						position.x--;
						position.y++;
						moved = true;
					}
					return moved;
				case WEST:
					if (position.getX() > 0) {
						position.x--;
						moved = true;
					}
					return moved;
			}
		}
		return moved;
	}
	

	/**
	 * @return The current position of the Element.
	 */
	public Point getPosition() {
		return position;
	}
}
