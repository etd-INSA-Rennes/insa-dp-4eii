package q1;

import java.net.MalformedURLException;
import java.net.URL;


public class Q1 {
	public URL toURL(final String path) {
		URL url;
		try { url = new URL(path); }
		catch(MalformedURLException e) {
			url = null;
			CollecteurErreur.INSTANCE.add(e);
		}
		return url;
	}
}
