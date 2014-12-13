package de.sepab.sheep.entities;

public class Dog extends Entity {

    public Dog(int posX, int posY, int spritePos) {
        super(posX, posY, spritePos);
        this.setSpeed(4);
    }

    public void bark() {
    	
    }
}
