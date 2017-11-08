package q1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.net.URL;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestQ1 {
	
	// Attribute qui sera utilisé à chaque test.
	private Q1 q1;
	
	@Before
	public void setUp() {
		// Initialisation de chaque test
		q1 = new Q1();
	}
	
	@After
	public void tearDown() {
		// action à faire à la fin de chaque test:
		// suppression des exceptions collectées pour éviter des interférences
		// entre les tests, genre:
		CollecteurErreur.INSTANCE.clear();
	}

	@Test
	public void testCollecteMauvaiseURL() {
		URL url = q1.toURL(null);
		assertNull("Aucune URL ne devrait avoir été créee.", url);
		assertEquals("Le collecteur d'exception ne devrait contenir qu'une seule erreur.", 1, CollecteurErreur.INSTANCE.size());
	}

	@Test
	public void testCollecteBonneURL() {
		URL url = q1.toURL(new File(System.getProperty("user.home")).toURI().toString());
		assertNotNull("Une URL devrait avoir été créee.", url);
		assertTrue("Le collecteur d'exception devrait être vide.", CollecteurErreur.INSTANCE.isEmpty());
	}
	
	@Test
	public void testSingletonEstClasseFinale() {
		assertEquals("CollecteurErreur doit être une classe public final pour ne pas l'instancier plusieurs fois.", 
				Modifier.PUBLIC+Modifier.FINAL, CollecteurErreur.class.getModifiers());
	}
	
	@Test
	public void testConstructeurSingletonPrivate() {
		assertEquals("Un singleton ne doit pas avoir de constructeur visible pour ne pas l'instancier plusieurs fois.", 
				0, CollecteurErreur.class.getConstructors().length);
	}
	
	
	@Test
	public void testAttributINSTANCEExiste() throws NoSuchFieldException, SecurityException {
		assertNotNull("Mais où est l'attribut INSTANCE correspondant à l'unique instance possible de la classe ?", 
				CollecteurErreur.class.getField("INSTANCE"));
	}
	
	
	@Test
	public void testAttributINSTANCEBonType() throws NoSuchFieldException, SecurityException {
		final Field field = CollecteurErreur.class.getField("INSTANCE");
		assertEquals("INSTANCE devrait être public static final car c'est une constante accessible partout.", 
				Modifier.PUBLIC+Modifier.STATIC+Modifier.FINAL, field.getModifiers());
		assertEquals("Le type de l'attribut INSTANCE devrait être la classe CollecteurErreur.", 
				CollecteurErreur.class, field.getType());
	}
}
