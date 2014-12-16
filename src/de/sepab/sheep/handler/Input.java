package de.sepab.sheep.handler;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.LinkedList;

import de.sepab.sheep.entities.IDog;
import de.sepab.sheep.entities.IEntity;
import de.sepab.sheep.logic.IMovement;

public class Input implements KeyListener, IInput {

	/*
	 * Mitte:	0
	 * Oben:	1
	 * Rechts:	2
	 * Unten:	3
	 * Links:	4
	 * Bellen:	5
	 */
	
    private IMovement movement;
    private LinkedList<IEntity> dogList;
    
    public Input(IMovement movement, LinkedList<IEntity> dogList) {
    	this.movement = movement;
    	this.dogList = dogList;
    }

    @Override
    public void keyPressed(KeyEvent e) {
    	switch (e.getKeyCode()) {
    	case (KeyEvent.VK_UP):
    		this.movement.move(this.dogList.getFirst(), 1);
    	break;
    	case (KeyEvent.VK_RIGHT):
    		this.movement.move(this.dogList.getFirst(), 2);
    	break;
    	case (KeyEvent.VK_DOWN):
    		this.movement.move(this.dogList.getFirst(), 3);
    	break;
    	case (KeyEvent.VK_LEFT):
    		this.movement.move(this.dogList.getFirst(), 4);
    	break;
    	case (KeyEvent.VK_B):
    		((IDog)this.dogList.getFirst()).bark();
    	break;
    	case (KeyEvent.VK_W):
    		this.movement.move(this.dogList.getLast(), 1);
    	break;
    	case (KeyEvent.VK_D):
    		this.movement.move(this.dogList.getLast(), 2);
    	break;
    	case (KeyEvent.VK_S):
    		this.movement.move(this.dogList.getLast(), 3);
    	break;
    	case (KeyEvent.VK_A):
    		this.movement.move(this.dogList.getLast(), 4);
    	break;
    	case (KeyEvent.VK_ENTER):
    		((IDog)this.dogList.getLast()).bark();
    	break;
    	}
    	this.movement.move(this.dogList.getFirst(), 0);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void keyTyped(KeyEvent e) {
    	// TODO Auto-generated method stub
    	
    }

}