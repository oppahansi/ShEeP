package de.sepab.sheep.entities;

import java.util.LinkedList;



public class Dog extends Entity implements IDog {
	
	private LinkedList<IEntity> sheeps;
	private static int fixBarkLength = 0;
	private int barkLength = this.fixBarkLength;

    public Dog(int posX, int posY, int speed, int  PowerUpLife, LinkedList<IEntity> sheeps, int barkLength) {
        super(posX, posY, speed, PowerUpLife);
        this.setSpeed(4);
        this.sheeps = sheeps;
        this.barkLength = barkLength;
        this.spritePeriod = 6;
        this.setSpriteQuarters();
    }
   

    public void bark() {
		this.setSpeed(25);
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
        					((ISheep)i).scare(true,this.getPosX(), this.getPosY());
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
        					((ISheep)i).scare(true,this.getPosX(), this.getPosY());
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
        					((ISheep)i).scare(true,this.getPosX(), this.getPosY());
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
        					((ISheep)i).scare(true,this.getPosX(), this.getPosY());
        				}
        			}
        		}
    		}
    		break;
    	}
    }
    
    public void changeSprite(int rotation){
    	switch (rotation) {
		case 0:
			break;
		case 1:
			this.calculateSprite(4, 5, 6, 7);
			break;
		case 2:
			this.calculateSprite(8, 9, 10, 11);
			break;
		case 3:
			this.calculateSprite(12, 13, 14, 15);
			break;
		case 4:
			this.calculateSprite(0, 1, 2, 3);
			break;
		default:
			break;
		}
    }

	public void checkPowerUpLife() {
		if(this.getPowerUpLife() <= 0) {
			this.resetPowerUpLife();
			this.resetSpeed();
			this.confuse(false);
			this.barkLength = this.fixBarkLength;
		}
	}

}
