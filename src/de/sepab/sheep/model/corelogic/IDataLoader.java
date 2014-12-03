package de.sepab.sheep.model.corelogic;

import java.awt.image.BufferedImage;

public interface IDataLoader {

    public void save();
    public void load();
    public BufferedImage getImage(String name);
    public int[][] getCoords(String name);

}
