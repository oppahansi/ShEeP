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

import de.sepab.sheep.model.corelogic.IPowerUpHandler;
import de.sepab.sheep.model.entities.IEntity;
import de.sepab.sheep.model.entities.Player;

public class GameBoard extends JPanel implements IGameBoard{
	
    private IPowerUpHandler powerUpHandler;
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
    
    public BufferedImage optimize(BufferedImage img) {
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
    
    public void paintComponent(Graphics gr) {
    	Graphics2D g = (Graphics2D) gr;
    	g.setColor(Color.BLACK);
    	g.fill(g.getClipBounds());
    	g.drawImage(img, 0, 0, null);
    }
    
    public GameBoard() {
    	this.setFocusable(true);
    	img = optimize(load(""));
    	setLayout(null);
    	this.setPreferredSize(new Dimension(640, 480));
    }
}
