package de.sepab.sheep.entities;

public class Entity implements IEntity {
	private int posX;
	private int posY;
	private int spritePos;

	public Entity(int posX, int posY, int spritePos) {
		this.posX = posX;
		this.posY = posY;
		this.spritePos = spritePos;
	}

	@Override
	public int getX(){
		return 0;
	}
	
	@Override
	public void setX(int x){}
	
	@Override
	public int getY() {
		return 0;
	}
	
	@Override
	public void setY(int y){}
	
	@Override
	public int getSprite(){
		return 0;
	}
	
	@Override
	public void setSprite(int sprite){}
	
	@Override
	public float getSpeed() {
		return 0f;
	}
	
	@Override
	public void setSpeed(float speed){}
	
}
