package q4.view;

/**
 * The zone where the game will be painted. 
 * @author ablouin
 */
public interface Zone {
	/**
	 * @return The width of the zone (the number of squares).
	 */
	int getNbSquaresX();
	
	/**
	 * @return The height of the zone (the number of squares).
	 */
	int getNbSquaresY();
	
	/**
	 * @return The Good of the zone.
	 */
	Bon getBon();
	
	/**
	 * @return The Bad of the zone.
	 */
	Mechant getMechant();
	
	/**
	 * Updates the zone.
	 */
	void update();
	
	/**
	 * Checks that the game is not over.
	 */
	void checkGameOver();
	
	/**
	 * @return True when the game is over. False otherwise.
	 */
	boolean isGameOver();
}
