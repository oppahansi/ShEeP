package de.sepab.sheep.handler;

public interface IRandomGenerator {
	
	public int getRandomNumber();
	public int getRandomNumber(int start, int end);
	public int getRandomNumberDistrubution(int mean, int variance);
	
}
