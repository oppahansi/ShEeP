package de.sepab.sheep.entities;

public class Cage  extends Entity implements ICage{
	private int posX2;
	private int posY2;
	
	public Cage(int posX, int posY, int posX2, int posY2) {
		super(posX, posY, 0, 0);
		this.posX2 = posX2;
		this.posY2 = posY2;
	}

	public int countSheep(){
		return 0;
	}

	@Override
	public int getPosX2() {
		// TODO Auto-generated method stub
		return this.posX2;
	}

	@Override
	public void setPosX2(int posX2) {
		// TODO Auto-generated method stub
		this.posX2 = posX2;
	}

	@Override
	public int getPosY2() {
		// TODO Auto-generated method stub
		return this.posY2;
	}

	@Override
	public void setPosY2(int posY2) {
		// TODO Auto-generated method stub
		this.posY2 = posY2;
	}

	@Override
	public int getType() {
		return 0;
	}

	@Override
	public boolean isChained() {
		return false;
	}
}
