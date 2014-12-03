package de.sepab.sheep.view.display;

import javax.swing.JFrame;

import de.sepab.sheep.model.corelogic.IGameBoard;
import de.sepab.sheep.view.menu.IMenu;

public class Display extends JFrame implements IDisplay {
	
	private static JFrame jf = new JFrame ("ShEeP version pre-pre-alpha 0.0.0"); // das Fenster
	
	private IMenu menu;
	private IGameBoard gameBoard;
	private boolean state;
	
	public Display() {
		//
	}
	
	public void update() {
		
	}
	
	public void changeMenuState(boolean state) {
		
	}
	
}
