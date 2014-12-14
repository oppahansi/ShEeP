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
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

import de.sepab.sheep.entities.IEntity;
import de.sepab.sheep.handler.IInput;
import de.sepab.sheep.handler.Input;
import de.sepab.sheep.logic.ILevel;
import de.sepab.sheep.logic.IRandomGenerator;

@SuppressWarnings("serial")
public class GameBoard extends JPanel{
	
	private static final String SHEEP = "/de/sepab/sheep/model/gfx/sheep_walk32x32.png";
	private static final String DOGE = "/de/sepab/sheep/model/gfx/wolf32x32.png";
	private static final String OBSTACLE = "/de/sepab/sheep/model/gfx/fence.png";
	private static final String FLOOR = "/de/sepab/sheep/model/gfx/grass.png";
	private static final String POWERUP = "/de/sepab/sheep/model/gfx/wolf.png";

	private static final BufferedImage IMAGESHEEP = optimize(load(SHEEP));
	private static final BufferedImage IMAGEDOGE = optimize(load(DOGE));
	private static final BufferedImage IMAGEOBSTACLE = optimize(load(OBSTACLE));
	private static final BufferedImage IMAGEFLOOR = optimize(load(FLOOR));
	private static final BufferedImage IMAGEPOWERUP = optimize(load(POWERUP));
	private BufferedImage imageBackground;
	    
	private static final int COORDSSHEEP[][] = {{16,16}};
	private static final int COORDSDOGE[][] = {{0,0}};
	private static final int COORDSOBSTACLE[][] = {{0,0},{32,0},{64,0},
	    										  {0,32},{32,32},{64,32},
	    										  {0,64},{32,64},{64,64},
	    										  {0,96},{32,96},{64,96},
	    										  {0,128},{32,128},{64,128},};
	private static final int COORDSFLOOR[][] = {{0,160},{32,160},{64,160}};
	private static final int COORDSPOWERUP[][] = {{0,0}};

	private IRandomGenerator randomGenerator;
	private ILevel level;
	
	
	private int textureLength = 32; //tl = texture length
	private int x = 40, y=30;
	private int background[][][] = new int[x][y][2];
	
	
    public void paintComponent(Graphics gr) {
    	Graphics2D g = (Graphics2D) gr;
    	g.setColor(Color.BLACK);
//    	g.fill(g.getClipBounds());
//    	
//    	g.drawImage(imgSheep, 0, 0, 640,480,null);
    	
//    	paintBackground(g);
    	if (imageBackground != null) {
    		g.drawImage(imageBackground,0,0, null);
		}
    	paintEntities(g);
    }
    
    public void Update(ILevel level, IRandomGenerator randomGenerator) {
    	this.randomGenerator = randomGenerator;
    	this.level = level;
    }
    
    public GameBoard(ILevel level, IRandomGenerator randomGenerator, IInput input) {
    	addKeyListener((Input)input);
    	this.setFocusable(true);
    	setLayout(null);
    	this.setPreferredSize(new Dimension(1280, 960));
    	this.randomGenerator = randomGenerator;
    	this.level = level;
    }
    
    public void shuffle() {
    	try{
    		
    	imageBackground = new BufferedImage(1280, 960, BufferedImage.TYPE_INT_RGB);
    	Graphics g = imageBackground.getGraphics();
    	for (int x = 0; x < this.x; x++) {
			for (int y = 0; y < this.y; y++) {
				int i = randomGenerator.getRandomNumber(0, 2);//2 ist die anzahl an floor texturen
				g.drawImage(IMAGEFLOOR.getSubimage(COORDSFLOOR[i][0], COORDSFLOOR[i][1], textureLength, textureLength), x*32, x*32, null);
			}
		}
    		ImageIO.write(imageBackground, "png", new File("./Hintergrund.png"));
		} catch (Exception e) {
			// TODO: handle exception
		}
    }
    
    
    
//    private void paintBackground(Graphics2D g) {
//    	for (int x = 0; x < background.length; x++) {
//			for (int y = 0; y < background[0].length; y++) {
//				g.drawImage(IMAGEFLOOR.getSubimage(background[x][y][0], background[x][y][1], textureLength, textureLength), x*textureLength, y*textureLength, textureLength, textureLength, null);
//			}
//		}
//    }
    
    private void paintEntities(Graphics2D g) {
    	paintObstacle(g);
    	paintSheep(g);
    	paintDog(g);
    	paintPowerUp(g);
    }
    
    private void paintSheep(Graphics2D g) {
    	if (level.getSheepList() != null) {
    		for (IEntity sheep : level.getSheepList()) {
        		g.drawImage(IMAGESHEEP.getSubimage(COORDSSHEEP[sheep.getSpritePos()][0], COORDSSHEEP[sheep.getSpritePos()][1], textureLength, textureLength), sheep.getPosX(), sheep.getPosY(), textureLength, textureLength, null);
    		}
		}
    }
    
    private void paintObstacle(Graphics2D g) {
    	if (level.getObstacleList() != null) {
    		for (IEntity obstacle : level.getObstacleList()) {
        		g.drawImage(IMAGEOBSTACLE.getSubimage(COORDSOBSTACLE[obstacle.getSpritePos()][0], COORDSOBSTACLE[obstacle.getSpritePos()][1], textureLength, textureLength), obstacle.getPosX(), obstacle.getPosY(), textureLength, textureLength, null);
    		}
		}
    }
    
    private void paintDog(Graphics2D g) {
    	if (level.getDogList() != null) {
    		for (IEntity dog : level.getDogList()) {
        		g.drawImage(IMAGEDOGE.getSubimage(COORDSDOGE[dog.getSpritePos()][0], COORDSDOGE[dog.getSpritePos()][1], textureLength, textureLength), dog.getPosX(), dog.getPosY(), textureLength, textureLength, null);
    		}
		}
    }
    
    private void paintPowerUp(Graphics2D g) {
    	if (level.getPowerUpList() != null) {
    		for (IEntity powerUp : level.getPowerUpList()) {
        		g.drawImage(IMAGEPOWERUP.getSubimage(COORDSPOWERUP[powerUp.getSpritePos()][0], COORDSPOWERUP[powerUp.getSpritePos()][1], textureLength, textureLength), powerUp.getPosX(), powerUp.getPosY(), textureLength, textureLength, null);
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