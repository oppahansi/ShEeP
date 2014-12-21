package de.sepab.sheep.logic;

import java.util.Date;

public interface ITimer {
	
	public void reset();
	public void start();
	public int getTime();
	public void setTime(Date time);
	public void changeTime(int seconds);
}
