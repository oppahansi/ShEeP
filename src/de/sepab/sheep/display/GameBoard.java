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
import javax.swing.JPanel;

import de.sepab.sheep.entities.IEntity;
import de.sepab.sheep.entities.Obstacle;
import de.sepab.sheep.handler.AI;
import de.sepab.sheep.handler.IInput;
import de.sepab.sheep.handler.Input;
import de.sepab.sheep.logic.Collision;
import de.sepab.sheep.logic.ILevel;
import de.sepab.sheep.logic.IRandomGenerator;
import de.sepab.sheep.logic.Level;
import de.sepab.sheep.logic.Movement;

@SuppressWarnings("serial")
public class GameBoard extends JPanel{
	
	private static final String SHEEP = "/de/sepab/sheep/model/gfx/sheep_walk32x32.png";
	private static final String DOGE = "/de/sepab/sheep/model/gfx/wolf32x32.png";
	private static final String OBSTACLE = "/de/sepab/sheep/model/gfx/fence.png";
	private static final String FLOOR = "/de/sepab/sheep/model/gfx/grass.png";
	private static final String POWERUP = "/de/sepab/sheep/model/gfx/wolf.png";
	private static final String SINGLEPLAYERMAP1 = "/de/sepab/sheep/model/gfx/map1SinglePlayer.png"; //<--

	private static final BufferedImage IMAGESHEEP = optimize(load(SHEEP));
	private static final BufferedImage IMAGEDOGE = optimize(load(DOGE));
	private static final BufferedImage IMAGEOBSTACLE = optimize(load(OBSTACLE));
	private static final BufferedImage IMAGEFLOOR = optimize(load(FLOOR));
	private static final BufferedImage IMAGEPOWERUP = optimize(load(POWERUP));
	private BufferedImage IMAGEMAP;
	private BufferedImage imageBackground;
	    
	private static final int COORDSSHEEP[][] = {{16,16},{80,16}, {144, 16},{208,16},
												{16,80},{80,80}, {144, 80},{208,80},
												{16,144},{80,144}, {144, 144},{208,144},
												{16,208},{80,208}, {144, 208},{208,208},
												};
	private static final int COORDSDOGE[][] = {{0,8}, {32,8}, {64, 8}, {96,8},
											   {0,96}, {32,96}, {64, 96}, {96,96},
											   {0,136}, {32,136}, {64, 136}, {96,136},
											   {0,224}, {32,224}, {64, 224}, {96,224},};
	
	
	
	private static final int COORDSOBSTACLE[][] = {{0,0},{32,0},{64,0}, //fence
	    										  {0,32},{32,32},{64,32},
	    										  {0,64},{32,64},{64,64},
	    										  {0,96},{32,96},{64,96},
	    										  {0,128},{32,128},{64,128},
	    										  
	    										  {96,0},{128,0},{160,0},
	    										  {96,32},{128,32},{160,32},
	    										  {96,64},{128,64},{160,64},
	    										  {96,96},{128,96},{160,96},
	    										  {96,128},{128,128},{160,128},
												  };
	private static final int COORDSFLOOR[][] = {{0,160},{32,160},{64,160}};
	private static final int COORDSPOWERUP[][] = {{0,0}};
	
	private static final int SHEEPCOLOR[][] = {{255,255,255}};
	private static final int DOGCOLOR[][] = {{105,65,20}};
	private static final int OBSTACLECOLOR[][] = {{145,110,30}, //fence
												   {215,205,0}, //wheat
												   	{0,30,215}, //water
												 {205,200,180}, //1x1 obstacles
												   	};

