package de.sepab.sheep.logic;

import java.util.LinkedList;

import de.sepab.sheep.display.Menu;
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
	private Menu menu;
	private Level level;

	public Collision(ILevel level, int x,int y, Menu menu) {
		//Listen erstellen

		length=x;
		height=y;
		this.level = (Level)level;
		Dogs = this.level.getDogList();
		Sheeps = this.level.getSheepList();
		Powers = this.level.getPowerUpList();
		Obstacles = this.level.getObstacleList();
		Cages = this.level.getCageList();
		jukeBox = new JukeBox("/de/sepab/sheep/model/sfx/powerup.wav");
		this.menu = menu;
	}
	// Test Constructor
	public Collision(LinkedList<IEntity> dogs, LinkedList<IEntity> sheeps, LinkedList<IEntity> powers,
					 LinkedList<IEntity> obstacles, LinkedList<IEntity> cages,  int length, int height) {
		this.Dogs = dogs;
		this.Sheeps = sheeps;
		this.Powers = powers;
		this.Obstacles = obstacles;
		this.Cages = cages;
		this.length = length;
		this.height = height;
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
	
	public boolean calcCollision(IEntity entity, int x, int y){
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
					   if(Powers.get(i).getType() == Constants.POWERUP_TYPE_BEAM) {
							if (entity instanceof IDog) {
								int sheepPosInList = isSheepChained();
								level.addPowerUpIcon(Sheeps.get(sheepPosInList).getPosX() + 8, Sheeps.get(sheepPosInList).getPosY() + 8, 4);
								if (entity == Dogs.getFirst()) {
									Sheeps.get(sheepPosInList).setPosX(RandomGenerator.getRandomNumber(Cages.getFirst().getPosX(), ((ICage)Cages.getFirst()).getPosX2()));
									Sheeps.get(sheepPosInList).setPosY(RandomGenerator.getRandomNumber(Cages.getFirst().getPosY(), ((ICage)Cages.getFirst()).getPosY2()));
									menu.setGameBoard_PowerUpNamePlayer1Text("Schaf teleport");
								} else {
									Sheeps.get(sheepPosInList).setPosX(RandomGenerator.getRandomNumber(Cages.getLast().getPosX(), ((ICage)Cages.getLast()).getPosX2()));
									Sheeps.get(sheepPosInList).setPosY(RandomGenerator.getRandomNumber(Cages.getLast().getPosY(), ((ICage)Cages.getLast()).getPosY2()));
									menu.setGameBoard_PowerUpNamePlayer2Text("Schaf teleport");
								}
								Powers.remove(i);
								jukeBox.play();
							}
							else {
								System.out.println("Sheep -> SHEEP BEAM out");
								for (IEntity sheep : Sheeps) {
									if (((ICage)Cages.getFirst()).getPosX2() >= sheep.getPosX() && sheep.getPosX() >= Cages.getFirst().getPosX() &&
										((ICage)Cages.getFirst()).getPosY2() >= sheep.getPosY() && sheep.getPosY() >= Cages.getFirst().getPosY()) {
										level.addPowerUpIcon(sheep.getPosX() + 8, sheep.getPosY() + 8, 4);
										portSheep(sheep);
										break;
									}
								}
								if (Dogs.size() > 1) {
									for (IEntity sheep : Sheeps) {
										if (((ICage)Cages.getLast()).getPosX2() >= sheep.getPosX() && sheep.getPosX() >= Cages.getLast().getPosX() &&
											((ICage)Cages.getLast()).getPosY2() >= sheep.getPosY() && sheep.getPosY() >= Cages.getLast().getPosY()) {
											level.addPowerUpIcon(sheep.getPosX() + 8, sheep.getPosY() + 8, 4);
											portSheep(sheep);
											break;
										}
									}
								}
								Powers.remove(i);
								jukeBox.play();
							}
						}
						else if (Powers.get(i).getType() == Constants.POWERUP_TYPE_DEAF) {
							if(entity instanceof IDog) {
								System.out.println("Dog -> SUPERBARK");
								level.addPowerUpIcon(entity.getPosX() + 8, entity.getPosY() + 8, 3);
								if (entity == Dogs.getFirst()) {
									menu.setGameBoard_PowerUpNamePlayer1Text("Super bellen");
								} else {
									menu.setGameBoard_PowerUpNamePlayer2Text("Super bellen");
								}
								((IDog) entity).setBarkLength(((IDog) entity).getBarkLength() * 2);
								Powers.remove(i);
								jukeBox.play();
							}
							else {
								level.addPowerUpIcon(entity.getPosX() + 8, entity.getPosY() + 8, 2);
								System.out.println("Sheep -> DEAF");
								((ISheep) entity).deafy(true);
								Powers.remove(i);
								jukeBox.play();
							}
						}
						else if (Powers.get(i).getType() == Constants.POWERUP_TYPE_SPEED) {
							level.addPowerUpIcon(entity.getPosX() + 8, entity.getPosY() + 8, 0);
							if (entity == Dogs.getFirst()) {
								menu.setGameBoard_PowerUpNamePlayer1Text("Schnelligkeit");
							} else if (entity == Dogs.getLast()) {
								menu.setGameBoard_PowerUpNamePlayer2Text("Schnelligkeit");
							}
							System.out.println("Entity -> SPEED");
							entity.setSpeed(entity.getSpeed() * 2);
							Powers.remove(i);
							jukeBox.play();
						}
						else if (Powers.get(i).getType() == Constants.POWERUP_TYPE_SLOW) {
							level.addPowerUpIcon(entity.getPosX() + 8, entity.getPosY() + 8, 1);
							if (entity == Dogs.getFirst()) {
								menu.setGameBoard_PowerUpNamePlayer1Text("Verlangsamung");
							} else if (entity == Dogs.getLast()) {
								menu.setGameBoard_PowerUpNamePlayer2Text("Verlangsamung");
							}
							System.out.println("Entity -> SLOW");
							entity.setSpeed(entity.getSpeed() / 2);
							Powers.remove(i);
							jukeBox.play();

						}
						else if (Powers.get(i).getType() == Constants.POWERUP_TYPE_CONFUSION) {
							level.addPowerUpIcon(entity.getPosX() + 8, entity.getPosY() + 8, 5);
							if (entity == Dogs.getFirst()) {
								menu.setGameBoard_PowerUpNamePlayer1Text("Verwirrung");
							} else if (entity == Dogs.getLast()) {
								menu.setGameBoard_PowerUpNamePlayer2Text("Verwirrung");
							}
							System.out.println("Entity -> CONFUSED");
							entity.confuse(true);
							Powers.remove(i);
							jukeBox.play();
						}
						return true;
					}
				}
			}
			
			return true;
		}
		
		return false;
	}
	
	
	public int isSheepChained () {
		int sheepPosInList = RandomGenerator.getRandomNumber(0, Sheeps.size() - 1);
		if (!Sheeps.get(sheepPosInList).isChained()) {
			return sheepPosInList;
		} else {
			return isSheepChained();
		}
	}
	
	public void portSheep(IEntity entity) {
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
