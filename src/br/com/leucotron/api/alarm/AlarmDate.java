package br.com.leucotron.api.alarm;

import org.joda.time.DateTime;

public class AlarmDate {
	
	private DateTime date;
	private long mDateInMillis;
	
	public AlarmDate(DateTime date) {
		this.date = date;
		mDateInMillis = date.getMillis();
	}
	
	public DateTime getDate () {
		return date;
	}
	
	public long getDateInMillis () {
		return mDateInMillis;
	}

}
