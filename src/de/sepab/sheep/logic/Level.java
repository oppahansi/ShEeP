package de.sepab.sheep.logic;

import java.util.LinkedList;

import de.sepab.sheep.entities.*;
import de.sepab.sheep.handler.EntitySpawner;
import de.sepab.sheep.handler.IEntitySpawner;

public class Level implements ILevel {
	
	LinkedList<Dog> dogList = new LinkedList<>();
	LinkedList<Sheep> sheepList = new LinkedList<>();
	LinkedList<PowerUp> powerUpList = new LinkedList<>();
	LinkedList<Obstacle> obstacleList = new LinkedList<>();
	LinkedList<Cage> cageList = new LinkedList<>();
	
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
		dogList.add(new Dog(x, y, sprite));
	}
	
	public void addSheep(int x, int y, int sprite){
		sheepList.add(new Sheep(x, y, sprite));
	}
	
	public void addPowerUp(int x, int y, int sprite) {
		powerUpList.add(new PowerUp(x, y, sprite));
	}
	
	public void addObstacle(int x, int y, int sprite) {
		obstacleList.add(new Obstacle(x, y, sprite));
	}
	
	public void addCage(int x, int y, int sprite) {
		cageList.add(new Cage(x, y, sprite));
	}
	
	
}
