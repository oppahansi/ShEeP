package de.sepab.sheep.logic;

import static org.junit.Assert.*;
import org.junit.Test;
import de.sepab.sheep.logic.Timer;

public class TimerTest extends Thread {
	
	Timer tester = new Timer();
	
	public void run() {
	    tester.start(); 
		try {
	    	 sleep(20000);
	     }
	     catch(InterruptedException e) {
	     }
	    tester.stop();
		System.out.println(tester.getTime());
	     
	    }
	
	
	
	@Test
	public void TimerTest() {
		TimerTest t = new TimerTest();
		t.run();
	}

}