package q4.view;

import java.awt.Color;
import java.awt.Graphics;

import q4.model.Element;

/**
 * The Bad guy of the game that wants to catch the Good one. 
 * @author ablouin
 */
public class Mechant extends AbsViewElement {
	/**
	 * Creates a Bad.
	 * @param model The model that the view will represent.
	 * @throws NullPointerException If the given model is null.
	 */
	public Mechant(final Element model) {
		super(model);
	}

	@Override
	public void paint(final Graphics g) {
		// Painting the representation of the model using a red ellipse.
		g.setColor(Color.RED);
		g.fillOval((int)model.getPosition().getX()*SIZE, (int)model.getPosition().getY()*SIZE, SIZE, SIZE);
	}
}
