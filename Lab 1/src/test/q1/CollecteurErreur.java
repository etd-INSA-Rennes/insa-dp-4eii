package q1;

import java.util.ArrayList;

public final class CollecteurErreur extends ArrayList<Exception> {

	private static final long serialVersionUID = 1L;
	public static final CollecteurErreur INSTANCE = new CollecteurErreur();
	
	private CollecteurErreur() {
		super();
	}
}
