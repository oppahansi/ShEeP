package de.sepab.sheep.logic;
//feld=1280x960
import de.sepab.sheep.entities.IEntity;
import de.sepab.sheep.logic.ICollision;

public class Movement implements IMovement {

	
private ICollision collision;
	
	public Movement (ICollision collisionHandler)
	{
		collision=collisionHandler;
	}//calCollision(IEntity entity, int x, int y)
	public void move(IEntity entity, int direction) {
		//0=nix,1=hoch,2=rechts,3=runter,4=links,
		if(!entity.isConfused()) {
			switch (direction) {
				case (1):
					entity.setRotation(direction);
					if (collision.calcCollision(entity, entity.getPosX(), entity.getPosY() - entity.getSpeed())) {
						entity.setPosY(entity.getPosY() - entity.getSpeed());
					}
					break;
				case (2):
					entity.setRotation(direction);
					if (collision.calcCollision(entity, entity.getPosX() + entity.getSpeed(), entity.getPosY())) {
						entity.setPosX(entity.getPosX() + entity.getSpeed());
					}
					break;
				case (3):
					entity.setRotation(direction);
					if (collision.calcCollision(entity, entity.getPosX(), entity.getPosY() + entity.getSpeed())) {
						entity.setPosY(entity.getPosY() + entity.getSpeed());
					}
					break;
				case (4):
					entity.setRotation(direction);
					if (collision.calcCollision(entity, entity.getPosX() - entity.getSpeed(), entity.getPosY())) {
						entity.setPosX(entity.getPosX() - entity.getSpeed());
					}
					break;
			}
		}
		else {
			switch (direction) {
				case (1):
					entity.setRotation(3);
					if (collision.calcCollision(entity, entity.getPosX(), entity.getPosY() + entity.getSpeed())) {
						entity.setPosY(entity.getPosY() + entity.getSpeed());
					}
					break;
				case (2):
					entity.setRotation(4);
					if (collision.calcCollision(entity, entity.getPosX() - entity.getSpeed(), entity.getPosY())) {
						entity.setPosX(entity.getPosX() - entity.getSpeed());
					}
					break;
				case (3):
					entity.setRotation(1);
					if (collision.calcCollision(entity, entity.getPosX(), entity.getPosY() - entity.getSpeed())) {
						entity.setPosY(entity.getPosY() - entity.getSpeed());
					}
					break;
				case (4):
					entity.setRotation(2);
					if (collision.calcCollision(entity, entity.getPosX() + entity.getSpeed(), entity.getPosY())) {
						entity.setPosX(entity.getPosX() + entity.getSpeed());
					}
					break;
			}
		}
	}

}
