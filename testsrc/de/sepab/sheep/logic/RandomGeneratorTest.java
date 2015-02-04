package de.sepab.sheep.logic;

import static org.junit.Assert.*;
import org.junit.Test;
import de.sepab.sheep.logic.RandomGenerator;

public class RandomGeneratorTest {



	@Test
	public void getRandomNumberIntervalTest() {
		int [] array = new int [1000];
		int [] count = new int [10];
	
		for (int i=0; i< 1000; i++) {
			array [i] = RandomGenerator.getRandomNumber(1,10);
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
	
		
		boolean relVert = true;
		for (int i=0; i<10; i++) {
			if (count [i] < 75) relVert = false;
		}
		assertEquals ("Jede Zahl wurde mindestens 75 mal generiert", true, relVert);
	}
	
	


	@Test
	public void generateRandomNumberDistributionTest() {
		int [] array = new int [1000];
		int dev0 = 0;
		int devMax5 = 0;
		int devMax10 = 0;
		int devMoreThan10 = 0;
		for (int i=0; i< 1000; i++) {
			array [i] = RandomGenerator.getRandomNumberDistribution(100, 5);
			if (array [i] > 100 && array[i] <= 105 || array [i] < 100 && array [i] >= 95) devMax5++;
			else if (array [i] > 105 && array[i] <= 110 || array [i] < 95 && array [i] >= 90) devMax10++;
			else if (array [i] > 110 || array [i] < 90 ) devMoreThan10++;
			else dev0++;
		}

	
		boolean deviation = true;
		if (devMax5 < 600) deviation = false;
		if (devMoreThan10 > 100) deviation = false;
	
		assertEquals ("Die Verteilung der generierten Zahlen aehnelt der der Normalverteilung", true, deviation);
	}

}