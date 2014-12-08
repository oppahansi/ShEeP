package de.sepab.sheep.logic;
//feld=1280x960
import de.sepab.sheep.entities.IEntity;

public class Movement implements IMovement {

	@Override
	public void move(IEntity entity, int direction) {
		// TODO Auto-generated method stub
		//0=nix,1=hoch,2=rechts,3=runter,4=links,
			switch(direction)
				case(0)
					if(collision.isoccupied(entiry.getX(),entity.getY()))
					{}
					break;
				case(1)
					if(collision.isoccupied(entity.getX(),entity.getY()+1))
					{entity.setY(entity.getY+1);}
					break;
				case(2)
					if(collision.isoccupied(entity.getX()+1,entity.getY()))
					{entity.setX(entity.getX+1);}
					break;
				case(3)
					if(collision.isoccupied(entity.getX(),entity.getY()-1))
					{entity.setY(entity.getY-1);}
					break;
				case(4)
					if(collision.isoccupied(entity.getX()-1,entity.getY()))
					{entity.setX(entity.getX()-1);}
					break;
		
	}

}
