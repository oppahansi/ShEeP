package de.sepab.sheep.entities;

public class Entity implements IEntity {
	private int posX;
	private int posY;

	private int speed;
	
	protected int spritePos;
	protected int spriteCount = 0;
	protected int rotation = 1;

	public int getRotation() {
		return rotation;
	}

	public void setRotation(int rotation) {
		this.rotation = rotation;
		spriteCount++;
		if (spriteCount >= 16) {
			spriteCount = 0;
		}
		changeSprite(rotation);
	}
	
	public Entity(int posX, int posY) {
		this.posX = posX;
		this.posY = posY;
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
	
	public void changeSprite(int rotation) {
	}
}	
