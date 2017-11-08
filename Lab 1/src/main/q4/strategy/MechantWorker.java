package q4.strategy;

import java.util.Objects;

import javax.swing.JTextField;
import javax.swing.SwingWorker;

import q4.model.Direction;
import q4.view.Mechant;
import q4.view.Zone;

/**
 * The thread that moves the Bad.
 * @author ablouin
 */
public class MechantWorker extends SwingWorker<Void, Object> {
	/** The zone where the bad evolves. */
	protected Zone zone;
	
	protected JTextField messageField;
	
	/**
	 * Creates the thread.
	 * @param zone The zone where the bad evolves.
	 * @throws NullPointerException If zone is null.
	 */
	public MechantWorker(final Zone zone, final JTextField messageField) {
		super();
		this.zone = Objects.requireNonNull(zone);
		this.messageField = Objects.requireNonNull(messageField);
	}
	
	@Override
	protected Void doInBackground() throws Exception {
		messageField.setText("Mechant bouge");
		final Mechant bad = zone.getMechant();
		boolean ok = true;
		
		// While there is no problem and the game still runs.
		while(ok && !zone.isGameOver()) {
			// Moving the Bad randomly.
			bad.getModel().move(Direction.getRandomDirection());
			// Repainting the zone.
			zone.update();
			// Checking the end of the game.
			zone.checkGameOver();
			
			// Sleeping for 1 second.
			try {
				Thread.sleep(1000);
			}
			catch(final InterruptedException e) {
				e.printStackTrace();
				ok = false;
			}
		}
		messageField.setText("Mechant ne bouge plus");
		return null;
	}
}
