package q2.unit.fr;

import q2.unit.ArmoredVehicule;
import q2.unit.Unit;

public class Char implements Unit, ArmoredVehicule {

	@Override
	public void pilonner(int x, int y) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getAttaque() {
		return 4;
	}

	@Override
	public int getVie() {
		return 10;
	}
}
