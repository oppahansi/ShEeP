package de.sepab.sheep.entities;

public class Sheep extends Entity implements ISheep {
	
	private int[] thoughts = new int[64];
	private boolean scared = false;
	private int x=0, y=0;
	private boolean deaf = false;

	public Sheep (int posX, int posY, int speed, int powerUpLife) {
		super(posX, posY, speed, powerUpLife);
		this.setSpeed(1);
		this.spritePeriod = 6;
		this.setSpriteQuarters();
	}

	@Override
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
	public void scare(boolean state, int x, int y) {
		this.scared = state;
		this.x = x;
		this.y = y;
	}

	@Override
	public boolean isDeaf() {
		return this.deaf;
	}

	@Override
	public void deafy(boolean state) {
		this.deaf = state;
	}

	public void checkPowerUpLife() {
		if(this.getPowerUpLife() <= 0) {
			this.resetPowerUpLife();
			this.resetSpeed();
			this.confuse(false);
			this.deafy(false);
		}
	}

	@Override
	public int getScareX() {
		return this.x;
	}

	@Override
	public int getScareY() {
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
