package de.sepab.sheep.entities;

import java.util.LinkedList;

public class Dog extends Entity implements IDog {
	
	private LinkedList<IEntity> sheeps;
	private int barkLength = 0;

    public Dog(int posX, int posY, int spritePos, LinkedList<IEntity> sheeps, int barkLength) {
        super(posX, posY, spritePos);
        this.setSpeed(4);
        this.sheeps = sheeps;
        this.barkLength = barkLength;
    }

    public void bark() {
    	int x=0;
    	int y=0;
    	switch(this.getRotation()) {
    	case(1):
    		x=this.getPosX()+barkLength/2;
    		y=this.getPosY();
    		for(int k=x; k>x-barkLength; k--) {
        		for(int j=y; j>y-barkLength; j--) {
        			for(IEntity i : this.sheeps) {
        				if(i.getPosX()==k && i.getPosY()==j) {
        					((ISheep)i).scare(this.getPosX(), this.getPosY());
        				}
        			}
        		}
    		}
    		break;
    	case(2):
    		x=this.getPosX();
    		y=this.getPosY()+barkLength/2;
    		for(int k=x; k<x+barkLength; k++) {
        		for(int j=y; j>y-barkLength; j--) {
        			for(IEntity i : this.sheeps) {
        				if(i.getPosX()==k && i.getPosY()==j) {
        					((ISheep)i).scare(this.getPosX(), this.getPosY());
        				}
        			}
        		}
    		}
    		break;
    	case(3):
    		x=this.getPosX() - barkLength/2;
    		y=this.getPosY();
    		for(int k=x; k<x+barkLength; k++) {
        		for(int j=y; j<y+barkLength; j++) {
        			for(IEntity i : this.sheeps) {
        				if(i.getPosX()==k && i.getPosY()==j) {
        					((ISheep)i).scare(this.getPosX(), this.getPosY());
        				}
        			}
        		}
    		}
    		break;
    	case(4):
    		x=this.getPosX();
    		y=this.getPosY() - barkLength/2;
    		for(int k=x; k>x-barkLength; k--) {
        		for(int j=y; j<y+barkLength; j++) {
        			for(IEntity i : this.sheeps) {
        				if(i.getPosX()==k && i.getPosY()==j) {
        					((ISheep)i).scare(this.getPosX(), this.getPosY());
        				}
        			}
        		}
    		}
    		break;
    	}
    }
    
}
