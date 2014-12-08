package de.sepab.sheep.logic;

public interface IRandomGenerator {
	
	public int getRandomNumber();
	public int getRandomNumber(int start, int end);
	public int getRandomNumberDistribution(int mean, int variance);
	
}
