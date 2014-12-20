package de.sepab.sheep.logic;

import java.util.LinkedList;

import de.sepab.sheep.display.GameBoard;
import de.sepab.sheep.entities.Cage;
import de.sepab.sheep.entities.Dog;
import de.sepab.sheep.entities.IEntity;
import de.sepab.sheep.entities.Obstacle;
import de.sepab.sheep.entities.PowerUp;
import de.sepab.sheep.entities.Sheep;
import de.sepab.sheep.handler.AI;
import de.sepab.sheep.handler.IInput;

public interface ILevel {
	public LinkedList<IEntity> getSheepList();
	
	public LinkedList<IEntity> getDogList();
	
	

	public LinkedList<IEntity> getPowerUpList();
	
	public LinkedList<IEntity> getObstacleList();
	
	public LinkedList<IEntity> getCageList();

	public void resetLists();

	public void addDog(int x, int y);
	
	public void addSheep(int x, int y);
	
	public void addPowerUp(int x, int y);
	
	public void addObstacle(int x, int y, int sprite);
	
	public void addCage(int x, int y);
	
	public void getReferences(AI ai, GameBoard gameBoard, ITimer timer,IInput input);
	
	public void TimerStart();
}
