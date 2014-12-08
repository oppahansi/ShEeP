package de.sepab.sheep.handler;

import java.awt.image.BufferedImage;
import java.io.*;

public class DataLoader {

    private static GameData GAMEDATA;

    public DataLoader() {
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
        } catch (ClassNotFoundException | IOException e) {
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
}
