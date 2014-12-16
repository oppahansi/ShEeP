package de.sepab.sheep.entities;

public interface ISheep {
	public int[] getThoughts();
	public boolean isScared();
	public void scare(int x, int y);
	public int getX();
	public int getY();
}
