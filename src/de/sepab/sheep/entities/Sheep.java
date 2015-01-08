package de.sepab.sheep.entities;

public class Sheep extends Entity implements ISheep {
	
	private int[] thoughts = new int[64];
	private boolean scared = false;
	private int x=0, y=0;
	private boolean deaf = false;
	private boolean chained = false;
	private int scareSpeed;

	public Sheep (int posX, int posY, int speed, int powerUpLife, int scareSpeed) {
		super(posX, posY, speed, powerUpLife);
		this.setSpeed(1);
		this.spritePeriod = 6;
		this.setSpriteQuarters();
		this.scareSpeed = scareSpeed;
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
		if(!this.isScared()) {
			this.scared = state;
			this.x = x;
			this.y = y;
			super.setSpeed(super.getSpeed() + this.scareSpeed);
		}
	}

	@Override
	public void unscare() {
		if(this.isScared()) {
			this.scared = false;
			super.setSpeed(super.getSpeed() - this.scareSpeed);
		}
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
	
	public void setChained(boolean state){
		this.chained=state;
	}
	
	public boolean isChained(){
		return chained;
}
}
