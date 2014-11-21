package de.sepab.sheep.model.corelogic;

import java.util.Random;

/*
 * Habe Namen von Random zu RandomHandler ge�ndert aufgrud von �berladung mit der
 * Built-In-Class Random.
 */

public class RandomHandler {
	
	/*
	 * Gibt ein zuf�lliges positives oder negatives Int zur�ck. 
	 */
	public int generateRandomNumber() {
		return new Random().nextInt();
	}
	
	/*
	 * Gibt ein zuf�lliges Int zur�ck, welches innerhalb des Intervalls liegt, welches �bergeben wurde.
	 */
	public int generateRandomNumber(int start, int end) {
		return start+(new Random().nextInt(end-start+1));
	}
	
	/*
	 * Gibt ein zuf�lliges Int zur�ck welches sich an der gaussichen Verteilung orientiert.
	 * F�r eine normale Distribution wird ein Hauptwert von 100 und eine Varianz von 5 ben�tigt.
	 */
	public int generateRandomNumberDistribution(int mean, int variance) {
		return (int)((float)mean+new Random().nextGaussian()*(float)variance);
	}
}