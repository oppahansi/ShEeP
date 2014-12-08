package de.sepab.sheep.entities;

public class Entity implements IEntity {
	private int posX;
	private int posY;
	private int spritePos;
	private float speed;

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

	public float getSpeed() {
		return speed;
	}

	public void setSpeed(float speed) {
		this.speed = speed;
	}
}	
