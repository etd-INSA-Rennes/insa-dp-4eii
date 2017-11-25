package q2;

import q2.unit.ArmoredVehicule;
import q2.unit.Infantery;
import q2.unit.fr.BeretVert;
import q2.unit.UnitFactory;
import q2.unit.fr.FactoryFR;

public class Main {
	public static void main(String[] args) {

		// Q.2c
		
//		ArmoredVehicule veh = new Char();
//		Infantery inf = new BeretVert();
		
		// pour changer de civilisation :
		
//		ArmoredVehicule veh = new Tank();
//		Infantery inf = new Marine();
		
		// Q.2f
		
		final UnitFactory factory = new FactoryFR();
		
		final Infantery inf = factory.createInfantery();
		final ArmoredVehicule veh = factory.createArmoredVehicule();

		((BeretVert) inf).getAttaque();
		veh.pilonner(0, 0);
	}
}
