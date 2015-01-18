package de.sepab.sheep.handler;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class DataLoader implements IDataLoader {

   private static GameData GAMEDATA;

   public DataLoader() {
      GAMEDATA = new GameData();
      loadHighscore();
   }

   @Override
   public void addHighscore(String name, int newHighscore, int gameMod, int level) {
      GAMEDATA.addHighscore(name, newHighscore, gameMod, level);
   }

   public void saveHighscore() {
      try {
         ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("highscores.sav"));
         out.writeObject(GAMEDATA);
         out.close();
      }
      catch (IOException e) {
         e.printStackTrace();
      }
   }

   @Override
   public void loadHighscore() {
      try {
         if (!saveFileExist()) {
            initGameData();
            return;
         }
         ObjectInputStream in = new ObjectInputStream(new FileInputStream("highscores.sav"));
         GAMEDATA = (GameData) in.readObject();
         in.close();
      }
      catch (ClassNotFoundException | IOException e) {
         e.printStackTrace();
      }
   }

   private boolean saveFileExist() {
      File saveFile = new File("highscores.sav");
      return saveFile.exists();
   }

   private void initGameData() {
      GAMEDATA = new GameData();
      GAMEDATA.init();
      saveHighscore();
   }

   @Override
   public int[] getCountHighscores(int level) {
      if (level == 1) {
         return GAMEDATA.getCountHighscoresOne();
      }
      else if (level == 2) {
         return GAMEDATA.getCountHighscoresTwo();
      }
      else {
         return GAMEDATA.getCountHighscoresThree();
      }

   }

   @Override
   public int[] getTimeHighscores(int level) {
      if (level == 1) {
         return GAMEDATA.getTimeHighscoresOne();
      }
      else if (level == 2) {
         return GAMEDATA.getTimeHighscoresTwo();
      }
      else {
         return GAMEDATA.getTimeHighscoresThree();
      }
   }

   @Override
   public String[] getCountNames(int level) {
      if (level == 1) {
         return GAMEDATA.getCountNamesOne();
      }
      else if (level == 2) {
         return GAMEDATA.getCountNamesTwo();
      }
      else {
         return GAMEDATA.getCountNamesThree();
      }
   }

   @Override
   public String[] getTimeNames(int level) {
      if (level == 1) {
         return GAMEDATA.getTimeNamesOne();
      }
      else if (level == 2) {
         return GAMEDATA.getTimeNamesTwo();
      }
      else {
         return GAMEDATA.getTimeNamesThree();
      }
   }

   @Override
   public boolean isLevelUnlocked(final int level) {
      if (level == 1) {
         return true;
      }
      else if (level == 2) {
         if (GAMEDATA.getExp() >= Constants.LEVEL_TWO_CAP) {
            return true;
         }
         return false;
      }
      else if (level == 3) {
         if (GAMEDATA.getExp() >= Constants.LEVEL_THREE_CAP) {
            return true;
         }
         return false;
      }
      else {
         return false;
      }
   }
}