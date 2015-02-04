package de.sepab.sheep.handler;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GameDataTest {

    @Test
    public void testInit(){
        GameData gameData = new GameData();
        gameData.init();

        int[][] actualCountHighscores = gameData.getCountHighscores();
        int[][] actualTimeHighscores = gameData.getTimeHighscores();
        String[][] actualCountNames = gameData.getCountNames();
        String[][] actualTimeNames = gameData.getTimeNames();

        int expectedHighscoreTime = 0;
        int expectedHighscoreCount = 999;
        String expectedName = "-----";

        assertEquals("Initialized countHighscore Array", expectedHighscoreCount, actualCountHighscores[0][0]);
        assertEquals("Initialized timeHighscore Array", expectedHighscoreTime, actualTimeHighscores[0][0]);
        assertEquals("Initialized countNames Array", expectedName, actualCountNames[0][0]);
        assertEquals("Initialized timeNames Array", expectedName, actualTimeNames[0][0]);
    }

    @Test
    public void testAddCountHighscore() {
        GameData gameData = new GameData();
        gameData.init();
        gameData.addHighscore("Two", 12, Constants.SPLAYER_COUNT, 1);
        gameData.addHighscore("One", 1, Constants.SPLAYER_COUNT, 1);
        gameData.addHighscore("Three", 123, Constants.SPLAYER_COUNT, 1);

        int expectedOneHighscore = 1;
        String expectedOneName = "One";
        int actualOneHighscore = gameData.getCountHighscores()[2][1];
        String actualOneName = gameData.getCountNames()[2][1];

        int expectedTwoHighscore = 12;
        String expectedTwoName = "Two";
        int actualTwoHighscore = gameData.getCountHighscores()[1][1];
        String actualTwoName = gameData.getCountNames()[1][1];

        int expectedThreeHighscore = 123;
        String expectedThreeName = "Three";
        int actualThreeHighscore = gameData.getCountHighscores()[0][1];
        String actualThreeName = gameData.getCountNames()[0][1];

        assertEquals("Player One should have the score 123", expectedOneHighscore, actualOneHighscore);
        assertEquals("Player One should have the name One", expectedOneName, actualOneName);
        assertEquals("Player Two should have the score 12", expectedTwoHighscore, actualTwoHighscore);
        assertEquals("Player Two should have the name Two", expectedTwoName, actualTwoName);
        assertEquals("Player Three should have the score 1", expectedThreeHighscore, actualThreeHighscore);
        assertEquals("Player Three should have the name Three", expectedThreeName, actualThreeName);
    }

}
