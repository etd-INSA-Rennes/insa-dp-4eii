package q4.strategy;

import javax.swing.JTextField;

import q4.model.Direction;
import q4.view.Bon;
import q4.view.Mechant;
import q4.view.Zone;

public class StickStrategy extends StrategyMechantAbs {

	public StickStrategy(Zone zone, JTextField messageField) {
		super(zone, messageField);
	}

	@Override
	protected Void doInBackground() throws Exception {
		final Mechant bad = zone.getMechant();
		final Bon bon = zone.getBon();
		
		while (!stop && !zone.isGameOver()) {
			System.out.println("stick strategy");
			
			final int xDiff = bad.getModel().getPosition().x - bon.getModel().getPosition().x;
			final int yDiff = bad.getModel().getPosition().y - bon.getModel().getPosition().y;
			
			final boolean shouldMoveOnX = Math.max(Math.abs(xDiff), Math.abs(yDiff)) == Math.abs(xDiff);
			if (shouldMoveOnX) {
				if (xDiff < 0) {
					bad.getModel().move(Direction.EAST);
				}
				else {
					bad.getModel().move(Direction.WEST);
				}
			}
			else {
				if (yDiff < 0) {
					bad.getModel().move(Direction.SOUTH);
				}
				else {
					bad.getModel().move(Direction.NORTH);
				}
			}
			
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
