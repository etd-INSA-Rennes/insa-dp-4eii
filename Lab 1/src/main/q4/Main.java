package q4;

import q4.view.UI;

public class Main {
	public static void main(final String[] args) {
		final UI ui = new UI();
		ui.setVisible(true);
		ui.getZone().requestFocusInWindow();
	}
}