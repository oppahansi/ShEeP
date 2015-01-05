package de.sepab.sheep.entities;

import de.sepab.sheep.handler.Constants;

public class PowerUp extends Entity{

	private int type;

	public PowerUp(int posX, int posY, int type) {
		super(posX, posY, 0, 0);
		this.type = type;
	}

	public int getType() {
		return type;
	}

	public void event(IEntity entity) {
		switch(this.type) {
			case Constants.POWERUP_TYPE_SPEED:
				entity.setSpeed(entity.getSpeed() * 2);
				break;
			case Constants.POWERUP_TYPE_SLOW:
				entity.setSpeed(entity.getSpeed() / 2);
				break;
			case Constants.POWERUP_TYPE_DEAF:
				if(entity instanceof ISheep) {
					((ISheep) entity).deafy(true);
				}
				break;
			case Constants.POWERUP_TYPE_BEAM:
				if(entity instanceof ISheep) {
					entity.setPosX(15);
					entity.setPosY(15);
				}
				break;
			case Constants.POWERUP_TYPE_TIME:
				if(entity instanceof IDog) {
					// add time here
				}
				break;
		}
	}
}