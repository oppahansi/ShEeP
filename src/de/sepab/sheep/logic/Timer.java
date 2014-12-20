package de.sepab.sheep.logic;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Timer implements ITimer {
	
	private Date startTime;
	private Date stopTime;
	private SimpleDateFormat formatSec = new SimpleDateFormat("ss");
	private SimpleDateFormat formatMin = new SimpleDateFormat("mm");
	
	public Timer() {
		this.reset();
	}
	
	@Override
	public void reset() {
		this.startTime = new Date();
		this.stopTime = this.startTime;
	}

	@Override
	public void start() {
		this.startTime = new Date();
	}

	@Override
	public int getTime() {
		return (-1)*((
				(60*Integer.parseInt(this.formatMin.format(this.stopTime)))
				+
				(Integer.parseInt(this.formatSec.format(this.stopTime)))
				)
				-
				(
				(60*Integer.parseInt(this.formatMin.format(this.startTime)))
				+
				(Integer.parseInt(this.formatSec.format(this.startTime)))
				));
	}

	@Override
	public void setTime(Date time) {
		this.startTime = time;
	}

	@Override
	public void changeTime(int seconds) {
		this.startTime.setTime(((long)this.getTime())*60 + ((long)seconds));
	}

}
