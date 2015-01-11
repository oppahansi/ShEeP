package de.sepab.sheep.handler;

public interface IDataLoader {

   public void saveHighscore();

   public void loadHighscore();

   public int[] getCountHighscores();

   public int[] getTimeHighscores();

   public String[] getCountNames();

   public String[] getTimeNames();

   public void addHighscore(String name, int newHighscore, int gameMod);

}