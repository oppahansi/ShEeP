package de.sepab.sheep.handler;

import java.awt.image.BufferedImage;

public interface IDataLoader {

    public void saveHighscore();

    public void loadHighscore();

    public int[] getSpritePosition();

    public BufferedImage getSprite(String path);
}
