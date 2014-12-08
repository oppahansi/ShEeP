package de.sepab.sheep.handler.data;

import java.awt.image.BufferedImage;

public interface IDataLoader {

    public void saveHighscore();

    public void loadHighscore();

    public int[] getSpritePosition();

    public BufferedImage getSprite(String path);
}
