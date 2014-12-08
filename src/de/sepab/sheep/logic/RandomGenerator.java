package de.sepab.sheep.logic;

import java.util.Random;

public class RandomGenerator implements IRandomGenerator {
	
	/*
	 * Gibt ein zuf�lliges positives oder negatives Int zur�ck. 
	 */
	@Override
	public int getRandomNumber() {
		return new Random().nextInt();
	}
	
	/*
	 * Gibt ein zuf�lliges Int zur�ck, welches innerhalb des Intervalls liegt, welches �bergeben wurde.
	 */
	@Override
	public int getRandomNumber(int start, int end) {
		return start+(new Random().nextInt(end-start+1));
	}
	
	/*
	 * Gibt ein zuf�lliges Int zur�ck welches sich an der gaussichen Verteilung orientiert.
	 * F�r eine normale Distribution wird ein Hauptwert von 100 und eine Varianz von 5 ben�tigt.
	 */
	@Override
	public int getRandomNumberDistrubution(int mean, int variance) {
		return (int)((float)mean+new Random().nextGaussian()*(float)variance);
	}
}
