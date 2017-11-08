package q4.strategy;

import javax.swing.JTextField;

import q4.model.Direction;
import q4.view.Mechant;
import q4.view.Zone;

public class RandomStrategy extends StrategyMechantAbs {

	public RandomStrategy(Zone zone, JTextField messageField) {
		super(zone, messageField);
	}

	@Override
	protected Void doInBackground() throws Exception {
		final Mechant bad = zone.getMechant();
		
		while (!stop && !zone.isGameOver()) {
			System.out.println("rand strategy");
			
			// moving the Bad randomly.
			bad.getModel().move(Direction.getRandomDirection());
			
			// repainting the zone.
			zone.update();
			
			// checking the end of the game.
			zone.checkGameOver();
			
			// sleeping for 1 second.
			try {
				Thread.sleep(1000);
			}
			catch (final InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		return null;
	}
}