	private IRandomGenerator randomGenerator;
	private ILevel level;
	
	
	private int textureLength = 32; //tl = texture length
	private int x = 40, y=30;
//	private int background[][][] = new int[x][y][2];
	
	
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
				g.drawImage(IMAGEFLOOR.getSubimage(COORDSFLOOR[i][0], COORDSFLOOR[i][1], textureLength, textureLength), x*32, y*32, null);
			}
		}
    	addObstaclesToBackground(g);
    		ImageIO.write(imageBackground, "png", new File("./Hintergrund.png"));
		} catch (Exception e) {
			// TODO: handle exception
		}
    }
    
    public void addObstaclesToBackground(Graphics g){
    	for (IEntity o : this.level.getObstacleList()) {
			g.drawImage(IMAGEOBSTACLE.getSubimage(COORDSOBSTACLE[o.getSpritePos()][0], COORDSOBSTACLE[o.getSpritePos()][1], textureLength, textureLength), o.getPosX(), o.getPosY(), null);
		}
    }
    
    public void loadMap(int map) {
    	Menu.level = new Level();
    	this.level = Menu.level;
    	switch (map) {
		case 1:
			IMAGEMAP = optimize(load(SINGLEPLAYERMAP1));
			break;

		default:
			IMAGEMAP = optimize(load(SINGLEPLAYERMAP1));
			break;
		}
    	for (int x = 0; x < this.x; x++) {
			for (int y = 0; y < this.y; y++) {
				 int rgb = IMAGEMAP.getRGB(x, y);
				 Color c = new Color(rgb);
				 if (c.getRed() == DOGCOLOR[0][0] && c.getGreen() == DOGCOLOR[0][1] && c.getBlue() == DOGCOLOR[0][2]) {
					level.addDog(x*32, y*32);
				 }
				 if (c.getRed() == SHEEPCOLOR[0][0] && c.getGreen() == SHEEPCOLOR[0][1] && c.getBlue() == SHEEPCOLOR[0][2]) {
					level.addSheep(x*32, y*32);	
				 }
				 if (c.getRed() == OBSTACLECOLOR[0][0] && c.getGreen() == OBSTACLECOLOR[0][1] && c.getBlue() == OBSTACLECOLOR[0][2]) {
					 boolean top = false, right = false, bottom = false, left = false;
					if (y - 1 >= 0) {
						top = checkForColor(x, y - 1, OBSTACLECOLOR, 0);
					}
					if (x + 1 <= this.x) {
						right = checkForColor(x + 1, y, OBSTACLECOLOR, 0);
					}
					if (y + 1 <= this.y) {
						bottom = checkForColor(x, y + 1, OBSTACLECOLOR, 0);
					}
					if (x - 1 >= 0) {
						left = checkForColor(x - 1, y, OBSTACLECOLOR, 0);
					}
					addObstacleCage(x, y, top, right, bottom, left);
				}
				 if (c.getRed() == OBSTACLECOLOR[1][0] && c.getGreen() == OBSTACLECOLOR[1][1] && c.getBlue() == OBSTACLECOLOR[1][2]) {
					 boolean top = false, topRight = false, right = false, bottomRight = false, bottom = false, bottomLeft = false, left = false, topLeft = false;
					if (y - 1 >= 0) {
						top = checkForColor(x, y - 1, OBSTACLECOLOR, 1);
					}
					if (x + 1 <= this.x && y - 1 >= 0) {
						topRight = checkForColor(x + 1, y - 1, OBSTACLECOLOR, 1);
					}
					if (x + 1 <= this.x) {
						right = checkForColor(x + 1, y, OBSTACLECOLOR, 1);
					}
					if (x + 1 <= this.x && y + 1 <= this.y) {
						bottomRight = checkForColor(x + 1, y + 1, OBSTACLECOLOR, 1);
					}
					if (y + 1 <= this.y) {
						bottom = checkForColor(x, y + 1, OBSTACLECOLOR, 1);
					}
					if (x - 1 >= 0 && y + 1 <= this.y) {
						bottomLeft = checkForColor(x - 1, y + 1, OBSTACLECOLOR, 1);
					}
					if (x - 1 >= 0) {
						left = checkForColor(x - 1, y, OBSTACLECOLOR, 1);
					}
					if (x - 1 >= 0 && y - 1 >= 0) {
						topLeft = checkForColor(x - 1, y - 1, OBSTACLECOLOR, 1);
					}
					addObstacleCage(x, y, top, right, bottom, left);
				}
				 
			}
		}
    	Menu.level = level;
    	Menu.collision = new Collision(Menu.level.getDogList(), Menu.level.getSheepList(), Menu.level.getPowerUpList(), Menu.level.getObstacleList(), 1280, 960);
    	Menu.movement = new Movement(Menu.collision);
    	Menu.ai = new AI(100, 5, Menu.level.getSheepList(), Menu.movement, Menu.collision);
    	Menu.input = new Input(Menu.movement, Menu.level.getDogList());
    	this.addKeyListener((Input) Menu.input);
    	Menu.level.getReferences(Menu.ai, this, Menu.timer, Menu.input);

    }
    
    public void addObstaclesWheat(int x, int y, boolean top, boolean topRight, boolean right, boolean bottomRight, boolean bottom, boolean bottomLeft, boolean left, boolean topLeft){
    	if (top == false && right == false && bottom == false && left == false) {
			System.out.print("ERROR:There must be at least 2 wheat near each other.");
		}else
		if (top == true && right == true && bottom == false && left == false) {
			level.addObstacle(x*32, y*32, 27);
		}else
		if (top == false && right == true && bottom == true && left == false) {
			level.addObstacle(x*32, y*32, 21);
		}else
		if (top == false && right == true && bottom == true && left == true) {
			level.addObstacle(x*32, y*32, 22);
		}else
		if (top == false && right == false && bottom == true && left == true) {
			level.addObstacle(x*32, y*32, 23);
		}else
		if (top == true && right == true && bottom == true && left == false) {
			level.addObstacle(x*32, y*32, 24);
		}else
		if (top == true && right == true && bottom == true && left == true) {
			level.addObstacle(x*32, y*32, 25);
		}
    }
    
    public void addObstacleCage(int x, int y, boolean top, boolean right, boolean bottom, boolean left){
    	if (top == false && right == false && bottom == false && left == false) {
			System.out.print("ERROR:There must be at least 2 fences near each other.");
		}else
		if (top == false && right == true && bottom == false && left == false) {
			level.addObstacle(x*32, y*32, 0);
		}else
		if (top == false && right == true && bottom == false && left == true) {
			level.addObstacle(x*32, y*32, 1);	
		}else	
		if (top == false && right == false && bottom == false && left == true) {
			level.addObstacle(x*32, y*32, 2);	
		}else	
		if (top == true && right == false && bottom == false && left == false) {
			level.addObstacle(x*32, y*32, 3);
		}else
		if (top == true && right == false && bottom == true && left == false) {
			level.addObstacle(x*32, y*32, 4);
		}else
		if (top == false && right == false && bottom == true && left == false) {
			level.addObstacle(x*32, y*32, 5);
		}else
		if (top == false && right == true && bottom == true && left == false) {
			level.addObstacle(x*32, y*32, 6);
		}else
		if (top == false && right == true && bottom == true && left == true) {
			level.addObstacle(x*32, y*32, 7);
		}else
		if (top == false && right == false && bottom == true && left == true) {
			level.addObstacle(x*32, y*32, 8);
		}else
		if (top == true && right == true && bottom == true && left == false) {
			level.addObstacle(x*32, y*32, 9);
		}else
		if (top == true && right == true && bottom == true && left == true) {
			level.addObstacle(x*32, y*32, 10);
		}else
		if (top == true && right == false && bottom == true && left == true) {
			level.addObstacle(x*32, y*32, 11);
		}else
		if (top == true && right == true && bottom == false && left == false) {
			level.addObstacle(x*32, y*32, 12);
		}else
		if (top == true && right == true && bottom == false && left == true) {
			level.addObstacle(x*32, y*32, 13);
		}else
		if (top == true && right == false && bottom == false && left == true) {
			level.addObstacle(x*32, y*32, 14);
		}
    	
			
    }
    
    
    
    private boolean checkForColor(int x, int y, int[][] color, int position){
    	int temprgb = IMAGEMAP.getRGB(x, y);
    	Color tempColor = new Color(temprgb);
		if (tempColor.getRed() == color[position][0] && tempColor.getGreen() == color[position][1] && tempColor.getBlue() == color[position][2]) {
			return true;
		}
    	return false;
    }
    
    
//    private void paintBackground(Graphics2D g) {
//    	for (int x = 0; x < background.length; x++) {
//			for (int y = 0; y < background[0].length; y++) {
//				g.drawImage(IMAGEFLOOR.getSubimage(background[x][y][0], background[x][y][1], textureLength, textureLength), x*textureLength, y*textureLength, textureLength, textureLength, null);
//			}
//		}
//    }
    
    private void paintEntities(Graphics2D g) {
//    	paintObstacle(g);
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