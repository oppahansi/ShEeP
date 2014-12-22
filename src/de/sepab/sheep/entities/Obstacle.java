package de.sepab.sheep.entities;

public class Obstacle extends Entity{
    public Obstacle(int posX, int posY, int sprite) {
	super(posX, posY, 0, 0);
        this.spritePos = sprite;
        
    }
}
