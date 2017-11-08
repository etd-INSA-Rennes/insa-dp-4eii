package q4.view;

import java.awt.Graphics;

import q4.model.Element;

/**
 * The interface grouping the services that can provide a ViewElement, ie a representation
 * of an element of the game.
 * @author ablouin
 */
public interface ViewElement {
	/** The size (both width and height) of the figure that represents the Element (in pixels). */
	static int SIZE = 40;
	
	/**
	 * @return The Element represented by the view.
	 */
	Element getModel();
	
	/**
	 * Paints the view.
	 * @param g The graphics used for painting.
	 */
	void paint(Graphics g);
}
