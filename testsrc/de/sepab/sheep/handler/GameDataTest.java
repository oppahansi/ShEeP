package de.sepab.sheep.handler;

import de.sepab.sheep.handler.data.Constants;
import de.sepab.sheep.handler.data.GameData;
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
    public void testAddCountHighscore() {
        GameData gameData = new GameData();
        gameData.init();
        gameData.addHighscore("Two", 12, Constants.COUNT_MOD);
        gameData.addHighscore("One", 123, Constants.COUNT_MOD);
        gameData.addHighscore("Three", 1, Constants.COUNT_MOD);

        int expectedOneHighscore = 123;
        String expectedOneName = "One";
        int actualOneHighscore = gameData.getCountHighscores()[2];
        String actualOneName = gameData.getCountNames()[2];

        int expectedTwoHighscore = 12;
        String expectedTwoName = "Two";
        int actualTwoHighscore = gameData.getCountHighscores()[1];
        String actualTwoName = gameData.getCountNames()[1];

        int expectedThreeHighscore = 1;
        String expectedThreeName = "Three";
        int actualThreeHighscore = gameData.getCountHighscores()[0];
        String actualThreeName = gameData.getCountNames()[0];

        assertEquals("Player One should have the score 123", expectedOneHighscore, actualOneHighscore);
        assertEquals("Player One should have the name One", expectedOneName, actualOneName);
        assertEquals("Player Two should have the score 12", expectedOneHighscore, actualOneHighscore);
        assertEquals("Player Two should have the name Two", expectedOneName, actualOneName);
        assertEquals("Player Three should have the score 1", expectedOneHighscore, actualOneHighscore);
        assertEquals("Player Three should have the name Three", expectedOneName, actualOneName);
    }

}
