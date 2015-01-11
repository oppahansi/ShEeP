package de.sepab.sheep.logic;

import java.util.Date;

public interface ITimer {
	public void reset();
	public void start();
	public void stop();
	public int getTime();
	public int getStoppedTime();
	public void setTime(Date time);
	public void addTime(int seconds);
}