package de.sepab.sheep.logic;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TimerTest extends Thread {

    @Test
    public void tesGetTime() {
        Timer timer = new Timer();

        int expectedTime = 10;

        try {
            timer.start();
            Thread.sleep(10000);
            timer.stop();
        } catch (Exception e) {
            e.printStackTrace();
        }

        int actualTime = timer.getTime();

        assertEquals("Stopped time should be 10 seconds", expectedTime, actualTime);
    }
}