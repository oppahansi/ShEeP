package de.sepab.sheep.view.game;


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



import java.util.LinkedList;


import de.sepab.sheep.model.entities.IEntity;


public class GameBoard extends JPanel implements IGameBoard{
	
	
    private BufferedImage img;
    
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
    
    public void paintComponent(Graphics gr) {
    	Graphics2D g = (Graphics2D) gr;
    	g.setColor(Color.BLACK);
//    	g.fill(g.getClipBounds());
    	g.drawImage(img, 0, 0, 640,480,null);
    }
    
    public GameBoard() {
    	this.setFocusable(true);
    	setLayout(null);
    	this.setPreferredSize(new Dimension(640, 480));
    }
    
    @Override
	public void setGameBoard(LinkedList<IEntity> gameBoard) {
		// TODO Auto-generated method stub
		
	}
}
