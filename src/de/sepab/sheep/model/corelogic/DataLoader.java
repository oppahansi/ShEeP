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
	
	public static final String SHEEP = "";
	public static final String DOGE = "";
	public static final String OBSTACLE = "";
	public static final String FLOOR = "";
	public static final String POWERUP = "";
	
	public static final BufferedImage IMAGESHEEP = optimize(load(SHEEP));
	public static final BufferedImage IMAGEDOGE = optimize(load(DOGE));
	public static final BufferedImage IMAGEOBSTACLE = optimize(load(OBSTACLE));
	public static final BufferedImage IMAGEFLOOR = optimize(load(FLOOR));
	public static final BufferedImage IMAGEPOWERUP = optimize(load(POWERUP));

	public DataLoader(){
		
	}
	
	public BufferedImage getImage(String name){
		return null;
	}
	
	public static BufferedImage load(String str) {
	     
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
	
	public static BufferedImage optimize(BufferedImage img) {
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
	
	//Verwaltet auch die Highscoreliste
	
}
