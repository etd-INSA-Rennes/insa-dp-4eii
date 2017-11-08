package q4.strategy;

import java.util.Objects;

import javax.swing.JTextField;

import q4.view.Zone;

/**
 * Manages the strategies.
 * @author ablouin
 */
public class StrategyManager implements Runnable {
	
	/** The zone where the bad evolves. */
	protected Zone zone;
	
	/** The current running strategy. */
	private StrategyMechant currentStrat;
	
	/** The text field showing messages from the strategies. */
	private JTextField messageField;
	
	
	public StrategyManager(final Zone zone, final JTextField messageField) {
		super();
		currentStrat = null;
		this.zone = Objects.requireNonNull(zone);
		this.messageField = Objects.requireNonNull(messageField);
	}
	
	@Override
	public void run() {
		// setting the first strategy.
		
		while (!zone.isGameOver()) {
			currentStrat = new RandomStrategy(zone, messageField);
			currentStrat.start();
			try {
				Thread.sleep(10000);
			}
			catch (final InterruptedException e) {
				e.printStackTrace();
			}
			currentStrat.stop();
			
			// setting the second strategy.
			
			currentStrat = new StickStrategy(zone, messageField);
			currentStrat.start();
			try {
				Thread.sleep(10000);
			}
			catch (final InterruptedException e) {
				e.printStackTrace();
			}
			currentStrat.stop();
			
			// setting the third strategy.
			
			currentStrat = new StickDiagStrategy(zone, messageField);
			currentStrat.start();
			try {
				Thread.sleep(10000);
			}
			catch (final InterruptedException e) {
				e.printStackTrace();
			}
			currentStrat.stop();
		}
	}
}
