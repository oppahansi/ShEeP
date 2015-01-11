package de.sepab.sheep.entities;

public interface IEntity {
	
	public int getPosX();
	public void setPosX(int x);
	public int getPosY();
	public void setPosY(int y);
	public int getSpritePos();
	public void setSpritePos(int sprite);
	public int getPowerUpLife();
	public void decrementPowerUpLife();
	public void resetPowerUpLife();
	public int getSpeed();
	public void setSpeed(int speed);
	public void resetSpeed();
	public void confuse(boolean state);
	public boolean isConfused();
	public int getRotation();
	public void setRotation(int rotation);

	public void setVisible(boolean visibility);

	public boolean isVisible();

	public void event(IEntity entity);
}
