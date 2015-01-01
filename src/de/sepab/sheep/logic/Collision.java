package de.sepab.sheep.logic;

import java.util.LinkedList;

import de.sepab.sheep.entities.IEntity;


public class Collision implements ICollision{

	private LinkedList<IEntity> List;
	private int lenght,hight;

	public Collision(LinkedList<IEntity> DogList,LinkedList<IEntity> SheepList,LinkedList<IEntity> PowerUpList,LinkedList<IEntity> ObstacleList,int x,int y) {
		//Große Liste erstellen
		lenght=x;
		hight=y;
		List = new LinkedList<>();
		List.addAll(DogList);
		List.addAll(SheepList);
		List.addAll(PowerUpList);
		List.addAll(ObstacleList);
	}

	public boolean calcCollision(IEntity entity, int x, int y){
		if(0<y && y<hight-32 && 0<x && x<lenght-32)//abfrage des Spielfeldrandes

		{
			//Koordinatennetz
			int Y[]=new int[2];
			int X[]=new int[2];
			//X[0]=entity.getPosX()-32;
			//X[1]=entity.getPosX()+32;
			//Y[0]=entity.getPosY()-32;
			//Y[1]=entity.getPosY()+32;
			X[0]=x-32;
			X[1]=x+32;
			Y[0]=y-32;
			Y[1]=y+32;

			for(int i=0;i<List.size();i++)
			{
				if(entity!=List.get(i))
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
		return false;
	}
	public boolean isoccupied(int x,int y)
	{

		if(0<y && y<hight-32 && 0<x && x<lenght-32)//abfrage des Spielfeldrandes

		{
			//Koordinatennetz
			int Y[]=new int[2];
			int X[]=new int[2];
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
			return true;
		}
		return false;

	}


}


/*
Sprite auflösung abfragen?kann ich das? - nein muss hardegecodet werden
sind die koordinaten der entity links unten vom bild? oder z.b. zentral mitte? - links oben
ALLES IST 32x32

*/