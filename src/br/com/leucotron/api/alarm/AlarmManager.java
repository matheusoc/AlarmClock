package br.com.leucotron.api.alarm;

import java.util.ArrayList;

public class AlarmManager {
	
	public static AlarmManager instance;
	
	private ArrayList<AlarmThread> mThreads;
	
	public static AlarmManager getInstance () {
		if (instance == null) {
			instance = new AlarmManager();
		}
		
		return instance;
	}
	
	private AlarmManager () {
		mThreads = new ArrayList<>();
	}
	
	public synchronized void addAlarm (String threadName, AlarmDate date, AlarmListener 
			listener, int priority) throws PastDateException {
		
		if (date.getDateInMillis() < System.currentTimeMillis()) {
			throw new PastDateException();
		}
		
		AlarmThread thread = new AlarmThread(threadName, date, listener, priority);
		mThreads.add(thread);
	}
	
	public void cancelAllAlarm () {
		
		if (mThreads.size() > 0) {
			
			for (AlarmThread thread : mThreads) {
				
				thread.stop();
				
			}
			
		}
		
	}
	
	public Long getAlarmTime(String threadName) {
		
		Long response = null;
		
		for (AlarmThread thread : mThreads) {
			
			if (thread.getmThreadName().equals(threadName)) {
				response = thread.getTimeInMillis();
			}
			
		}
		
		return response;
	}
	

}
