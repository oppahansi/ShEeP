package de.sepab.sheep.entities;

public class Sheep extends Entity implements ISheep {
	
	private int[] thoughts = new int[5];
	private boolean scared = false;
	private int x=0, y=0;

	public Sheep (int posX, int posY) {
		super(posX, posY);
		this.setSpeed(1);
		this.spritePeriod = 6;
		this.setSpriteQuarters();
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
	
	public void changeSprite(int rotation){
    	switch (rotation) {
		case 0:
			break;
		case 1:
			this.calculateSprite(0, 1, 2, 3);
			break;
		case 2:
			this.calculateSprite(12, 13, 14, 15);
			
			break;
		case 3:
			this.calculateSprite(8, 9, 10, 11);
			break;
		case 4:
			this.calculateSprite(4, 5, 6, 7);
			break;
		default:
			break;
		}
    }
}
