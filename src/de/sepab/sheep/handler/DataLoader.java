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
   }

   @Override
   public void addHighscore(String name, int newHighscore, int gameMod) {
      GAMEDATA.addHighscore(name, newHighscore, gameMod);
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

   public int[] getCountHighscores() {
      return GAMEDATA.getCountHighscores();
   }

   public int[] getTimeHighscores() {
      return GAMEDATA.getTimeHighscores();
   }

   public String[] getCountNames() {
      return GAMEDATA.getCountNames();
   }

   public String[] getTimeNames() {
      return GAMEDATA.getTimeNames();
   }
}
