package de.sepab.sheep.entities;

public class Entity implements IEntity {
	private int posX;
	private int posY;
	private int spritePos;
	private int speed;
	private int rotation = 1;

	public Entity(int posX, int posY, int spritePos) {
		this.posX = posX;
		this.posY = posY;
		this.spritePos = spritePos;
	}

	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}

	public int getSpritePos() {
		return spritePos;
	}

	public void setSpritePos(int spritePos) {
		this.spritePos = spritePos;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}
	
	public int getRotation() {
		return this.rotation;
	}
	
	public void setRotation(int rotation) {
		this.rotation = rotation;
	}
	
}	
