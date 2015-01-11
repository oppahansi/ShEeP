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
import java.util.LinkedList;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import de.sepab.sheep.entities.Cage;
import de.sepab.sheep.entities.IEntity;
import de.sepab.sheep.entities.Obstacle;
import de.sepab.sheep.handler.AI;
import de.sepab.sheep.handler.IInput;
import de.sepab.sheep.handler.Input;
import de.sepab.sheep.logic.Collision;
import de.sepab.sheep.logic.ILevel;
import de.sepab.sheep.logic.Level;
import de.sepab.sheep.logic.Movement;
import de.sepab.sheep.logic.RandomGenerator;

@SuppressWarnings("serial")
public class GameBoard extends JPanel{
	
	private static final String SHEEP = "/de/sepab/sheep/model/gfx/sheep_walk32x32.png";
	private static final String DOGE = "/de/sepab/sheep/model/gfx/wolf32x32.png";
	private static final String OBSTACLE = "/de/sepab/sheep/model/gfx/fence.png";
	private static final String FLOOR = "/de/sepab/sheep/model/gfx/grass.png";
	private static final String POWERUP = "/de/sepab/sheep/model/gfx/powerup.png";
	private static final String SINGLEPLAYERMAP1 = "/de/sepab/sheep/model/gfx/map1SinglePlayer.png"; 
	private static final String SINGLEPLAYERMAP2 = "/de/sepab/sheep/model/gfx/map2SinglePlayer.png"; 
	private static final String SINGLEPLAYERMAP3 = "/de/sepab/sheep/model/gfx/map3SinglePlayer.png"; 
	private static final String MULTIPLAYERMAP1 = "/de/sepab/sheep/model/gfx/map1MultiPlayer.png"; 
	private static final String MULTIPLAYERMAP2 = "/de/sepab/sheep/model/gfx/map2MultiPlayer.png"; 

	private static final BufferedImage IMAGESHEEP = optimize(load(SHEEP));
	private static final BufferedImage IMAGEDOGE = optimize(load(DOGE));
	private static final BufferedImage IMAGEOBSTACLE = optimize(load(OBSTACLE));
	private static final BufferedImage IMAGEFLOOR = optimize(load(FLOOR));
	private static final BufferedImage IMAGEPOWERUP = optimize(load(POWERUP));
	
	private static final BufferedImage IMAGESINGLEPLAYERMAP1 = optimize(load(SINGLEPLAYERMAP1));
	private static final BufferedImage IMAGESINGLEPLAYERMAP2 = optimize(load(SINGLEPLAYERMAP2));
	private static final BufferedImage IMAGESINGLEPLAYERMAP3 = optimize(load(SINGLEPLAYERMAP3));
	private static final BufferedImage IMAGEMULTIPLAYERMAP1 = optimize(load(MULTIPLAYERMAP1));
	private static final BufferedImage IMAGEMULTIPLAYERMAP2 = optimize(load(MULTIPLAYERMAP1));
	
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
	    										  
	    										  {96,0},{128,0},{160,0}, //weat
	    										  {96,32},{128,32},{160,32},
	    										  {96,64},{128,64},{160,64},
	    										  {96,96},{128,96},{160,96},
	    										  {96,128},{128,128},{160,128},
												  
	    										  {192,0},{224,0},{256,0}, //water
	    										  {192,32},{224,32},{256,32},
	    										  {192,64},{224,64},{256,64},
	    										  {192,96},{224,96},{256,96},
	    										  {192,128},{224,128},{256,128},	
	    										  {192,160},{224,160},{256,160},
	    										  
