package br.com.leucotron.api.alarm;


public class AlarmManager {
	
	public synchronized void addAlarm (String threadName, AlarmDate date, AlarmListener 
			listener, int priority) throws PastDateException {
		
		if (date.getDateInMillis() < System.currentTimeMillis()) {
			throw new PastDateException();
		}
		
		new AlarmThread(threadName, date, listener, priority);
	}

}
