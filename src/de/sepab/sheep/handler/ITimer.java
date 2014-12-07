package de.sepab.sheep.handler;

public interface ITimer {
	
	public void reset();
	public void start();
	public void stop();
	public int getTime();
	
}
