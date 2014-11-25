package de.sepab.sheep.model.corelogic;

public interface IRandomGenerator {
	public int generateRandomNumber();
	public int generateRandomNumber(int start, int end);
	public int generateRandomNumberDistribution(int mean, int variance);
}
