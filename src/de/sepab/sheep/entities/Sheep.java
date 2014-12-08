package de.sepab.sheep.entities;

public class Sheep extends Entity, ISheep {
	
	private int[] thoughts = new int[5];
	private boolean scared = false;

	public Sheep (int posX, int posY, int spritePos) {
		super(posX, posY, spritePos);
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

	public void setScared(boolean status) {
		this.scared = scared;
	}

	
}
