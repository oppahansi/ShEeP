package de.sepab.sheep.logic;

import java.util.LinkedList;
import de.sepab.sheep.entities.ISheep;
import de.sepab.sheep.entities.IDog;
import de.sepab.sheep.entities.IEntity;
import de.sepab.sheep.entities.PowerUp;

public class Collision implements ICollision{

	private LinkedList<IEntity> Dogs,Powers,Sheeps,Obstacles,List;
	private int lenght,hight;

	public Collision(LinkedList<IEntity> DogList,LinkedList<IEntity> SheepList,LinkedList<IEntity> PowerUpList,LinkedList<IEntity> ObstacleList,int x,int y) {
		//Listen erstellen
		lenght=x;
		hight=y;
		Dogs = DogList;
		Sheeps = SheepList;
		Powers = PowerUpList;
		Obstacles = ObstacleList;
	}

	public int Count(int Ax, int Ay,int Bx,int By){
		int R=0;
		int Y[]=new int[2];
		int X[]=new int[2];
		X[0]=Ax-32;
		X[1]=Bx+32;
		Y[0]=Ay-32;
		Y[1]=By+32;
		for(int i=0;i<Sheeps.size();i++){
			((ISheep)Sheeps.get(i)).setchained(false);
			if(X[0]<Sheeps.get(i).getPosX() && Sheeps.get(i).getPosX()<X[1] && Y[0]<Sheeps.get(i).getPosY() && Sheeps.get(i).getPosY()<Y[1])	//punkt im koordinatennetz?
			{
				//COLLISION
				R++;
				((ISheep)Sheeps.get(i)).setchained(true);
			}
		}
		return R;
		
	}
	
	public int Count(int Ax, int Ay,int Bx,int By,int Cx, int Cy,int Dx,int Dy){
		int R=0;
		int Y[]=new int[4];
		int X[]=new int[4];
		X[0]=Ax-32;
		X[1]=Bx+32;
		Y[0]=Ay-32;
		Y[1]=By+32;
		X[2]=Cx-32;
		X[3]=Dx+32;
		Y[2]=Cy-32;
		Y[3]=Dy+32;
		for(int i=0;i<Sheeps.size();i++){
			((ISheep)Sheeps.get(i)).setchained(false);
			if(X[0]<Sheeps.get(i).getPosX() && Sheeps.get(i).getPosX()<X[1] && Y[0]<Sheeps.get(i).getPosY() && Sheeps.get(i).getPosY()<Y[1])	//punkt im koordinatennetz?
			{
				//COLLISION
				R=R+1000;//erstes gehege z�hlt in 1000ner schritten damit bis zu 999 schafe im zweiten gehege sein k�nnen
				((ISheep)Sheeps.get(i)).setchained(true);
			}
			if(X[2]<Sheeps.get(i).getPosX() && Sheeps.get(i).getPosX()<X[3] && Y[2]<Sheeps.get(i).getPosY() && Sheeps.get(i).getPosY()<Y[3])	//punkt im koordinatennetz?
			{
				//COLLISION
				R=R+1;
				((ISheep)Sheeps.get(i)).setchained(true);
			}
			
		}
		return R;//R ist keine eindeutige zahl mehr da nun zwei gehege vorhanden sind, sondern ein mix aus 2 z�hlern
	}
	
