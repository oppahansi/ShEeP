package de.sepab.sheep.entities;

public class PowerUpIcon extends Entity implements IPowerUpIcon {
	private int type;
	private int life;

	public PowerUpIcon(int posX, int posY, int type) {
		super(posX, posY, 0, 0);
		this.type = type;
		this.life = 40;
		calculateSprite();
		// TODO Auto-generated constructor stub
	}
	
	public void calculateSprite(){
		switch (type) {
		case 0:
			this.setSpritePos(10 - life/4);
			break;
		case 1:
			this.setSpritePos(10 - life/4 + 10);
			break;
		case 2:
			this.setSpritePos(10 - life/4 + 20);
			break;
		case 3:
			this.setSpritePos(10 - life/4 + 30);
			break;
		case 4:
			this.setSpritePos(10 - life/4 + 40);
			break;
		case 5:
			this.setSpritePos(10 - life/4 + 50);
			break;
		default:
			break;
		}
	}
	
	public int getLife() {
		return life;
	}

	public void setLife(int life) {
		this.life = life;
	}

}
