package de.sepab.sheep.entities;

public class Sheep extends Entity implements ISheep {
	
	private int[] thoughts = new int[5];
	private boolean scared = false;
	private int x=0, y=0;

	public Sheep (int posX, int posY) {
		super(posX, posY);
		this.setSpeed(1);
	}

	public int[] getThoughts() {
		return thoughts;
	}

	public void setThoughts(int[] thoughts) {
		this.thoughts = thoughts;
	}

	public boolean isScared() {
		return scared;
	}

	@Override
	public void scare(int x, int y) {
		this.scared = true;
		this.x = x;
		this.y = y;
	}

	@Override
	public int getX() {
		return this.x;
	}

	@Override
	public int getY() {
		return this.y;
	}
	
}
