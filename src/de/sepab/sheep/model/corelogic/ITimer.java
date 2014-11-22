package de.sepab.sheep.model.corelogic;

public interface ITimer {
	public void reset();
	public void start();
	public void stop();
	public int getTime();
}
