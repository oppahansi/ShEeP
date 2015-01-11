package de.sepab.sheep.logic;

import java.util.Random;

public class RandomGenerator {
	
	/*
	 * Gibt ein zuf�lliges positives oder negatives Int zur�ck. 
	 */
	public static int getRandomNumber() {
		return new Random().nextInt();
	}
	
	/*
	 * Gibt ein zuf�lliges Int zur�ck, welches innerhalb des Intervalls liegt, welches �bergeben wurde.
	 */
	public static int getRandomNumber(int start, int end) {
		return start+(new Random().nextInt(end-start+1));
	}
	
	/*
	 * Gibt ein zuf�lliges Int zur�ck welches sich an der gaussichen Verteilung orientiert.
	 * F�r eine normale Distribution wird ein Hauptwert von 100 und eine Varianz von 5 ben�tigt.
	 */
	public static int getRandomNumberDistribution(int mean, int deviation) {
		return (int)((float)mean+new Random().nextGaussian()*(float)deviation);
	}

	public static boolean getPercentDistribution(int percent, int precision) {
		if(getRandomNumber(1, (int)(100*Math.pow(10, precision)) ) <= percent*Math.pow(10, precision)) {
			return true;
		}
		else {
			return false;
		}
	}
}
