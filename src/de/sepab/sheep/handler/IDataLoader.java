package de.sepab.sheep.handler;

import java.awt.image.BufferedImage;

public interface IDataLoader {

    public void saveHighscore();

    public void loadHighscore();
    
    public int[] getCountHighscores();

    public int[] getTimeHighscores();

    public String[] getCountNames();

    public String[] getTimeNames();

}
