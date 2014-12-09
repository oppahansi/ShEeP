package de.sepab.sheep.logic;
//feld=1280x960
import de.sepab.sheep.entities.IEntity;
import de.sepab.sheep.logic.ICollision;

public class Movement implements IMovement {
boolean ichbinfaulichbindoll;
	@Override
	public void move(IEntity entity, int direction) {
		//0=nix,1=hoch,2=rechts,3=runter,4=links,
			switch(direction){
				case(0):
					if(Collision.isoccupied(entity.getPosX(),entity.getPosY()))
					{}
					break;
				case(1):
					if(Collision.isoccupied(entity.getPosX(),entity.getPosY()+1))
					{entity.setPosY(entity.getPosY()+1);}
					break;
				case(2):
					if(collision.isoccupied(entity.getPosX()+1,entity.getPosY()))
					{entity.setPosX(entity.getPosX()+1);}
					break;
				case(3):
					if(collision.isoccupied(entity.getPosX(),entity.getPosY()-1))
					{entity.setPosY(entity.getPosY()-1);}
					break;
				case(4):
					if(collision.isoccupied(entity.getPosX()-1,entity.getPosY()))
					{entity.setPosX(entity.getPosX()-1);}
					break;
			}
	}

}
