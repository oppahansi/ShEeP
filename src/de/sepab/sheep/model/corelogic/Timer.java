package de.sepab.sheep.model.corelogic;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Timer  implements ITimer{

	private Date StartTime;
	private Date StopTime;
	private SimpleDateFormat FormatSec = new SimpleDateFormat("ss");
	private SimpleDateFormat FormatMin = new SimpleDateFormat("mm");
	
	public Timer() {
		this.reset();
	}
	
	@Override
	public void reset() {
		this.StartTime = new Date();
		this.StopTime = this.StartTime;
	}

	@Override
	public void start() {
		this.StartTime = new Date();
	}

	@Override
	public void stop() {
		this.StopTime = new Date(); 
	}

	@Override
	public int getTime() {
		return ((
				(60*Integer.parseInt(this.FormatMin.format(this.StopTime)))
				+
				(Integer.parseInt(this.FormatSec.format(this.StopTime)))
				)
				-
				(
				(60*Integer.parseInt(this.FormatMin.format(this.StartTime)))
				+
				(Integer.parseInt(this.FormatSec.format(this.StartTime)))
				));
	}
}
