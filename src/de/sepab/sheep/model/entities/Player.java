package de.sepab.sheep.model.entities;

public class Player extends Entity{

	private int x, y, sprite[];
//	private int[] sprite;
	
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
		return sprite;
	}
	
	public Player(int x, int y, int[] sprite) {
		this.x = x;
		this.y = y;
		this.sprite = sprite;
	}
}
