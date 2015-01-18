package de.sepab.sheep.handler;

import java.io.Serializable;

public class GameData implements Serializable {

   private static final long serialVersionUID = 1L;

   private final int MAX_RECORDS = 3;

   private int exp;

   private int[] countHighscoresOne;
   private int[] timeHighscoresOne;
   private String[] countNamesOne;
   private String[] timeNamesOne;
   private int[] countHighscoresTwo;
   private int[] timeHighscoresTwo;
   private String[] countNamesTwo;
   private String[] timeNamesTwo;
   private int[] countHighscoresThree;
   private int[] timeHighscoresThree;
   private String[] countNamesThree;
   private String[] timeNamesThree;

   public GameData() {
      countHighscoresOne = new int[MAX_RECORDS];
      timeHighscoresOne = new int[MAX_RECORDS];
      countNamesOne = new String[MAX_RECORDS];
      timeNamesOne = new String[MAX_RECORDS];
      countHighscoresTwo = new int[MAX_RECORDS];
      timeHighscoresTwo = new int[MAX_RECORDS];
      countNamesTwo = new String[MAX_RECORDS];
      timeNamesTwo = new String[MAX_RECORDS];
      countHighscoresThree = new int[MAX_RECORDS];
      timeHighscoresThree = new int[MAX_RECORDS];
      countNamesThree = new String[MAX_RECORDS];
      timeNamesThree = new String[MAX_RECORDS];
   }

   public void init() {
      exp = 0;
      for (int i = 0; i < MAX_RECORDS; i++) {
         countHighscoresOne[i] = 0;
         timeHighscoresOne[i] = 0;
         countNamesOne[i] = "-----";
         timeNamesOne[i] = "-----";
         countHighscoresTwo[i] = 0;
         timeHighscoresTwo[i] = 0;
         countNamesTwo[i] = "-----";
         timeNamesTwo[i] = "-----";
         countHighscoresThree[i] = 0;
         timeHighscoresThree[i] = 0;
         countNamesThree[i] = "-----";
         timeNamesThree[i] = "-----";
      }
   }

   public void addHighscore(String name, int newHighscore, int gameMod, int level) {
      if (gameMod == Constants.SPLAYER_COUNT) {
         if (isNewCountHighscore(newHighscore, level)) {
            if (level == 1) {
               countHighscoresOne[0] = newHighscore;
               countNamesOne[0] = name;
               sortHighscores(countNamesOne, countHighscoresOne);
               exp += newHighscore / 2;
            }
            else if (level == 2) {
               countHighscoresTwo[0] = newHighscore;
               countNamesTwo[0] = name;
               sortHighscores(countNamesTwo, countHighscoresTwo);
               exp += newHighscore / 2;
            }
            else if (level == 3) {
               countHighscoresThree[0] = newHighscore;
               countNamesThree[0] = name;
               sortHighscores(countNamesThree, countHighscoresThree);
               exp += newHighscore / 2;
            }
         }
      }
      else if (gameMod == Constants.SPLAYER_TIME) {
         if (isNewTimeHighscore(newHighscore, level)) {
            if (level == 1) {
               timeHighscoresOne[0] = newHighscore;
               timeNamesOne[0] = name;
               sortHighscores(timeNamesOne, timeHighscoresOne);
               exp += newHighscore / 2;
            }
            else if (level == 2) {
               timeHighscoresTwo[0] = newHighscore;
               timeNamesTwo[0] = name;
               sortHighscores(timeNamesTwo, timeHighscoresTwo);
               exp += newHighscore / 2;
            }
            else if (level == 3) {
               timeHighscoresThree[0] = newHighscore;
               timeNamesThree[0] = name;
               sortHighscores(timeNamesThree, timeHighscoresThree);
               exp += newHighscore / 2;
            }
         }
      }
   }

   private boolean isNewCountHighscore(int newHighscore, int level) {
      if (level == 1) {
         return newHighscore > countHighscoresOne[0];
      }
      else if (level == 2) {
         return newHighscore > countHighscoresTwo[0];
      }
      else {
         return newHighscore > countHighscoresThree[0];
      }
   }

   private boolean isNewTimeHighscore(int newHighscore, int level) {
      if (level == 1) {
         return newHighscore > timeHighscoresOne[0];
      }
      else if (level == 2) {
         return newHighscore > timeHighscoresTwo[0];
      }
      else {
         return newHighscore > timeHighscoresThree[0];
      }
   }

   private void sortHighscores(String[] names, int[] highscores) {
      for (int i = 1; i < highscores.length; i++) {
         int index = highscores[i];
         String indexName = names[i];
         int j = i;
         while (j > 0 && highscores[j - 1] > index) {
            highscores[j] = highscores[j - 1];
            names[j] = names[j - 1];
            j--;
         }
         highscores[j] = index;
         names[j] = indexName;
      }
   }

   public int getExp() {
      return exp;
   }

   public int[] getCountHighscoresOne() {
      return countHighscoresOne;
   }

   public int[] getTimeHighscoresOne() {
      return timeHighscoresOne;
   }

   public String[] getCountNamesOne() {
      return countNamesOne;
   }

   public String[] getTimeNamesOne() {
      return timeNamesOne;
   }

   public int[] getCountHighscoresTwo() {
      return countHighscoresTwo;
   }

   public int[] getTimeHighscoresTwo() {
      return timeHighscoresTwo;
   }

   public String[] getCountNamesTwo() {
      return countNamesTwo;
   }

   public String[] getTimeNamesTwo() {
      return timeNamesTwo;
   }

   public int[] getCountHighscoresThree() {
      return countHighscoresThree;
   }

   public int[] getTimeHighscoresThree() {
      return timeHighscoresThree;
   }

   public String[] getCountNamesThree() {
      return countNamesThree;
   }

   public String[] getTimeNamesThree() {
      return timeNamesThree;
   }
}