package de.sepab.sheep.view.game;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;








import javax.swing.Timer;

import java.util.Iterator;
import java.util.LinkedList;








import de.sepab.sheep.model.corelogic.DataLoader;
import de.sepab.sheep.model.corelogic.IDataLoader;
import de.sepab.sheep.model.corelogic.IRandomGenerator;
import de.sepab.sheep.model.corelogic.RandomGenerator;
import de.sepab.sheep.model.entities.IEntity;


public class GameBoard extends JPanel implements IGameBoard{
	
	private IDataLoader dl = new DataLoader();
	private IRandomGenerator rg = new RandomGenerator();
	private de.sepab.sheep.model.corelogic.IGameBoard modelgb = new de.sepab.sheep.model.corelogic.GameBoard();
	
	private int[][] coordsSheep = dl.getCoords("sheep"), 
			coordsDog = dl.getCoords("dog"), 
			coordsObstacle = dl.getCoords("obstacle"), 
			coordsFloor = dl.getCoords("floor"), 
			coordsPowerUp = dl.getCoords("powerup");
	
	private BufferedImage imgSheep = dl.getImage("sheep"), 
				  imgDog = dl.getImage("dog"), 
				  imgObstacle = dl.getImage("obstacle"), 
				  imgFloor = dl.getImage("floor"), 
				  imgPowerUp = dl.getImage("powerup");
	private int tl = 32; //tl = texture length
	
	
    
	private final int spriteLength = 32;
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
    
    public void Update(de.sepab.sheep.model.corelogic.IGameBoard igb, IDataLoader dl, IRandomGenerator rg) {
    	this.dl = dl;
    	this.rg = rg;
    	this.modelgb = igb;
    }
    
    public GameBoard(de.sepab.sheep.model.corelogic.IGameBoard igb, IDataLoader dl, IRandomGenerator rg) {
    	this.setFocusable(true);
    	setLayout(null);
    	this.setPreferredSize(new Dimension(640, 480));
    	Update(igb, dl, rg);
    	shuffle();
    }
    
    public void shuffle() {
    	for (int x = 0; x < 20; x++) {
			for (int y = 0; y < 15; y++) {
				int i = rg.generateRandomNumber(0, 2);//2 ist die anzahl an floor texturen
				background[x][y][0] = coordsFloor[i][0];
				background[x][y][1] = coordsFloor[i][1];
			}
		}
    }
    
    
    
    public void paintBackground(Graphics2D g) {
    	for (int x = 0; x < background.length; x++) {
			for (int y = 0; y < background[0].length; y++) {
				g.drawImage(imgFloor.getSubimage(background[x][y][0], background[x][y][1], tl, tl), x*tl, y*tl, tl, tl, null);
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
    	if (modelgb.getSheep() != null) {
    		for (IEntity sheep : modelgb.getSheep()) {
        		int[] sprite = sheep.getSprite();
        		g.drawImage(imgSheep.getSubimage(sprite[0], sprite[1], tl, tl), sheep.getPosX(), sheep.getPosY(), tl, tl, null);		
    		}
		}
    }
    
    public void paintObstacle(Graphics2D g) {
////    	if (modelgb.getObstacle() != null) {
//    		for (IEntity obstacle : modelgb.getObstacle()) {
//        		int[] sprite = obstacle.getSprite();
//        		System.out.print(obstacle.getPosX() + " " + obstacle.getPosY());
//        		g.drawImage(imgObstacle.getSubimage(sprite[0], sprite[1], tl, tl), obstacle.getPosX(), obstacle.getPosY(), tl, tl, null);		
//    		}
////    	}
    	
    }
    
    public void paintDog(Graphics2D g) {
//    	if (modelgb.getSheep() != null) {
    		for (IEntity dog : modelgb.getDog()) {
        		int[] sprite = dog.getSprite();
        		g.drawImage(imgDog.getSubimage(sprite[0], sprite[1], tl*2, tl*2), dog.getPosX(), dog.getPosY(), tl*2, tl*2, null);		
        		System.out.print(dog.getPosX() + " " + dog.getPosY());
    		}
//    	}
    	
    }
    
    public void paintPowerUp(Graphics2D g) {
    	if (modelgb.getSheep() != null) {
    		for (IEntity powerUp : modelgb.getPowerUp()) {
        		int[] sprite = powerUp.getSprite();
        		g.drawImage(imgPowerUp.getSubimage(sprite[0], sprite[1], tl, tl), powerUp.getPosX(), powerUp.getPosY(), tl, tl, null);		
    		}
    	}	
    }
    
    
    @Override
	public void setGameBoard(LinkedList<IEntity> gameBoard) {
		// TODO Auto-generated method stub
		
	}
}
