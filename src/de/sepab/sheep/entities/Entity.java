package de.sepab.sheep.entities;

public class Entity implements IEntity {
	private int posX;
	private int posY;

	private int speed;
	
	protected int spritePos;
	protected int spriteCount = 0;
	protected int rotation = 1;

	protected int spritePeriod;
	protected int spriteQuarter1;
	protected int spriteQuarter2;
	protected int spriteQuarter3;
	protected int spriteQuarter4;

	public int getRotation() {
		return rotation;
	}

	public void setRotation(int rotation) {
		this.rotation = rotation;
		spriteCount++;
		if (spriteCount >= spriteQuarter4) {
			spriteCount = 0;
		}
		changeSprite(rotation);
	}
	
	public void setspritePeriod(int period){
		this.spritePeriod = period;
	}
	
	public void setSpriteQuarters() {
		spriteQuarter1 = spritePeriod;
		spriteQuarter2 = spritePeriod*2;
		spriteQuarter3 = spritePeriod*3;
		spriteQuarter4 = spritePeriod*4;
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
	
	public void calculateSprite(int sprite1, int sprite2, int sprite3, int sprite4){
		if (spriteCount >= 0 && spriteCount < spriteQuarter1) {
			this.setSpritePos(sprite1);
		}
		if (spriteCount >= spriteQuarter1 && spriteCount < spriteQuarter2) {
			this.setSpritePos(sprite2);
		}
		if (spriteCount >= spriteQuarter2 && spriteCount < spriteQuarter3) {
			this.setSpritePos(sprite3);
		}
		if (spriteCount >= spriteQuarter3 && spriteCount < spriteQuarter4) {
			this.setSpritePos(sprite4);
		}
	}
	
	public void changeSprite(int rotation) {
	}
}	
