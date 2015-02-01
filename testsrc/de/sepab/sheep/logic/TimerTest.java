package de.sepab.sheep.logic;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TimerTest extends Thread {

    @Test
    public void testGetTime() {
        Timer timer = new Timer();

        int expectedTime = 10;

        timer.start();
        try {
            Thread.sleep(10000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        timer.stop();
        int actualTime = timer.getStoppedTime();

        assertEquals("Stopped time should be 10 seconds", expectedTime, actualTime);
    }
}