	public boolean calcCollision(IEntity entity, int x, int y){
		if(-1<y && y<hight-32 && -1<x && x<lenght-32)//abfrage des Spielfeldrandes
		{
			//Koordinatennetz
			int Y[]=new int[2];
			int X[]=new int[2];
			X[0]=x-32;
			X[1]=x+32;
			Y[0]=y-32;
			Y[1]=y+32;
			
			for(int i=0;i<Dogs.size();i++)
			{
				if(entity!=Dogs.get(i))
				{
					if(X[0]<Dogs.get(i).getPosX() && Dogs.get(i).getPosX()<X[1] && Y[0]<Dogs.get(i).getPosY() && Dogs.get(i).getPosY()<Y[1])	//punkt im koordinatennetz?
					{
						//COLLISION
						return false;
					}
				}
			}
			for(int i=0;i<Sheeps.size();i++)
			{
				if(entity!=Sheeps.get(i))
				{
					if(X[0]<Sheeps.get(i).getPosX() && Sheeps.get(i).getPosX()<X[1] && Y[0]<Sheeps.get(i).getPosY() && Sheeps.get(i).getPosY()<Y[1])	//punkt im koordinatennetz?
					{
						//COLLISION
						return false;
					}
				}
			}
			for(int i=0;i<Obstacles.size();i++)
			{
				if(Obstacles.get(i).getSpritePos()==3||Obstacles.get(i).getSpritePos()==4||Obstacles.get(i).getSpritePos()==5)
				{
					if(X[0]+10<Obstacles.get(i).getPosX() && Obstacles.get(i).getPosX()<X[1]-10 && Y[0]<Obstacles.get(i).getPosY() && Obstacles.get(i).getPosY()<Y[1])	//punkt im koordinatennetz?
					{
						//
						//von beiden seiten 3 4 5 
						return false;
						
					}
				}
					else
					{
						if(Obstacles.get(i).getSpritePos()==8||Obstacles.get(i).getSpritePos()==14)
						{
							if(X[0]+10<Obstacles.get(i).getPosX() && Obstacles.get(i).getPosX()<X[1] && Y[0]<Obstacles.get(i).getPosY() && Obstacles.get(i).getPosY()<Y[1])	//punkt im koordinatennetz?
							{
								//
								//von rechts  8 14  
								return false;
						
							}
						}
						else
						{
							if(Obstacles.get(i).getSpritePos()==6||Obstacles.get(i).getSpritePos()==12)
							{
								if(X[0]<Obstacles.get(i).getPosX() && Obstacles.get(i).getPosX()<X[1]-10 && Y[0]<Obstacles.get(i).getPosY() && Obstacles.get(i).getPosY()<Y[1])	//punkt im koordinatennetz?
								{
									// 
									//von links 6 12 
									return false;
						
								}
							}
							else
							{
								if(Obstacles.get(i).getSpritePos()==21||Obstacles.get(i).getSpritePos()==22||Obstacles.get(i).getSpritePos()==23)
								{
									if(X[0]<Obstacles.get(i).getPosX() && Obstacles.get(i).getPosX()<X[1] && Y[0]<Obstacles.get(i).getPosY() && Obstacles.get(i).getPosY()<Y[1]-16)	//punkt im koordinatennetz?
									{
										//
										//COLLISION 21 22 23 
										return false;
						
									}
								}
								else
								{
									if(X[0]<Obstacles.get(i).getPosX() && Obstacles.get(i).getPosX()<X[1] && Y[0]<Obstacles.get(i).getPosY() && Obstacles.get(i).getPosY()<Y[1])	//punkt im koordinatennetz?
									{
										//
										return false;
						
									}
								}
							}
						}
					}
			}
			
			for(int i=0;i<Powers.size();i++)
			{
				if(entity!=Powers.get(i))
				{
					if(X[0]<Powers.get(i).getPosX() && Powers.get(i).getPosX()<X[1] && Y[0]<Powers.get(i).getPosY() && Powers.get(i).getPosY()<Y[1])	//punkt im koordinatennetz?
					{
						//COLLISION
						return true;
						//MAGICLE AUFRUF DES POWERUP KILLERS Magic(entity,Powers.get(i){oder einfach nur i als index des zu verarbeitenden power ups})
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

			for(int i=0;i<Dogs.size();i++)
			{
				if(X[0]<Dogs.get(i).getPosX() && Dogs.get(i).getPosX()<X[1] && Y[0]<Dogs.get(i).getPosY() && Dogs.get(i).getPosY()<Y[1])	//punkt im koordinatennetz?
				{
					//COLLISION
					return false;
				}
			}
			for(int i=0;i<Sheeps.size();i++)
			{
					if(X[0]<Sheeps.get(i).getPosX() && Sheeps.get(i).getPosX()<X[1] && Y[0]<Sheeps.get(i).getPosY() && Sheeps.get(i).getPosY()<Y[1])	//punkt im koordinatennetz?
					{
						//COLLISION
						return false;
					}
			}
			for(int i=0;i<Powers.size();i++)
			{
					if(X[0]<Powers.get(i).getPosX() && Powers.get(i).getPosX()<X[1] && Y[0]<Powers.get(i).getPosY() && Powers.get(i).getPosY()<Y[1])	//punkt im koordinatennetz?
					{
						//COLLISION
						return false;
					}
			}
			for(int i=0;i<Obstacles.size();i++)
			{
					if(X[0]<Obstacles.get(i).getPosX() && Obstacles.get(i).getPosX()<X[1] && Y[0]<Obstacles.get(i).getPosY() && Obstacles.get(i).getPosY()<Y[1])	//punkt im koordinatennetz?
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
