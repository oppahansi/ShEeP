package de.sepab.sheep.entities;

public interface ISheep {
	public int[] getThoughts();
	public boolean isScared();
	public void scare(boolean state, int x, int y);
	public void unscare();
	public void setAddSpeed(int addSpeed);
	public boolean isDeaf();
	public void deafy(boolean state);
	public void checkPowerUpLife();
	public int getScareX();
	public int getScareY();
	public void setChained(boolean state);
	public boolean isChained();
}
