package de.sepab.sheep.entities;

public class Sheep implements IEntity, ISheep {
	
	private int[] thoughts = new int[5];
	private boolean scared = false;

	public Sheep (int posX, int posY, int spritePos) {

	}

	@Override
	public int[] getThoughts() {
		return this.thoughts;
	}

	@Override
	public int getX() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setX(int x) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getY() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setY(int y) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getSprite() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setSprite(int sprite) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public float getSpeed() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setSpeed(float speed) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setScared(boolean status) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isScared() {
		// TODO Auto-generated method stub
		return false;
	}
}
