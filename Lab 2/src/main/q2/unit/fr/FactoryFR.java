package q2.unit.fr;

import q2.unit.ArmoredVehicule;
import q2.unit.Infantery;
import q2.unit.UnitFactory;

public class FactoryFR implements UnitFactory {

	@Override
	public Infantery createInfantery() {
		return new BeretVert();
	}

	@Override
	public ArmoredVehicule createArmoredVehicule() {
		return new Char();
	}
}
