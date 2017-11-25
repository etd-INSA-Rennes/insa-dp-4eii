package q2.unit.us;

import q2.unit.Infantery;
import q2.unit.Unit;

public class Marine implements Unit, Infantery {

	@Override
	public boolean canHide() {
		return true;
	}

	@Override
	public int getAttaque() {
		return 1;
	}

	@Override
	public int getVie() {
		return 5;
	}
}
