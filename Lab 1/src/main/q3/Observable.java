package q3;

public interface Observable {
	/**
	 * Adds an observer.
	 * @param obs The observer to add.
	 */
	void addObservateur(final ClockObservater obs);
	
	/**
	 * Notify the observer that the observable object changed.
	 */
	void notifyObservateur();
}