	    										  {96,160},{128,160},{160,160}, //1x1 obstacles
	};
	private static final int COORDSFLOOR[][] = {{0,160},{32,160},{64,160}};
	private static final int COORDSPOWERUP[][] = {{0,0}};

	
	private static final int SHEEPCOLOR[][] = {{255,255,255}};
	private static final int DOGCOLOR[][] = {{105,65,20}};
	private static final int OBSTACLECOLOR[][] = {{145,110,30}, //fence
												   {215,205,0}, //wheat
												   	{0,30,215}, //water
												 {185,180,160}, //1x1 obstacles
												   	};
	private static final int CAGECOLOR[][] = {{0,200,0}};

	private ILevel level;
	private Menu menu;
	
	
	private int textureLength = 32; //tl = texture length
	private int x = 40, y=30;
	private int[][] cages = new int[this.x][this.y];
//	private int background[][][] = new int[x][y][2];
	
	
    public void paintComponent(Graphics gr) {
    	Graphics2D g = (Graphics2D) gr;
    	g.setColor(Color.WHITE);
    	g.fill(g.getClipBounds());
//    	
//    	g.drawImage(imgSheep, 0, 0, 640,480,null);
    	
//    	paintBackground(g);
    	if (imageBackground != null) {
    		g.drawImage(imageBackground,0,0, null);
		}
    	paintEntities(g);
    }
    
    public void Update(ILevel level) {
    	this.level = level;
    }
    
    public GameBoard(ILevel level, IInput input, Menu menu) {
    	addKeyListener((Input)input);
    	this.setFocusable(true);
    	setLayout(null);
    	this.setPreferredSize(new Dimension(1280, 200));
    	this.level = level;
    	this.menu = menu;
    }
    
    public void shuffle() {
    	try{
    		
    	imageBackground = new BufferedImage(1280, 960, BufferedImage.TYPE_INT_RGB);
    	Graphics g = imageBackground.getGraphics();
    	for (int x = 0; x < this.x; x++) {
			for (int y = 0; y < this.y; y++) {
				int i = RandomGenerator.getRandomNumber(0, 2);//2 ist die anzahl an floor texturen
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
    
    public void loadMap(int map, int modus) {
    	level.resetLevel();

		addPowerUps();
    	switch (map) {
		case 0:
			IMAGEMAP = optimize(load(SINGLEPLAYERMAP1));
			break;
		case 1:
			IMAGEMAP = optimize(load(SINGLEPLAYERMAP2));
			break;
		case 2:
			IMAGEMAP = optimize(load(SINGLEPLAYERMAP3));
			break;
		case 3:
			IMAGEMAP = optimize(load(MULTIPLAYERMAP1));
			break;
		case 4:
			IMAGEMAP = optimize(load(MULTIPLAYERMAP2));
			break;
		default:
			IMAGEMAP = optimize(load(SINGLEPLAYERMAP1));
			break;
		}
    	cages = new int[this.y][this.x];
    	for (int y = 0; y < this.x; y++) {
			for (int x = 0; x < this.y; x++) {
				 int rgb = IMAGEMAP.getRGB(y, x);
				 Color c = new Color(rgb);
				 if (c.getRed() == DOGCOLOR[0][0] && c.getGreen() == DOGCOLOR[0][1] && c.getBlue() == DOGCOLOR[0][2]) {
					level.addDog(y*32, x*32, menu.getDog().getSpeed(), menu.getDog().getPowerUpLife(), menu.getDog().getBarkLength());
				 }
				 if (c.getRed() == SHEEPCOLOR[0][0] && c.getGreen() == SHEEPCOLOR[0][1] && c.getBlue() == SHEEPCOLOR[0][2]) {
					level.addSheep(y*32, x*32, menu.getSheep().getSpeed(), menu.getSheep().getPowerUpLife(), menu.getSheep().getScareSpeed());
				 }
				 if (c.getRed() == OBSTACLECOLOR[0][0] && c.getGreen() == OBSTACLECOLOR[0][1] && c.getBlue() == OBSTACLECOLOR[0][2]) {
					 boolean top = false, right = false, bottom = false, left = false;
					if (x - 1 >= 0) {
						top = checkForColor(y, x - 1, OBSTACLECOLOR, 0);
					}
					if (y + 1 < this.x) {
						right = checkForColor(y + 1, x, OBSTACLECOLOR, 0);
					}
					if (x + 1 < this.y) {
						bottom = checkForColor(y, x + 1, OBSTACLECOLOR, 0);
					}
					if (y - 1 >= 0) {
						left = checkForColor(y - 1, x, OBSTACLECOLOR, 0);
					}
					addObstacleCage(y, x, top, right, bottom, left);
				}
				 if (c.getRed() == OBSTACLECOLOR[1][0] && c.getGreen() == OBSTACLECOLOR[1][1] && c.getBlue() == OBSTACLECOLOR[1][2]) {
					 boolean top = false, topRight = false, right = false, bottomRight = false, bottom = false, bottomLeft = false, left = false, topLeft = false;
					if (x - 1 >= 0) {
						top = checkForColor(y, x - 1, OBSTACLECOLOR, 1);
					}
					if (y + 1 < this.x && x - 1 >= 0) {
						topRight = checkForColor(y + 1, x - 1, OBSTACLECOLOR, 1);
					}
					if (y + 1 < this.x) {
						right = checkForColor(y + 1, x, OBSTACLECOLOR, 1);
					}
					if (y + 1 < this.x && x + 1 <= this.y) {
						bottomRight = checkForColor(y + 1, x + 1, OBSTACLECOLOR, 1);
					}
					if (x + 1 < this.y) {
						bottom = checkForColor(y, x + 1, OBSTACLECOLOR, 1);
					}
					if (y - 1 >= 0 && x + 1 < this.y) {
						bottomLeft = checkForColor(y - 1, x + 1, OBSTACLECOLOR, 1);
					}
					if (y - 1 >= 0) {
						left = checkForColor(y - 1, x, OBSTACLECOLOR, 1);
					}
					if (y - 1 >= 0 && x - 1 >= 0) {
						topLeft = checkForColor(y - 1, x - 1, OBSTACLECOLOR, 1);
					}
					addObstaclesWheat(y, x, top, topRight, right, bottomRight, bottom, bottomLeft, left, topLeft);
				 }
				 if (c.getRed() == OBSTACLECOLOR[2][0] && c.getGreen() == OBSTACLECOLOR[2][1] && c.getBlue() == OBSTACLECOLOR[2][2]) {
					 boolean top = false, topRight = false, right = false, bottomRight = false, bottom = false, bottomLeft = false, left = false, topLeft = false;
					if (x - 1 >= 0) {
						top = checkForColor(y, x - 1, OBSTACLECOLOR, 2);
					}
					if (y + 1 < this.x && x - 1 >= 0) {
						topRight = checkForColor(y + 1, x - 1, OBSTACLECOLOR, 2);
					}
					if (y + 1 < this.x) {
						right = checkForColor(y + 1, x, OBSTACLECOLOR, 2);
					}
					if (y + 1 < this.x && x + 1 < this.y) {
						bottomRight = checkForColor(y + 1, x + 1, OBSTACLECOLOR, 2);
					}
					if (x + 1 < this.y) {
						bottom = checkForColor(y, x + 1, OBSTACLECOLOR, 2);
					}
					if (y - 1 >= 0 && x + 1 < this.y) {
						bottomLeft = checkForColor(y - 1, x + 1, OBSTACLECOLOR, 2);
					}
					if (y - 1 >= 0) {
						left = checkForColor(y - 1, x, OBSTACLECOLOR, 2);
					}
					if (y - 1 >= 0 && x - 1 >= 0) {
						topLeft = checkForColor(y - 1, x - 1, OBSTACLECOLOR, 2);
					}
					addObstaclesWater(y, x, top, topRight, right, bottomRight, bottom, bottomLeft, left, topLeft);
				 }
				 if (c.getRed() == OBSTACLECOLOR[3][0] && c.getGreen() == OBSTACLECOLOR[3][1] && c.getBlue() == OBSTACLECOLOR[3][2]) {
					 int i = RandomGenerator.getRandomNumber(0, 2);
						switch (i) {
						case 0:
							level.addObstacle(y*32, x*32, 48);
							break;
						case 1:
							level.addObstacle(y*32, x*32, 49);
							break;
						case 2:
							level.addObstacle(y*32, x*32, 50);
							break;
						default:
							break;
						}
				}
				 if (c.getRed() == CAGECOLOR[0][0] && c.getGreen() == CAGECOLOR[0][1] && c.getBlue() == CAGECOLOR[0][2]) {
						 cages[y][x] = 1;
				 }
			}
    	}
    	createCages();
    }
    
    public void createCages(){
    	IEntity cage = new Cage(0, 0, 0, 0);
    	for (int y = 0; y < cages[0].length; y++) {
			for (int x = 0; x < cages.length; x++) {
				if (cages[x][y] == 1) {
					cage.setPosX(x);
					cage.setPosY(y);
					cage = createCagesRec(x, y, cage);
					System.out.println(cage.getPosX()+ " " + cage.getPosY() + " " + (((Cage)cage).getPosX2())+ " " + (((Cage)cage).getPosY2()));
					level.addCage(cage.getPosX() * 32, cage.getPosY() * 32, (((Cage)cage).getPosX2())*32, (((Cage)cage).getPosY2())*32);
				}
			}
		}
    }
    
    public IEntity createCagesRec(int x, int y, IEntity cage) {
    	if (x + 1 < this.x) {
			if (cages[x + 1][y] == 1) {
				cages[x][y] = 0;
				cage = createCagesRec(x + 1, y, cage);
			}else{
				if (y + 1 < this.y) {
					if (cages[x][y + 1] == 1) {
						cages[x][y] = 0;
						cage = createCagesRec(x, y + 1, cage);
					} else {
						((Cage)cage).setPosX2(x);
						((Cage)cage).setPosY2(y);
						cages[x][y] = 0;
						return cage;
					}
				} else{
					((Cage)cage).setPosX2(x);
					((Cage)cage).setPosY2(y);
					return cage;
				}
			} 
		} else {
			if (y + 1 < this.y) {
				if (cages[x][y + 1] == 1) {
					cages[x][y] = 0;
					cage = createCagesRec(x, y + 1, cage);
				} else {
					((Cage)cage).setPosX2(x);
					((Cage)cage).setPosY2(y);
					cages[x][y] = 0;
					return cage;
				}
			} else{
				((Cage)cage).setPosX2(x);
				((Cage)cage).setPosY2(y);
				cages[x][y] = 0;
				return cage;
			}
		}
    	return cage;
    }
    
    
    
    public void addObstaclesWater(int x, int y, boolean top, boolean topRight, boolean right, boolean bottomRight, boolean bottom, boolean bottomLeft, boolean left, boolean topLeft){
    	if (top == false && right == false && bottom == false && left == false) {
			System.out.print("ERROR:Incorrect construction.");
		}else
		if (top == false && right == true && bottom == true && left == false) {
			level.addObstacle(x*32, y*32, 36);
		}else
		if (top == false && right == true && bottom == true && left == true) {
			level.addObstacle(x*32, y*32, 37);
		}else
		if (top == false && right == false && bottom == true && left == true) {
			level.addObstacle(x*32, y*32, 38);
		}else
		if (top == true && right == true && bottom == true && left == false) {
			level.addObstacle(x*32, y*32, 39);
		}else
		if (top == true && right == true && bottom == true && left == true) {
			if (topLeft == true && topRight == true && bottomRight == true && bottomLeft == true) {
				int i = RandomGenerator.getRandomNumber(0, 3);
				switch (i) {
				case 0:
					level.addObstacle(x*32, y*32, 40);
					break;
				case 1:
					level.addObstacle(x*32, y*32, 45);
					break;
				case 2:
					level.addObstacle(x*32, y*32, 46);
					break;
				case 3:
					level.addObstacle(x*32, y*32, 47);
					break;
				default:
					break;
				}
				
			}else
			if (topLeft == true && topRight == true && bottomRight == false && bottomLeft == true) {
				level.addObstacle(x*32, y*32, 31);
			}else
			if (topLeft == true && topRight == true && bottomRight == true && bottomLeft == false) {
				level.addObstacle(x*32, y*32, 32);
			}else
			if (topLeft == true && topRight == false && bottomRight == true && bottomLeft == true) {
				level.addObstacle(x*32, y*32, 34);
			}else
			if (topLeft == false && topRight == true && bottomRight == true && bottomLeft == true) {
				level.addObstacle(x*32, y*32, 35);
			}else{
				System.out.print("ERROR: Incorrect construction.");
			}
		}else
		if (top == true && right == false && bottom == true && left == true) {
			level.addObstacle(x*32, y*32, 41);
		}else
		if (top == true && right == true && bottom == false && left == false) {
			level.addObstacle(x*32, y*32, 42);
		}else
		if (top == true && right == true && bottom == false && left == true) {
			level.addObstacle(x*32, y*32, 43);	
		}else
		if (top == true && right == false && bottom == false && left == true) {
			level.addObstacle(x*32, y*32, 44);	
		}else{
			System.out.print("ERROR: Incorrect construction.");
		}
    }
    
    public void addObstaclesWheat(int x, int y, boolean top, boolean topRight, boolean right, boolean bottomRight, boolean bottom, boolean bottomLeft, boolean left, boolean topLeft){
    	if (top == false && right == false && bottom == false && left == false) {
			System.out.print("ERROR:Incorrect construction.");
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
			if (topLeft == true && topRight == true && bottomRight == true && bottomLeft == true) {
				level.addObstacle(x*32, y*32, 25);
			}else
			if (topLeft == true && topRight == true && bottomRight == false && bottomLeft == true) {
				level.addObstacle(x*32, y*32, 16);
			}else
			if (topLeft == true && topRight == true && bottomRight == true && bottomLeft == false) {
				level.addObstacle(x*32, y*32, 17);
			}else
			if (topLeft == true && topRight == false && bottomRight == true && bottomLeft == true) {
				level.addObstacle(x*32, y*32, 19);
			}else
			if (topLeft == false && topRight == true && bottomRight == true && bottomLeft == true) {
				level.addObstacle(x*32, y*32, 20);
			}else{
				System.out.print("ERROR: Incorrect construction.");
			}
		}else
		if (top == true && right == false && bottom == true && left == true) {
			level.addObstacle(x*32, y*32, 26);
		}else
		if (top == true && right == true && bottom == false && left == false) {
			level.addObstacle(x*32, y*32, 27);
		}else
		if (top == true && right == true && bottom == false && left == true) {
			level.addObstacle(x*32, y*32, 28);	
		}else
		if (top == true && right == false && bottom == false && left == true) {
			level.addObstacle(x*32, y*32, 29);	
		}else{
			System.out.print("ERROR: Incorrect construction.");
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

	public void addPowerUps() {
		for (int i = 0; i < 1 ; i++) {
			level.addPowerUp();
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
        		if (powerUp.isVisible()) {
					g.drawImage(IMAGEPOWERUP.getSubimage(COORDSPOWERUP[powerUp.getSpritePos()][0], COORDSPOWERUP[powerUp.getSpritePos()][1], textureLength, textureLength), powerUp.getPosX(), powerUp.getPosY(), textureLength, textureLength, null);
				}
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

	public static BufferedImage getImagesingleplayermap1() {
		return IMAGESINGLEPLAYERMAP1;
	}

	public static BufferedImage getImagesingleplayermap2() {
		return IMAGESINGLEPLAYERMAP2;
	}

	public static BufferedImage getImagesingleplayermap3() {
		return IMAGESINGLEPLAYERMAP3;
	}

	public static BufferedImage getImagemultiplayermap1() {
		return IMAGEMULTIPLAYERMAP1;
	}

	public static BufferedImage getImagemultiplayermap2() {
		return IMAGEMULTIPLAYERMAP2;
	}
    
   
}