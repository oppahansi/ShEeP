package de.sepab.sheep.handler;

import de.sepab.sheep.main.Constants;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GameDataTest {

    @Test
    public void testInit(){
        GameData gameData = new GameData();
        gameData.init();

        int[] actualCountHighscores = gameData.getCountHighscores();
        int[] actualTimeHighscores = gameData.getTimeHighscores();
        String[] actualCountNames = gameData.getCountNames();
        String[] actualTimeNames = gameData.getTimeNames();

        int expectedHighscore = 0;
        String expectedName = "-----";

        assertEquals("Initialized countHighscore Array", expectedHighscore, actualCountHighscores[0]);
        assertEquals("Initialized timeHighscore Array", expectedHighscore, actualTimeHighscores[0]);
        assertEquals("Initialized countNames Array", expectedName, actualCountNames[0]);
        assertEquals("Initialized timeNames Array", expectedName, actualTimeNames[0]);
    }

    @Test
    public void testAddHighscore() {
        GameData gameData = new GameData();
        gameData.init();
        gameData.addHighscore("Test", 123, Constants.COUNT_MOD);

        int expectedHighscore = 123;
        String expectedName = "Test";
        String actualName = gameData.getCountNames()[2];

        assertEquals("First Player should have the name Test", expectedName, actualName);
    }
}
