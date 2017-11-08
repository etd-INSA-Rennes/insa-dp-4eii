package q4.view;

import java.awt.Color;
import java.awt.Graphics;

import q4.model.Element;

/**
 * The Good guy of the game that wants to flee the Bad one. 
 * @author ablouin
 */
public class Bon extends AbsViewElement {
	/**
	 * Creates a Good.
	 * @param model The model that the view will represent.
	 * @throws NullPointerException If the given model is null.
	 */
	public Bon(final Element model) {
		super(model);
	}

	@Override
	public void paint(final Graphics g) {
		// Painting the representation of the model using a black rectangle.
		g.setColor(Color.LIGHT_GRAY);
		g.fillRect((int)model.getPosition().getX()*SIZE, (int)model.getPosition().getY()*SIZE, SIZE, SIZE);
	}
}
