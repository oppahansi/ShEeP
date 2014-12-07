package de.sepab.sheep.handler;

import java.util.Random;

public class RandomGenerator implements IRandomGenerator{
	
	/*
	 * Gibt ein zufälliges positives oder negatives Int zurück. 
	 */
	@Override
	public int getRandomNumber() {
		return new Random().nextInt();
	}
	
	/*
	 * Gibt ein zufälliges Int zurück, welches innerhalb des Intervalls liegt, welches übergeben wurde.
	 */
	@Override
	public int getRandomNumber(int start, int end) {
		return start+(new Random().nextInt(end-start+1));
	}
	
	/*
	 * Gibt ein zufälliges Int zurück welches sich an der gaussichen Verteilung orientiert.
	 * Für eine normale Distribution wird ein Hauptwert von 100 und eine Varianz von 5 benötigt.
	 */
	@Override
	public int getRandomNumberDistrubution(int mean, int variance) {
		return (int)((float)mean+new Random().nextGaussian()*(float)variance);
	}
}
