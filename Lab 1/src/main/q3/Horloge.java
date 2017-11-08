package q3;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.swing.SwingWorker;

public class Horloge extends SwingWorker<Void, Object> implements Observable {
	
	private String hour;
	private final Object LOCK_HOUR = new Object();
	
	private List<ClockObservater> observers;
	
	public Horloge() {
		super();
		
		hour = "";
		observers = new ArrayList<>();
	}
	
	@Override
	protected Void doInBackground() {
		boolean ok = true;
		String min;
		String sec;
		Calendar cal;

		while(ok) {
			cal = Calendar.getInstance();
			min = cal.get(Calendar.MINUTE)<10 ? "0"+String.valueOf(cal.get(Calendar.MINUTE)) : String.valueOf(cal.get(Calendar.MINUTE));
			sec = cal.get(Calendar.SECOND)<10 ? "0"+String.valueOf(cal.get(Calendar.SECOND)) : String.valueOf(cal.get(Calendar.SECOND));
			
			synchronized(LOCK_HOUR) {
				hour =  String.valueOf(cal.get(Calendar.HOUR_OF_DAY))+" : "+min+" : "+sec;
			}
			
			notifyObservateur();

			try {
				Thread.sleep(1000);
			}
			catch(final InterruptedException e) {
				e.printStackTrace();
				ok = false;
			}
		}
		
		return null;
	}

	@Override
	public void addObservateur(ClockObservater obs) {
		observers.add(obs);
	}

	@Override
	public void notifyObservateur() {
		for (ClockObservater observer : observers) {
			observer.update(hour);
		}
	}
}
