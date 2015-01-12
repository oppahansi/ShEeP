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
    private int key;
    private boolean dog1[] = new boolean[6], dog2[] = new boolean[6];
	private IJukeBox jukeBox;
    
    public Input(IMovement movement, LinkedList<IEntity> dogList) {
    	this.movement = movement;
    	this.dogList = dogList;
		 jukeBox = new JukeBox("/de/sepab/sheep/model/sfx/bark.wav");
    }
    
    public void makeTurn(){
    	if (!dogList.isEmpty()) {
    		if (dog1[1] == true) {
        		this.movement.move(this.dogList.getFirst(), 1);
    		}else 
    		if (dog1[2] == true) {
    			this.movement.move(this.dogList.getFirst(), 2);
    		}else
    		if (dog1[3] == true) {
    			this.movement.move(this.dogList.getFirst(), 3);
    		}else
    		if (dog1[4] == true) {
    			this.movement.move(this.dogList.getFirst(), 4);
    		}else
    		if (dog1[0] == true) {
    			this.movement.move(this.dogList.getFirst(), 0);
    		}
        	if (dog1[5] == true) {
        		((IDog)this.dogList.getFirst()).bark();
    		}
        	if (dog2[1] == true) {
        		this.movement.move(this.dogList.getLast(), 1);
    		}else 
    		if (dog2[2] == true) {
    			this.movement.move(this.dogList.getLast(), 2);
    		}else
    		if (dog2[3] == true) {
    			this.movement.move(this.dogList.getLast(), 3);
    		}else
    		if (dog2[4] == true) {
    			this.movement.move(this.dogList.getLast(), 4);
    		}else
    		if (dog2[0] == true) {
    			this.movement.move(this.dogList.getLast(), 0);
    		}
        	if (dog2[5] == true) {
        		((IDog)this.dogList.getLast()).bark();
    		}
		}	
    }

    @Override
    public void keyPressed(KeyEvent e) {
    	key = e.getKeyCode();
//    	switch (e.getKeyCode()) {
//    	case (KeyEvent.VK_UP):
//    		this.movement.move(this.dogList.getFirst(), 1);
//    	break;
//    	case (KeyEvent.VK_RIGHT):
//    		this.movement.move(this.dogList.getFirst(), 2);
//    	break;
//    	case (KeyEvent.VK_DOWN):
//    		this.movement.move(this.dogList.getFirst(), 3);
//    	break;
//    	case (KeyEvent.VK_LEFT):
//    		this.movement.move(this.dogList.getFirst(), 4);
//    	break;
//    	case (KeyEvent.VK_B):
//    		((IDog)this.dogList.getFirst()).bark();
//    	break;
//    	case (KeyEvent.VK_W):
//    		this.movement.move(this.dogList.getLast(), 1);
//    	break;
//    	case (KeyEvent.VK_D):
//    		this.movement.move(this.dogList.getLast(), 2);
//    	break;
//    	case (KeyEvent.VK_S):
//    		this.movement.move(this.dogList.getLast(), 3);
//    	break;
//    	case (KeyEvent.VK_A):
//    		this.movement.move(this.dogList.getLast(), 4);
//    	break;
//    	case (KeyEvent.VK_ENTER):
//    		((IDog)this.dogList.getLast()).bark();
//    	break;
//    	}
//    	this.movement.move(this.dogList.getFirst(), 0);
    	switch (e.getKeyCode()) {
    	case (KeyEvent.VK_UP):
    		dog1[1] = true;
    	break;
    	case (KeyEvent.VK_RIGHT):
    		dog1[2] = true;
    	break;
    	case (KeyEvent.VK_DOWN):
    		dog1[3] = true;
    	break;
    	case (KeyEvent.VK_LEFT):
    		dog1[4] = true;
    	break;
    	case (KeyEvent.VK_B):
    		dog1[5] = true;
			if(!jukeBox.isRunning()) {
				jukeBox.play();
			}
    	break;
    	case (KeyEvent.VK_W):
    		if (this.dogList.size()>1) {
    			dog2[1] = true;
			}
    	break;
    	case (KeyEvent.VK_D):
    		if (this.dogList.size()>1) {
    			dog2[2] = true;
			}
    	break;
    	case (KeyEvent.VK_S):
    		if (this.dogList.size()>1) {
    			dog2[3] = true;
			}
    	break;
    	case (KeyEvent.VK_A):
    		if (this.dogList.size()>1) {
    			dog2[4] = true;
			}
    	break;
    	case (KeyEvent.VK_ENTER):
    		if (this.dogList.size()>1) {
    			dog2[5] = true;
				if(!jukeBox.isRunning()) {
					jukeBox.play();
				}
			}
    	break;
    	}
    	dog1[0] = true;
    	if (this.dogList.size()>1) {
    		dog2[0] = true;
    	}
    }

    @Override
    public void keyReleased(KeyEvent e) {
    	switch (e.getKeyCode()) {
    	case (KeyEvent.VK_UP):
    		dog1[1] = false;
    	break;
    	case (KeyEvent.VK_RIGHT):
    		dog1[2] = false;
    	break;
    	case (KeyEvent.VK_DOWN):
    		dog1[3] = false;
    	break;
    	case (KeyEvent.VK_LEFT):
    		dog1[4] = false;
    	break;
    	case (KeyEvent.VK_B):
    		dog1[5] = false;
    	break;
    	case (KeyEvent.VK_W):
    		dog2[1] = false;
    	break;
    	case (KeyEvent.VK_D):
    		dog2[2] = false;
    	break;
    	case (KeyEvent.VK_S):
    		dog2[3] = false;
    	break;
    	case (KeyEvent.VK_A):
    		dog2[4] = false;
    	break;
    	case (KeyEvent.VK_ENTER):
    		dog2[5] = false;
    	break;
    	}
        // TODO Auto-generated method stub

    }

    @Override
    public void keyTyped(KeyEvent e) {
    	// TODO Auto-generated method stub
    	
    }

}