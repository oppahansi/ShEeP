package de.sepab.sheep.logic;

import de.sepab.sheep.entities.IEntity;
import de.sepab.sheep.entities.ILevel;

public class Collision {
	public boolean calCollision(Entity entity, int x, int y){
		//Möglicherweise platzhalter
		return false;
	}
	public boolean isoccupied(int x,int y)
	{
		
		 //Große Liste erstellen
		LinkedList<IEntity> List = new LinkedList<>();
		List.addAll(getDogList());
		List.addAll(getSheepList());
		List.addAll(getPowerUpList());
		List.addAll(getObstacleList());
		
		 if(0<y<1281 && 0<x<961)	//abfrage des Spielfeldrandes
		 {
		 	//Koordinatennetz
		  	int Y[2];
			int X[2];
			X[0]=entity.getX()-32;
			X[1]=entity.getX()+32;
			Y[0]=entity.getY()-32;
			Y[1]=entity.getY()+32;
			
		 	for(int i=0;i<List.size;i++)
		 	{
				if(X[0]<List.get(i).getX()<X[1] && Y[0]<List.get(i).getY()<Y[1])	//punkt im koordinatennetz?
				{
				//COLLISION
					return false;
				}
		 	}
		 	else
		 	{
		 		return true;
		 	}
		 }
		 	return false;
		
	}
}


/*
Sprite auflösung abfragen?kann ich das? - nein muss hardegecodet werden
sind die koordinaten der entity links unten vom bild? oder z.b. zentral mitte? - links oben
ALLES IST 32x32

*/
