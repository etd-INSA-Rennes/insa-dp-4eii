package q4.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;

import javax.swing.JPanel;

import q4.model.Element;

/**
 * The zone where the game runs.
 * @author ablouin
 */
public class GameZone extends JPanel implements Zone {
	private static final long serialVersionUID = 1L;

	/** The width of the squared-zone (in squares). */ 
	public static final int SIZE = 20;
	
	/** The Good of the game */
	protected Bon good;
	
	/** The Bad of the game. */
	protected Mechant bad;
	
	/** States whether the game is over. */
	protected boolean gameOver;
	
	/** A lock for gameEnded. */
	private final Object LOCK_GAME_OVER;
	
	/**
	 * Creates the zone.
	 */
	public GameZone() {
		super();
		gameOver = false;
		good = new Bon(new Element(0, 0, this));
		bad = new Mechant(new Element(SIZE-1, SIZE-1, this));
		LOCK_GAME_OVER = new Object();
		setPreferredSize(new Dimension(SIZE * ViewElement.SIZE, SIZE * ViewElement.SIZE));
	}
	
	@Override
	public void paint(final Graphics g) {
		// clearing the background of the zone.
		
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, getWidth(), getHeight());
		
		// painting the Good and the Bad.
		
		good.paint(g);
		bad.paint(g);
	}

	@Override
	public int getNbSquaresX() {
		return SIZE;
	}

	@Override
	public int getNbSquaresY() {
		return SIZE;
	}

	@Override
	public Bon getBon() {
		return good;
	}

	@Override
	public Mechant getMechant() {
		return bad;
	}

	@Override
	public void update() {
		repaint();
	}

	@Override
	public void checkGameOver() {
		final Point pHero = good.getModel().getPosition();
		final Point pBad = bad.getModel().getPosition();
		
		// To avoid concurrency issues, locking the position
		// of the Bad and the Good, and gameEnded.
		
		synchronized(pBad) {
			synchronized(pHero) {
				synchronized(LOCK_GAME_OVER) {
					if (pHero.equals(pBad))
						gameOver = true;
				}
			}
		}
	}


	@Override
	public boolean isGameOver() {
		synchronized(LOCK_GAME_OVER) {return gameOver;}
	}
}
