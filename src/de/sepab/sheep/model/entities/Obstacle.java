package de.sepab.sheep.model.entities;

public class Obstacle extends Entity{
	private int x, y, sprite[];
	@Override
	public int getPosX() {
		return x;
	}

	@Override
	public void setPosX() {}

	@Override
	public int getPosY() {
		return y;
	}

	@Override
	public void setPosY() {}

	@Override
	public void event() {}

	@Override
	public void move() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int[] getSprite() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public Obstacle(int x, int y, int[] sprite) {
		this.x = x;
		this.y = y;
		this.sprite = sprite;
	}
}
