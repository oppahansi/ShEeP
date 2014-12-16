package de.sepab.sheep.entities;

public interface IEntity {
	
	public int getPosX();
	public void setPosX(int x);
	public int getPosY();
	public void setPosY(int y);
	public int getSpritePos();
	public void setSpritePos(int sprite);
	public int getSpeed();
	public void setSpeed(int speed);
	public int getRotation();
	public void setRotation(int rotation);
	
}
