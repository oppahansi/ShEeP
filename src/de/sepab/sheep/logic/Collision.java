package de.sepab.sheep.logic;

import de.sepab.sheep.entities.IEntity;
import de.sepab.sheep.entities.ILevel;

public class Collision {
	public boolean calCollision(Entity entity, int x, int y){
		//Wäre echt nicer wenn das ne Entity zurüch gibt.
		return false;
	}
	puplic boolean isoccupied(int x,int y)
	{
		//getDogList();getSheepList();getPowerUpList();getObstacleList()
		/*
		 * if(0<x<1281 && 0<y<961)
		 * {
		 	liste mit allen entitys finden
		 	for(int i=0;i<getDogList().size;i++)
		 	{
				int Y[2];
				int X[2];
				x[0]=entity.getX()-32;
				x[1]=entity.getX()+32;
				y[0]=entity.getY()-32;
				y[1]=entity.getY()+32;

			if(x[0]<List[i].getX()<x[1] && y[0]<list[i].getY()<y[1])
			{//COLLISION
			return false;}
		 	}
		 	else{return true;}
		 	}
		 	}
		 	return false;
		*/
	}
}


/*
Sprite auflösung abfragen?kann ich das? - nein muss hardegecodet werden
sind die koordinaten der entity links unten vom bild? oder z.b. zentral mitte? - links oben
hunde sind 64x64
schafe sind 64x64
hindernis immer 32x32?
ALLES IST 32x32

*/
