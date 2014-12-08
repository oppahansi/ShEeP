package de.sepab.sheep.logic;

import java.util.LinkedList;

import de.sepab.sheep.entities.Cage;
import de.sepab.sheep.entities.Dog;
import de.sepab.sheep.entities.Obstacle;
import de.sepab.sheep.entities.PowerUp;
import de.sepab.sheep.entities.Sheep;

public interface ILevel {
	public LinkedList<Sheep> getSheepList();
	
	public LinkedList<Dog> getDogList();
	
	

	public LinkedList<PowerUp> getPowerUpList();
	
	public LinkedList<Obstacle> getObstacleList();
	
	public LinkedList<Cage> getCageList();

	

	public void addDog(int x, int y, int sprite);
	
	public void addSheep(int x, int y, int sprite);
	
	public void addPowerUp(int x, int y, int sprite) ;
	
	public void addObstacle(int x, int y, int sprite) ;
	
	public void addCage(int x, int y, int sprite);
}
