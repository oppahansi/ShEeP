package de.sepab.sheep.entities;

public class PowerUp extends Entity{

	private int type;

	public PowerUp(int posX, int posY, int spritePos, int type) {
		super(posX, posY);
		this.type = type;
	}

	public int getType() {
		return type;
	}
}
