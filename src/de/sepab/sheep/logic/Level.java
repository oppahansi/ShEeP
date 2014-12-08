package de.sepab.sheep.logic;

import java.util.LinkedList;

import de.sepab.sheep.entities.*;
import de.sepab.sheep.handler.EntitySpawner;
import de.sepab.sheep.handler.IEntitySpawner;

public class Level implements ILevel {
	
	public LinkedList<Dog> getDogList() {
		return new LinkedList<Dog>();
	}
	
	public LinkedList<Sheep> getSheepList() {
		return new LinkedList<Sheep>();
	}

	public LinkedList<PowerUp> getPowerUpList() {
		return new LinkedList<PowerUp>();
	}
	
	public LinkedList<Obstacle> getObstacleList() {
		return new LinkedList<Obstacle>();
	}
	
	public LinkedList<Cage> getCageList() {
		return new LinkedList<Cage>();
	}

	public Level() {

	}

	public void addDog(int x, int y, int sprite) {

	}
	
	public void addSheep(Sheep sheep){
		
	}
	
	public void addPowerUp(PowerUp powerUp) {
		
	}
	
	public void addObstacle(Obstacle obstacle) {
		
	}
	
	public void addCage(Cage cage) {
		
	}
	
	
}
