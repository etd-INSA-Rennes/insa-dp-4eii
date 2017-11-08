package q4.controler;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Objects;

import q4.model.Direction;
import q4.view.Bon;
import q4.view.Zone;

/**
 * The controler that permits players to interact with the game using the keyboard.
 * @author ablouin
 */
public class MoveUnit implements KeyListener {
	
	/** The gaming zone. */
	protected Zone zone;
	
	/**
	 * Creates the controller.
	 * @param zone The gaming zone.
	 * @throws NullPointerException If zone is null.
	 */
	public MoveUnit(final Zone zone) {
		super();
		this.zone = Objects.requireNonNull(zone);
	}
	
	@Override
	public void keyPressed(final KeyEvent e) {
		// Cannot do anything when the game is over.
		if (zone.isGameOver()) return ;
		
		// Getting the direction from the key pressed.

		final Direction dir = Direction.getDirection(e.getKeyCode());
		final Bon good = zone.getBon();
		
		// Moving the Good, updating the view, and check the end of the game.
		if(dir != null) {
			good.getModel().move(dir);
			zone.update();
			zone.checkGameOver();
		}
	}
	
	@Override
	public void keyTyped(final KeyEvent e) {
		//
	}

	@Override
	public void keyReleased(final KeyEvent e) {
		//
	}
}
