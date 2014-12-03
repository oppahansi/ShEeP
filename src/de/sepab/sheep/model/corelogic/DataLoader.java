package de.sepab.sheep.model.corelogic;

import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Transparency;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class DataLoader implements IDataLoader {

    public static final String SHEEP = "/de/sepab/sheep/model/gfx/sheep_walk.png";
    public static final String DOGE = "/de/sepab/sheep/model/gfx/wolf.png";
    public static final String OBSTACLE = "/de/sepab/sheep/model/gfx/fence.png";
    public static final String FLOOR = "/de/sepab/sheep/model/gfx/grass.png";
    public static final String POWERUP = "/de/sepab/sheep/model/gfx/wolf.png";

    public static final BufferedImage IMAGESHEEP = optimize(load(SHEEP));
    public static final BufferedImage IMAGEDOGE = optimize(load(DOGE));
    public static final BufferedImage IMAGEOBSTACLE = optimize(load(OBSTACLE));
    public static final BufferedImage IMAGEFLOOR = optimize(load(FLOOR));
    public static final BufferedImage IMAGEPOWERUP = optimize(load(POWERUP));
    
    public static final int COORDSSHEEP[][] = {{0,0}};
    public static final int COORDSDOGE[][] = {{0,0}};
    public static final int COORDSOBSTACLE[][] = {{0,0},{32,0},{64,0},
    											  {0,32},{32,32},{64,32},
    											  {0,64},{32,64},{64,64},
    											  {0,96},{32,96},{64,96},
    											  {0,128},{32,128},{64,128},};
    public static final int COORDSFLOOR[][] = {{0,160},{32,160},{64,160}};
    public static final int COORDSPOWERUP[][] = {{0,0}};

    private static String [] highScores;
 

    public DataLoader() {

    }
    
    public int[][] getCoords(String name) {
    	switch (name) {
		case "sheep":
			return COORDSSHEEP;
		case "dog" :
			return COORDSDOGE;
		case "obstacle" :
			return COORDSOBSTACLE;
		case "floor" :
			return COORDSFLOOR;
		case "powerup" :
			return COORDSPOWERUP;
		default:
			return COORDSDOGE;
		}
    }

    public BufferedImage getImage(String name) {
    	switch (name) {
		case "sheep":
			return IMAGESHEEP;
		case "dog" :
			return IMAGEDOGE;
		case "obstacle" :
			return IMAGEOBSTACLE;
		case "floor" :
			return IMAGEFLOOR;
		case "powerup" :
			return IMAGEPOWERUP;
		default:
			return IMAGEDOGE;
		}
    }

    private static BufferedImage load(String str) {

        try {
            BufferedImage img = ImageIO.read(
                    GameBoard.class.getResourceAsStream(str)
            );
            return img;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static BufferedImage optimize(BufferedImage img) {
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice gd = ge.getScreenDevices()[0];
        GraphicsConfiguration gc = gd.getDefaultConfiguration();
        BufferedImage img2 = gc.createCompatibleImage(
                img.getWidth(),
                img.getHeight(),
                Transparency.TRANSLUCENT
        );
        Graphics2D gra = img2.createGraphics();
        gra.drawImage(img, 0, 0, null);
        gra.dispose();
        img = img2;
        return img;
    }

    @Override
    public void save() {

    }

    @Override
    public void load() {

    }

    //Verwaltet auch die Highscoreliste

}