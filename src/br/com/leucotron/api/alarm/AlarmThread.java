package br.com.leucotron.api.alarm;

public class AlarmThread implements Runnable {
	
	private String mThreadName; 
	private AlarmDate mAlarm;
	private AlarmListener mListener;
	private boolean shutdown = false;
	
	public AlarmThread(String threadName, AlarmDate alarm, 
			AlarmListener listener, int priority) {
		
		this.mThreadName = threadName;
		this.mAlarm = alarm;
		this.mListener = listener;
		
		Thread thread = new Thread(this);
		thread.setName(threadName);
		thread.setPriority(priority);
		thread.start();
		
	}
	
	public synchronized void run() {

		while (!shutdown) {
			
			long currentTime = System.currentTimeMillis();
			
			if (mAlarm.getDateInMillis() - currentTime < 0) {
				mListener.handleAlarm();
				this.stop();
			}
		}

	}

	public synchronized String getmThreadName() {
		return mThreadName;
	}
	
	public synchronized void stop () {
		shutdown = true;
	}
	
	

}
