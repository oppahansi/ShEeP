package de.sepab.sheep.display;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Transparency;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import de.sepab.sheep.entities.IEntity;
import de.sepab.sheep.logic.ILevel;
import de.sepab.sheep.logic.IRandomGenerator;

@SuppressWarnings("serial")
public class GameBoard extends JPanel {
	
	private static final String SHEEP = "/de/sepab/sheep/model/gfx/sheep_walk.png";
	private static final String DOGE = "/de/sepab/sheep/model/gfx/wolf.png";
	private static final String OBSTACLE = "/de/sepab/sheep/model/gfx/fence.png";
	private static final String FLOOR = "/de/sepab/sheep/model/gfx/grass.png";
	private static final String POWERUP = "/de/sepab/sheep/model/gfx/wolf.png";

	private static final BufferedImage IMAGESHEEP = optimize(load(SHEEP));
	private static final BufferedImage IMAGEDOGE = optimize(load(DOGE));
	private static final BufferedImage IMAGEOBSTACLE = optimize(load(OBSTACLE));
	private static final BufferedImage IMAGEFLOOR = optimize(load(FLOOR));
	private static final BufferedImage IMAGEPOWERUP = optimize(load(POWERUP));
	    
	private static final int COORDSSHEEP[][] = {{0,0}};
	private static final int COORDSDOGE[][] = {{0,0}};
	private static final int COORDSOBSTACLE[][] = {{0,0},{32,0},{64,0},
	    										  {0,32},{32,32},{64,32},
	    										  {0,64},{32,64},{64,64},
	    										  {0,96},{32,96},{64,96},
	    										  {0,128},{32,128},{64,128},};
	private static final int COORDSFLOOR[][] = {{0,160},{32,160},{64,160}};
	private static final int COORDSPOWERUP[][] = {{0,0}};
	

	private IRandomGenerator rg;
	private ILevel modelLvl;
	
	
	private int tl = 32; //tl = texture length
	private int background[][][] = new int[20][15][2];
	
    public void paintComponent(Graphics gr) {
    	Graphics2D g = (Graphics2D) gr;
    	g.setColor(Color.BLACK);
//    	g.fill(g.getClipBounds());
//    	
//    	g.drawImage(imgSheep, 0, 0, 640,480,null);
    	
    	paintBackground(g);
    	paintEntities(g);
    }
    
    public void Update(ILevel igb, IRandomGenerator rg) {
    	this.rg = rg;
    	this.modelLvl = igb;
    }
    
    public GameBoard(ILevel iLvl, IRandomGenerator rg) {
    	this.setFocusable(true);
    	setLayout(null);
    	this.setPreferredSize(new Dimension(640, 480));
    	this.rg = rg;
    	this.modelLvl = iLvl;
    	shuffle();
    }
    
    public void shuffle() {
    	for (int x = 0; x < 20; x++) {
			for (int y = 0; y < 15; y++) {
				int i = rg.getRandomNumber(0, 2);//2 ist die anzahl an floor texturen
				background[x][y][0] = COORDSFLOOR[i][0];
				background[x][y][1] = COORDSFLOOR[i][1];
			}
		}
    }
    
    
    
    public void paintBackground(Graphics2D g) {
    	for (int x = 0; x < background.length; x++) {
			for (int y = 0; y < background[0].length; y++) {
				g.drawImage(IMAGEFLOOR.getSubimage(background[x][y][0], background[x][y][1], tl, tl), x*tl, y*tl, tl, tl, null);
			}
		}
    }
    
    public void paintEntities(Graphics2D g) {
    	paintObstacle(g);
    	paintSheep(g);
    	paintDog(g);
    	paintPowerUp(g);
    }
    
    public void paintSheep(Graphics2D g) {
    	if (modelLvl.getSheepList() != null) {
    		for (IEntity sheep : modelLvl.getSheepList()) {
        		g.drawImage(IMAGESHEEP.getSubimage(COORDSSHEEP[sheep.getSpritePos()][0], COORDSSHEEP[sheep.getSpritePos()][1], tl, tl), sheep.getPosX(), sheep.getPosY(), tl, tl, null);
    		}
		}
    }
    
    public void paintObstacle(Graphics2D g) {
    	if (modelLvl.getObstacleList() != null) {
    		for (IEntity obstacle : modelLvl.getObstacleList()) {
        		g.drawImage(IMAGEOBSTACLE.getSubimage(COORDSOBSTACLE[obstacle.getSpritePos()][0], COORDSOBSTACLE[obstacle.getSpritePos()][1], tl, tl), obstacle.getPosX(), obstacle.getPosY(), tl, tl, null);
    		}
		}
    }
    
    public void paintDog(Graphics2D g) {
    	if (modelLvl.getDogList() != null) {
    		for (IEntity dog : modelLvl.getDogList()) {
        		g.drawImage(IMAGEDOGE.getSubimage(COORDSDOGE[dog.getSpritePos()][0], COORDSDOGE[dog.getSpritePos()][1], tl, tl), dog.getPosX(), dog.getPosY(), tl, tl, null);
    		}
		}
    }
    
    public void paintPowerUp(Graphics2D g) {
    	if (modelLvl.getPowerUpList() != null) {
    		for (IEntity powerUp : modelLvl.getPowerUpList()) {
        		g.drawImage(IMAGEPOWERUP.getSubimage(COORDSPOWERUP[powerUp.getSpritePos()][0], COORDSPOWERUP[powerUp.getSpritePos()][1], tl, tl), powerUp.getPosX(), powerUp.getPosY(), tl, tl, null);
    		}
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
    
   
}