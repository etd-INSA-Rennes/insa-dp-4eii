package q2.unit.us;

import q2.unit.ArmoredVehicule;
import q2.unit.Infantery;
import q2.unit.UnitFactory;

public class FactoryUS implements UnitFactory {

	@Override
	public Infantery createInfantery() {
		return new Marine();
	}

	@Override
	public ArmoredVehicule createArmoredVehicule() {
		return new Tank();
	}
}
