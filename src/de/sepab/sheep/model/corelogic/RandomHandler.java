package de.sepab.sheep.model.corelogic;

import java.util.Random;

/*
 * Habe Namen von Random zu RandomHandler geändert aufgrud von Überladung mit der
 * Built-In-Class Random.
 */

public class RandomHandler {
	
	/*
	 * Gibt ein zufälliges positives oder negatives Int zurück. 
	 */
	public int generateRandomNumber() {
		return new Random().nextInt();
	}
	
	/*
	 * Gibt ein zufälliges Int zurück, welches innerhalb des Intervalls liegt, welches übergeben wurde.
	 */
	public int generateRandomNumber(int start, int end) {
		return start+(new Random().nextInt(end-start+1));
	}
	
	/*
	 * Gibt ein zufälliges Int zurück welches sich an der gaussichen Verteilung orientiert.
	 * Für eine normale Distribution wird ein Hauptwert von 100 und eine Varianz von 5 benötigt.
	 */
	public int generateRandomNumberDistribution(int mean, int variance) {
		return (int)((float)mean+new Random().nextGaussian()*(float)variance);
	}
}