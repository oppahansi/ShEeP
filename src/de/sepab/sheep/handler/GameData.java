package de.sepab.sheep.handler;

import de.sepab.sheep.main.Constants;

import java.io.Serializable;

public class GameData implements Serializable {

    private static final int MAX_RECORDS = 3;

    private int[] countHighscores;
    private int[] timeHighscores;
    private String[] countNames;
    private String[] timeNames;

    public GameData() {
        this.countHighscores = new int[MAX_RECORDS];
        this.timeHighscores = new int[MAX_RECORDS];
        this.countNames = new String[MAX_RECORDS];
        this.timeNames = new String[MAX_RECORDS];
    }

    public void init() {
        for (int i = 0; i < MAX_RECORDS; i++) {
            countHighscores[i] = 0;
            timeHighscores[i] = 0;
            countNames[i] = "-----";
            timeNames[i] = "-----";
        }
    }

    public void addHighscore(String name, int newHighscore, int gameMod) {
        if (gameMod == Constants.COUNT_MOD) {
            if (isNewCountHighscore(newHighscore)) {
                countHighscores[0] = newHighscore;
                countNames[0] = name;
                sortHighscores(countNames, countHighscores);
            }
        }else if (gameMod == Constants.TIME_MOD) {
            if (isNewTimeHighscore(newHighscore)) {
                timeHighscores[MAX_RECORDS - 1] = newHighscore;
                timeNames[MAX_RECORDS - 1] = name;
                sortTimeHighscores();
            }
        }
    }

    private boolean isNewCountHighscore(int newHighscore) {
        return newHighscore > countHighscores[MAX_RECORDS - 1];
    }

    private boolean isNewTimeHighscore(int newHighscore) {
        return newHighscore > timeHighscores[MAX_RECORDS - 1];
    }

    private void sortHighscores(String[] names, int[] highscores) {
        for (int i= 1; i < highscores.length; i++)
        {
            int index = highscores[i];
            String indexName = names[i];
            int j = i;
            while (j > 0 && highscores[j - 1] > index)
            {
                highscores[j] = highscores[j - 1];
                names[j] = names[j - 1];
                j--;
            }
            highscores[j] = index;
            names[j] = indexName;
        }
    }

    private void sortTimeHighscores() {
        for (int i = 0; i < MAX_RECORDS; i++) {
            int score = timeHighscores[i];
            String name = timeNames[i];

            int j;
            for (j = i - 1; j >= 0 && timeHighscores[i] < score; j--) {
                timeHighscores[j + 1] = timeHighscores[j];
                timeNames[j + 1] = timeNames[j];
            }

            timeHighscores[j + 1] = score;
            timeNames[j + 1] = name;
        }
    }

    public int[] getCountHighscores() {
        return countHighscores;
    }

    public int[] getTimeHighscores() {
        return timeHighscores;
    }

    public String[] getCountNames() {
        return countNames;
    }

    public String[] getTimeNames() {
        return timeNames;
    }
}