package de.sepab.sheep.entities;

public class PowerUp extends Entity{

	private int type;

	public int getType() {
		return type;
	}
	
	public PowerUp(int posX, int posY, int type) {
		super(posX, posY, 0, 0);
		this.type = type;
	}
}
