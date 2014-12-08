package de.sepab.sheep.logic;

import static org.junit.Assert.*;
import org.junit.Test;
import de.sepab.sheep.logic.RandomGenerator;

public class RandomGeneratorTest {
	
	RandomGenerator tester = new RandomGenerator();
	
	/*
	 * Erzeugt ein Array aus 1000 mit GenerateRandomNumber() erzeugten Zahlen.
	 * Anschließend wird geprüft, ob irgendeine Zahl mehrfach vorkommt. 
	 * Ist dies der Fall, ist der Test nicht bestanden.
	 */
	@Test
	public void getRandomNumberTest() {
		int [] array = new int [1000];
		boolean noRepeat = true;
		for (int i=0; i< 1000; i++) {
			array [i] = tester.getRandomNumber();
			for (int j=0; j<i; j++) {
				if (array[i]==array[j]) noRepeat = false;
			}
		}
		
		for (int i=0; i < 1000; i++) {
		System.out.println (i+1 +". "+ "" + array[i]);
		assertEquals ("Bei 1000 Zahlen keine Wiederholung", true, noRepeat);
		}
	}
	
	
	/*
	 * Testet die GenerateRandomNumber() Methode für ein Intervall von 1-10.
	 * Da für jede Zahl eine Chance von 1/10 besteht, muss sich bei einer Stichprobe von 1000 die relative Häufigkeit
	 * jeder Zahl 100 annähern. Als erwarteten Wert habe ich für jede Zahl mindestens 75 gewählt.
	 */
	@Test
	public void getRandomNumberIntervalTest() {
		int [] array = new int [1000];
		int [] count = new int [10];
	
		for (int i=0; i< 1000; i++) {
			array [i] = tester.getRandomNumber(1,10);
			switch (array[i]) {
			case 1:	count[0]++; break;
			case 2:	count[1]++; break;
			case 3:	count[2]++; break;
			case 4:	count[3]++; break;
			case 5:	count[4]++; break;
			case 6:	count[5]++; break;
			case 7:	count[6]++; break;
			case 8:	count[7]++; break;
			case 9:	count[8]++; break;
			case 10:count[9]++; break;
			}
		}
		System.out.println ("Häufigkeit 1: " +count[0]);
		System.out.println ("Häufigkeit 2: " +count[1]);
		System.out.println ("Häufigkeit 3: " +count[2]);
		System.out.println ("Häufigkeit 4: " +count[3]);
		System.out.println ("Häufigkeit 5: " +count[4]);
		System.out.println ("Häufigkeit 6: " +count[5]);
		System.out.println ("Häufigkeit 7: " +count[6]);
		System.out.println ("Häufigkeit 8: " +count[7]);
		System.out.println ("Häufigkeit 9: " +count[8]);
		System.out.println ("Häufigkeit 10: "+count[9]);
		
		boolean relVert = true;
		for (int i=0; i<10; i++) {
			if (count [i] < 75) relVert = false;
		}
		assertEquals ("Jede Zahl wurde mindestens 75 mal generiert", true, relVert);
	}
	
	
	
	/*Testet die Methode 1000 mal mit Erwarungswert 100 und Varianz 5 und überpüft die Abweichung der Zufallswerte.
	 * Dabei werden die Abweichungen um höchstens 5, höchstens 10 und größer als 10 gezählt.
	 * Mindestens 60%  dürfen maximal um 5 abweichen und höchstens 10% dürfen um mehr als 10 abweichen.
	 */
	
	@Test
	public void generateRandomNumberDistributionTest() {
		int [] array = new int [1000];
		int dev0 = 0;
		int devMax5 = 0;
		int devMax10 = 0;
		int devMoreThan10 = 0;
		for (int i=0; i< 1000; i++) {
			array [i] = tester.getRandomNumberDistribution(100, 5);
			if (array [i] > 100 && array[i] <= 105 || array [i] < 100 && array [i] >= 95) devMax5++;
			else if (array [i] > 105 && array[i] <= 110 || array [i] < 95 && array [i] >= 90) devMax10++;
			else if (array [i] > 110 || array [i] < 90 ) devMoreThan10++;
			else dev0++;
		}
		
		System.out.println("Abweichungen um höchstens 5: " + (devMax5 + dev0));
		System.out.println("Abweichungen um höchstens 10: " + devMax10);
		System.out.println("Abweichungen um mehr als 10: " + devMoreThan10);
		
		boolean deviation = true;
		if (devMax5 < 600) deviation = false;
		if (devMoreThan10 > 100) deviation = false;
	
		assertEquals ("Die Verteilung der generierten Zahlen ähnelt der der Normalverteilung", true, deviation);
	}

}