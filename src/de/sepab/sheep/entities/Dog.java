package de.sepab.sheep.entities;

import java.util.LinkedList;


public class Dog extends Entity implements IDog {
	
	private LinkedList<IEntity> sheeps;
	private int barkLength = 0;

    public Dog(int posX, int posY, LinkedList<IEntity> sheeps, int barkLength) {
        super(posX, posY);
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

    
    public void changeSprite(int rotation){
    	switch (rotation) {
		case 0:
			break;
		case 1:
			if (spriteCount >= 0 && spriteCount < 8) {
				this.setSpritePos(4);
			}
			if (spriteCount >= 8 && spriteCount < 16) {
				this.setSpritePos(5);
			}
			if (spriteCount >= 16 && spriteCount < 24) {
				this.setSpritePos(6);
			}
			if (spriteCount >= 24 && spriteCount < 32) {
				this.setSpritePos(7);
			}
			break;
		case 2:
			if (spriteCount >= 0 && spriteCount < 8) {
				this.setSpritePos(8);
			}
			if (spriteCount >= 8 && spriteCount < 16) {
				this.setSpritePos(9);
			}
			if (spriteCount >= 16 && spriteCount < 24) {
				this.setSpritePos(10);
			}
			if (spriteCount >= 24 && spriteCount < 32) {
				this.setSpritePos(11);
			}
			break;
		case 3:
			if (spriteCount >= 0 && spriteCount < 8) {
				this.setSpritePos(12);
			}
			if (spriteCount >= 8 && spriteCount < 16) {
				this.setSpritePos(13);
			}
			if (spriteCount >= 16 && spriteCount < 24) {
				this.setSpritePos(14);
			}
			if (spriteCount >= 24 && spriteCount < 32) {
				this.setSpritePos(15);
			}
			break;
		case 4:
			if (spriteCount >= 0 && spriteCount < 8) {
				this.setSpritePos(0);
			}
			if (spriteCount >= 8 && spriteCount < 16) {
				this.setSpritePos(1);
			}
			if (spriteCount >= 16 && spriteCount < 24) {
				this.setSpritePos(2);
			}
			if (spriteCount >= 24 && spriteCount < 32) {
				this.setSpritePos(3);
			}
			break;
		default:
			break;
		}
    }
}
