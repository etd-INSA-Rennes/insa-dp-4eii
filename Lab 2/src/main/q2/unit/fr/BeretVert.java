package q2.unit.fr;

import q2.unit.Infantery;
import q2.unit.Unit;

public class BeretVert implements Unit, Infantery {

	@Override
	public boolean canHide() {
		return false;
	}

	@Override
	public int getAttaque() {
		return 2;
	}

	@Override
	public int getVie() {
		return 3;
	}
}
