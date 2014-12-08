package de.sepab.sheep.handler.data;

public interface IRandomGenerator {
	
	public int getRandomNumber();
	public int getRandomNumber(int start, int end);
	public int getRandomNumberDistrubution(int mean, int variance);
	
}
