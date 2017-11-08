package q2;

public enum CouleurCarte {
	PIQUE, TREFLE, COEUR, CARREAU;

	// Ajouter ici une opération permettant d'obtenir la couleur correspondant 
	// à la chaîne de caractères donnée en paramètre

	public static final CouleurCarte getCouleurCarte(String couleur) {
		for (CouleurCarte c : CouleurCarte.values()) {
			if (c.name().equalsIgnoreCase(couleur)) {
				return c;
			}
		}
		
		return null;
	}
}