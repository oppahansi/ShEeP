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
					if(collision.isoccupied(entity.getPosX(),entity.getPosY()-2))
					{entity.setPosY(entity.getPosY()-2);}
					break;
				case(2):
					if(collision.isoccupied(entity.getPosX()+2,entity.getPosY()))
					{entity.setPosX(entity.getPosX()+2);}
					break;
				case(3):
					if(collision.isoccupied(entity.getPosX(),entity.getPosY()+2))
					{entity.setPosY(entity.getPosY()+2);}
					break;
				case(4):
					if(collision.isoccupied(entity.getPosX()-2,entity.getPosY()))
					{entity.setPosX(entity.getPosX()-2);}
					break;
			}
	}

}
