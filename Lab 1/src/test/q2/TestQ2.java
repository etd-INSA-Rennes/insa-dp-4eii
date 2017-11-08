package q2;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestQ2 {

	@Test
	public void testgetCouleurCarteNullParam() {
		assertNull("La valeur 'null' devrait être retournée lorsque la chaîne de charactère"
				+ "passée en paramètre est 'null'.", CouleurCarte.getCouleurCarte(null));
	}
	
	@Test
	public void testgetCouleurCartePasValide() {
		assertNull("La valeur 'null' devrait être retournée lorsque la chaîne de charactère"
				+ "passée en paramètre n'est pas correcte.", CouleurCarte.getCouleurCarte(""));
	}
	
	@Test
	public void testgetCouleurCartePIQUE() {
		assertEquals("La valeur PIQUE est attendue", CouleurCarte.PIQUE, CouleurCarte.getCouleurCarte("PIQUE"));
	}
	
	@Test
	public void testgetCouleurCarteTREFLE() {
		assertEquals("La valeur TREFLE est attendue", CouleurCarte.TREFLE, CouleurCarte.getCouleurCarte("TREFLE"));
	}
	
	@Test
	public void testgetCouleurCarteCOEUR() {
		assertEquals("La valeur COEUR est attendue", CouleurCarte.COEUR, CouleurCarte.getCouleurCarte("COEUR"));
	}
	
	@Test
	public void testgetCouleurCarteCARREAU() {
		assertEquals("La valeur CARREAU est attendue", CouleurCarte.CARREAU, CouleurCarte.getCouleurCarte("CARREAU"));
	}
}
