package de.sepab.sheep.handler;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class InputHandler implements KeyListener, IInputhandler {
	
	private int[] buffer = new int[2];
	boolean locked = false;
	
	public int[] getBuffer() {
		int bufferPlayerA = this.buffer[0];
		int bufferPlayerB = this.buffer[1];
		this.buffer[0] = 0;
		this.buffer[1] = 0;
		this.locked = false;
		int[] tmpBuffer = {bufferPlayerA, bufferPlayerB};
		return tmpBuffer;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(this.locked == false) {
			int key = e.getKeyCode();
	    	switch(key) {
	    	case(KeyEvent.VK_UP):		this.buffer[0] = 1;	break;
	    	case(KeyEvent.VK_RIGHT):	this.buffer[0] = 2;	break;
	    	case(KeyEvent.VK_DOWN):		this.buffer[0] = 3;	break;
	    	case(KeyEvent.VK_LEFT):		this.buffer[0] = 4;	break;
	    	case(KeyEvent.VK_W):		this.buffer[1] = 1;	break;
	    	case(KeyEvent.VK_D):		this.buffer[1] = 2;	break;
	    	case(KeyEvent.VK_S):		this.buffer[1] = 3;	break;
	    	case(KeyEvent.VK_A):		this.buffer[1] = 4;	break;
	    	}
	    	this.locked = true;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		if(this.locked == false) {
			int key = e.getKeyCode();
	    	switch(key) {
	    	case(KeyEvent.VK_UP):		this.buffer[0] = 1;	break;
	    	case(KeyEvent.VK_RIGHT):	this.buffer[0] = 2;	break;
	    	case(KeyEvent.VK_DOWN):		this.buffer[0] = 3;	break;
	    	case(KeyEvent.VK_LEFT):		this.buffer[0] = 4;	break;
	    	case(KeyEvent.VK_W):		this.buffer[1] = 1;	break;
	    	case(KeyEvent.VK_D):		this.buffer[1] = 2;	break;
	    	case(KeyEvent.VK_S):		this.buffer[1] = 3;	break;
	    	case(KeyEvent.VK_A):		this.buffer[1] = 4;	break;
	    	}
	    	this.locked = true;
		}
	}
	
}
