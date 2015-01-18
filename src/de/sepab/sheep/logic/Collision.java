package de.sepab.sheep.logic;

import java.util.LinkedList;

import com.sun.xml.internal.bind.v2.runtime.reflect.opt.Const;
import de.sepab.sheep.entities.ISheep;
import de.sepab.sheep.entities.IDog;
import de.sepab.sheep.entities.IEntity;
import de.sepab.sheep.entities.ICage;
import de.sepab.sheep.handler.Constants;
import de.sepab.sheep.handler.IJukeBox;
import de.sepab.sheep.handler.JukeBox;

public class Collision implements ICollision{

	private LinkedList<IEntity> Dogs,Powers,Sheeps,Obstacles,Cages;
	private int length,height;
	private IJukeBox jukeBox;

	public Collision(LinkedList<IEntity> DogList,LinkedList<IEntity> SheepList,LinkedList<IEntity> PowerUpList,LinkedList<IEntity> ObstacleList,LinkedList<IEntity> CageList,int x,int y) {
		//Listen erstellen

		length=x;
		height=y;
		Dogs = DogList;
		Sheeps = SheepList;
		Powers = PowerUpList;
		Obstacles = ObstacleList;
		Cages = CageList;
		jukeBox = new JukeBox("/de/sepab/sheep/model/sfx/powerup.wav");
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
			((ISheep)Sheeps.get(i)).setChained(false);
			if(X[0]<Sheeps.get(i).getPosX() && Sheeps.get(i).getPosX()<X[1] && Y[0]<Sheeps.get(i).getPosY() && Sheeps.get(i).getPosY()<Y[1])	//punkt im koordinatennetz?
			{
				//COLLISION
				R++;
				((ISheep)Sheeps.get(i)).setChained(true);
			}
		}
		return R;
		
	}
	
	public int Count(int Ax, int Ay,int Bx,int By,int Cx, int Cy,int Dx,int Dy)
	{
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
		for(int i=0;i<Sheeps.size();i++)
		{
			((ISheep)Sheeps.get(i)).setChained(false);
			if(X[0]<Sheeps.get(i).getPosX() && Sheeps.get(i).getPosX()<X[1] && Y[0]<Sheeps.get(i).getPosY() && Sheeps.get(i).getPosY()<Y[1])	//punkt im koordinatennetz?
			{
				//COLLISION
				R=R+1000;//erstes gehege z�hlt in 1000ner schritten damit bis zu 999 schafe im zweiten gehege sein k�nnen
				((ISheep)Sheeps.get(i)).setChained(true);
			}
			if(X[2]<Sheeps.get(i).getPosX() && Sheeps.get(i).getPosX()<X[3] && Y[2]<Sheeps.get(i).getPosY() && Sheeps.get(i).getPosY()<Y[3])	//punkt im koordinatennetz?
			{
				//COLLISION
				R=R+1;
				((ISheep)Sheeps.get(i)).setChained(true);
			}
			
		}
		return R;//R ist keine eindeutige zahl mehr da nun zwei gehege vorhanden sind, sondern ein mix aus 2 z�hlern
	}
	
	public boolean calcCollision(IEntity entity, int x, int y)
	{
		if(-1<y && y<height-32 && -1<x && x<length-32)//abfrage des Spielfeldrandes
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
				if(entity!=Sheeps.get(i)&&((ISheep)Sheeps.get(i)).isChained()==false)
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
						if (Powers.get(i).getType() == Constants.POWERUP_TYPE_BEAM) {
							if (entity instanceof IDog) {
								System.out.println("Dog -> SHEEP BEAM in");
								int sheepPosInList = RandomGenerator.getRandomNumber(1, Sheeps.size() - 1);
								if (entity == Dogs.getFirst()) {
									Sheeps.get(sheepPosInList).setPosX(Cages.getFirst().getPosX());
									Sheeps.get(sheepPosInList).setPosY(Cages.getFirst().getPosY());
								}
								else {
									Sheeps.get(sheepPosInList).setPosX(Cages.getLast().getPosX());
									Sheeps.get(sheepPosInList).setPosY(Cages.getLast().getPosY());
								}
								Powers.remove(i);
								jukeBox.play();
							}
							else {
								System.out.println("Sheep -> SHEEP BEAM out");
								for (IEntity sheep : Sheeps) {
									if (sheep.isChained()) {
										portSheep(sheep);
										break;
									}
								}
								Powers.remove(i);
								jukeBox.play();
							}
						}
						else if (Powers.get(i).getType() == Constants.POWERUP_TYPE_DEAF) {
							if (entity instanceof IDog) {
								System.out.println("Dog -> SUPERBARK");
								((IDog) entity).setBarkLength(((IDog) entity).getBarkLength() * 2);
								Powers.remove(i);
								jukeBox.play();
							}
							else {
								System.out.println("Sheep -> DEAF");
								((ISheep) entity).deafy(true);
								Powers.remove(i);
								jukeBox.play();
							}
						}
						else if (Powers.get(i).getType() == Constants.POWERUP_TYPE_SPEED) {
							System.out.println("Entity -> SPEED");
							entity.setSpeed(entity.getSpeed() * 2);
							Powers.remove(i);
							jukeBox.play();
						}
						else if (Powers.get(i).getType() == Constants.POWERUP_TYPE_SLOW) {
							System.out.println("Entity -> SLOW");
							entity.setSpeed(entity.getSpeed() * 2);
							Powers.remove(i);
							jukeBox.play();

						}
						else if (Powers.get(i).getType() == Constants.POWERUP_TYPE_CONFUSION) {
							System.out.println("Entity -> CONFUSED");
							entity.confuse(true);
							Powers.remove(i);
							jukeBox.play();
						}
						return true;
						//MAGICLE AUFRUF DES POWERUP KILLERS Magic(entity,Powers.get(i){oder einfach nur i als index des zu verarbeitenden power ups})
					}
				}
			}
			return true;
		}
		return false;
	}
	
	
	public void portSheep(IEntity entity)
	{
		int x = RandomGenerator.getRandomNumber(0, this.length -32);
		int y = RandomGenerator.getRandomNumber(0, this.height -32);
		if (!isoccupied(x, y)) {
			portSheep(entity);
			return;
		} else {
			entity.setPosX(x);
			entity.setPosY(y);
		}
	}

	public boolean isoccupied(int x,int y)
	{
		if(0<y && y<height-32 && 0<x && x<length-32)//abfrage des Spielfeldrandes
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
			for(int i=0;i<Cages.size();i++)
			{
					
					if(Cages.get(i).getPosX()-32<x && ((ICage)Cages.get(i)).getPosX2()+32>x &&Cages.get(i).getPosY()-32<y && ((ICage)Cages.get(i)).getPosY2()+32>y)
					{
					return false;
					}
			}
			return true;
		}
		return false;
	}
}