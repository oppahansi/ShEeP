package de.sepab.sheep.logic;

import java.util.LinkedList;

import de.sepab.sheep.entities.IEntity;


public class Collision implements ICollision{
	
	LinkedList<IEntity> List;
	
	public Collision(LinkedList<IEntity> DogList,LinkedList<IEntity> SheepList,LinkedList<IEntity> PowerUpList,LinkedList<IEntity> ObstacleList) {
		//Große Liste erstellen
		List = new LinkedList<>();
		List.addAll(DogList);
		List.addAll(SheepList);
		List.addAll(PowerUpList);
		List.addAll(ObstacleList);
	}
	
	//public boolean calCollision(Entity entity, int x, int y){
		//Möglicherweise platzhalter
		//return false;
	//}
	public boolean isoccupied(int x,int y)
	{
		
		 
		
		
		 if(31<y && y<1281 && 0<x && x<929)	//abfrage des Spielfeldrandes
		 {
		 	//Koordinatennetz
		  	int Y[]=new int[2];
			int X[]=new int[2];
			//X[0]=entity.getX()-32;
			//X[1]=entity.getX()+32;
			//Y[0]=entity.getY()-32;
			//Y[1]=entity.getY()+32;
			X[0]=x-32;
			X[1]=x+32;
			Y[0]=y-32;
			Y[1]=y+32;
			
		 	for(int i=0;i<List.size();i++)
		 	{
				if(X[0]<List.get(i).getPosX() && List.get(i).getPosX()<X[1] && Y[0]<List.get(i).getPosY() && List.get(i).getPosY()<Y[1])	//punkt im koordinatennetz?
				{
				//COLLISION
					return false;
				}
				
		 	
		 		
		 	
		 	}
		 	
		 }
		 	return true;
		
	}

	@Override
	public boolean calcCollision(IEntity entitiy, int posX, int posY) {
		// TODO Auto-generated method stub
		return false;
	}

}


/*
Sprite auflösung abfragen?kann ich das? - nein muss hardegecodet werden
sind die koordinaten der entity links unten vom bild? oder z.b. zentral mitte? - links oben
ALLES IST 32x32

*/
