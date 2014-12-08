package de.sepab.sheep.handler.data;

public interface ITimer {
	
	public void reset();
	public void start();
	public void stop();
	public int getTime();
	
}
