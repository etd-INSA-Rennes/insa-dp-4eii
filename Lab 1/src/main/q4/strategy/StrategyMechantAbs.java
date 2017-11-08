package q4.strategy;

import java.util.Objects;

import javax.swing.JTextField;
import javax.swing.SwingWorker;

import q4.view.Zone;

abstract class StrategyMechantAbs extends SwingWorker<Void, Object> implements StrategyMechant {
	
	/** The zone where the bad evolves. */
	protected Zone zone;
	
	protected boolean stop;
	
	protected JTextField messageField;
	
	/**
	 * Creates the strategy.
	 * @param zone The zone where the bad evolves.
	 * @throws NullPointerException If zone is null.
	 */
	public StrategyMechantAbs(final Zone zone, final JTextField messageField) {
		super();
		this.zone = Objects.requireNonNull(zone);
		this.messageField = Objects.requireNonNull(messageField);
		stop = false;
	}

	@Override
	public void start() {
		execute();
		messageField.setText("Strategy " + getClass().getSimpleName() + " started.");
	}

	@Override
	public void stop() {
		stop = true;
		messageField.setText("Strategy " + getClass().getSimpleName() + " stopped.");
	}
}
