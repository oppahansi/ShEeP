package de.sepab.sheep.entities;

public class Dog extends Entity {

    public Dog(int posX, int posY) {
        super(posX, posY);
        this.setSpeed(1.0f);
    }

    public void bark() {
    	
    }
    
    public void changeSprite(int rotation){
    	switch (rotation) {
		case 0:
			break;
		case 1:
			if (spriteCount >= 0 && spriteCount < 4) {
				this.setSpritePos(4);
			}
			if (spriteCount >= 4 && spriteCount < 8) {
				this.setSpritePos(5);
			}
			if (spriteCount >= 8 && spriteCount < 12) {
				this.setSpritePos(6);
			}
			if (spriteCount >= 12 && spriteCount < 16) {
				this.setSpritePos(7);
			}
			break;
		case 2:
			if (spriteCount >= 0 && spriteCount < 4) {
				this.setSpritePos(8);
			}
			if (spriteCount >= 4 && spriteCount < 8) {
				this.setSpritePos(9);
			}
			if (spriteCount >= 8 && spriteCount < 12) {
				this.setSpritePos(10);
			}
			if (spriteCount >= 12 && spriteCount < 16) {
				this.setSpritePos(11);
			}
			break;
		case 3:
			if (spriteCount >= 0 && spriteCount < 4) {
				this.setSpritePos(12);
			}
			if (spriteCount >= 4 && spriteCount < 8) {
				this.setSpritePos(13);
			}
			if (spriteCount >= 8 && spriteCount < 12) {
				this.setSpritePos(14);
			}
			if (spriteCount >= 12 && spriteCount < 16) {
				this.setSpritePos(15);
			}
			break;
		case 4:
			if (spriteCount >= 0 && spriteCount < 4) {
				this.setSpritePos(0);
			}
			if (spriteCount >= 4 && spriteCount < 8) {
				this.setSpritePos(1);
			}
			if (spriteCount >= 8 && spriteCount < 12) {
				this.setSpritePos(2);
			}
			if (spriteCount >= 12 && spriteCount < 16) {
				this.setSpritePos(3);
			}
			break;
		default:
			break;
		}
    }
}
