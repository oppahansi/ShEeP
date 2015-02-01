package de.sepab.sheep.handler;

import java.io.Serializable;

public class GameData implements Serializable {

   private static final long serialVersionUID = 1L;

   private final int MAX_RECORDS = 3;
   private final int MAX_MAPS = 3;

   private int[][] countHighscores;
   private int[][] timeHighscores;
   
   private String[][] countNames;
   private String[][] timeNames;
   
   private  int level;

   public GameData() {
      this.countHighscores = new int[MAX_RECORDS][MAX_MAPS];
      this.timeHighscores = new int[MAX_RECORDS][MAX_MAPS];
      this.countNames = new String[MAX_RECORDS][MAX_MAPS];
      this.timeNames = new String[MAX_RECORDS][MAX_MAPS];
   }

   public void init() {
      level = 1;
      for (int i = 0; i < MAX_RECORDS; i++) {
    	  for (int j = 0; j < MAX_MAPS; j++) {
        	  countHighscores[i][j] = 999;
              timeHighscores[i][j] = 0;
              countNames[i][j] = "-----";
              timeNames[i][j] = "-----";
    	  }
      }   
   }

   public boolean addHighscore(String name, int newHighscore, int gameMod, int map) {
      if (gameMod == Constants.SPLAYER_COUNT) {
         if (isNewCountHighscore(newHighscore, map)) {
            countHighscores[0][map] = newHighscore;
            countNames[0][map] = name;
            sortHighscores(countNames, countHighscores, map);
            return true;
         } else {
        	 return false;
         }
      }

      else if (gameMod == Constants.SPLAYER_TIME) {
         if (isNewTimeHighscore(newHighscore, map)) {
            timeHighscores[0][map] = newHighscore;
            timeNames[0][map] = name;
            sortHighscores(timeNames, timeHighscores, map);
            return true;
         } else {
        	 return false;
         }
      }
      System.out.println("Fehler!");
      return false;
   }

   private boolean isNewCountHighscore(int newHighscore, int map) {
      return newHighscore < countHighscores[0][map];
   }

   private boolean isNewTimeHighscore(int newHighscore, int map) {
      return newHighscore > timeHighscores[0][map];
   }

   private void sortHighscores(String[][] names, int[][] highscores, int map) {
      for (int i = 1; i < highscores.length; i++) {
         int index = highscores[i][map];
         String indexName = names[i][map];
         int j = i;
         while (j > 0 && highscores[j - 1][map] > index) {
            highscores[j][map] = highscores[j - 1][map];
            names[j][map] = names[j - 1][map];
            j--;
         }
         highscores[j][map] = index;
         names[j][map] = indexName;
      }
   }

   public int[][] getCountHighscores() {
      return countHighscores;
   }

   public int[][] getTimeHighscores() {
      return timeHighscores;
   }

   public String[][] getCountNames() {
      return countNames;
   }

   public String[][] getTimeNames() {
      return timeNames;
   }



   public int getLevel() {
	   return level;
   }

   public void setLevel(int level) {
		this.level = level;
	}
}