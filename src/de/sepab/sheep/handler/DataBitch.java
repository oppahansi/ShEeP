package de.sepab.sheep.handler;

import de.sepab.sheep.main.Constants;

import java.awt.image.BufferedImage;
import java.io.*;

public class DataBitch {

    private static GameData GAMEDATA;

    public DataBitch () {
        GAMEDATA = new GameData();
    }

    public static void saveHighscore() {
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("highscores.sav"));
            out.writeObject(GAMEDATA);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void loadHighscore() {
        try {
            if (!saveFileExist()) {
                initGameData();
                return;
            }
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("highscores.sav"));
            GAMEDATA = (GameData) in.readObject();
            in.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean saveFileExist() {
        File saveFile = new File("highscores.sav");
        return saveFile.exists();
    }

    private static void initGameData() {
        GAMEDATA = new GameData();
        GAMEDATA.init();
        saveHighscore();
    }

    public int[] getSpritePosition() {
        return new int[0];
    }

    public BufferedImage getSprite(String path) {
        return new BufferedImage(0, 0, 0);
    }

    public static void main(String[] args) {
        DataBitch dataBitch = new DataBitch();
        GAMEDATA.addHighscore("FirstIn", 4, Constants.COUNT_MOD);
        GAMEDATA.addHighscore("SecondIn", 2, Constants.COUNT_MOD);
        GAMEDATA.addHighscore("LastIn", 3, Constants.COUNT_MOD);

        dataBitch.saveHighscore();
        dataBitch.loadHighscore();

        int[] scores = GAMEDATA.getCountHighscores();
        String[] names = GAMEDATA.getCountNames();

        for (int i = 0; i < 3; i++) {
            System.out.println(names[i] + " " + scores[i]);
        }

    }
}
