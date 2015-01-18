package de.sepab.sheep.handler;

public interface IDataLoader {

   public void saveHighscore();

   public void loadHighscore();

   public int[] getCountHighscores(int level);

   public int[] getTimeHighscores(int level);

   public String[] getCountNames(int level);

   public String[] getTimeNames(int level);

   public void addHighscore(String name, int newHighscore, int gameMod, int level);

   public boolean isLevelUnlocked(int level);

}