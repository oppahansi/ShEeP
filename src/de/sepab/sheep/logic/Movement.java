package de.sepab.sheep.logic;
//feld=1280x960
import de.sepab.sheep.entities.IEntity;
import de.sepab.sheep.logic.ICollision;

public class Movement implements IMovement {

	
private ICollision collision;
	
	public Movement (ICollision collisionHandler)
	{
		collision=collisionHandler;
	}
	public void move(IEntity entity, int direction) {
		//0=nix,1=hoch,2=rechts,3=runter,4=links,
			switch(direction){
				case(0):
					if(collision.isoccupied(entity.getPosX(),entity.getPosY()))
					{}
					break;
				case(1):
					entity.setRotation(direction);
					if(collision.isoccupied(entity.getPosX(),entity.getPosY()-4))
					{entity.setPosY(entity.getPosY()-4);}
					break;
				case(2):
					entity.setRotation(direction);
					if(collision.isoccupied(entity.getPosX()+4,entity.getPosY()))
					{entity.setPosX(entity.getPosX()+4);}
					break;
				case(3):
					entity.setRotation(direction);
					if(collision.isoccupied(entity.getPosX(),entity.getPosY()+4))
					{entity.setPosY(entity.getPosY()+4);}
					break;
				case(4):
					entity.setRotation(direction);
					if(collision.isoccupied(entity.getPosX()-4,entity.getPosY()))
					{entity.setPosX(entity.getPosX()-4);}
					break;
			}
	}

}
