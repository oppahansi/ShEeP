package de.sepab.sheep.entities;

public class Sheep extends Entity implements ISheep {
	
	private int[] thoughts = new int[64];
	private boolean scared = false;
	private int x=0, y=0;
	private boolean deaf = false;
	private boolean chained = false;
	private int scareSpeed;
	private int addSpeed = 0;
	private int speed;


	public Sheep (int posX, int posY, int speed, int powerUpLife, int scareSpeed) {
		super(posX, posY, speed, powerUpLife);
		this.spritePeriod = 6;
		this.setSpriteQuarters();
		this.scareSpeed = scareSpeed;
		this.speed = speed;
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
			super.setSpeed(this.scareSpeed);
		}
	}

	@Override
	public void unscare() {
		if(this.isScared()) {
			this.scared = false;
			this.x = -1;
			this.y = -1;
			super.setSpeed(this.speed);
		}
	}

	@Override
	public void setAddSpeed(int addSpeed) {
		this.addSpeed = addSpeed;
	}

	@Override
	public int getSpeed() {
		return (super.getSpeed() + this.addSpeed);
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
			this.addSpeed = 0;
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
	
	public void setScareSpeed(int scareSpeed){
		this.scareSpeed = scareSpeed;
	}
	
	public int getScareSpeed(){
		return this.scareSpeed;
	}
}
