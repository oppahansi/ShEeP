package de.sepab.sheep.handler;

public interface IDataLoader {

   public void saveHighscore();

   public void loadHighscore();

   public int[][] getCountHighscores();

   public int[][] getTimeHighscores();

   public String[][] getCountNames();

   public String[][] getTimeNames();

   public boolean addHighscore(String name, int newHighscore, int gameMod, int map);
   
   public int getLevel();
   
   public void setLevel(int level);

}