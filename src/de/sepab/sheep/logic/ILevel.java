package de.sepab.sheep.logic;

import java.util.LinkedList;

import de.sepab.sheep.display.GameBoard;
import de.sepab.sheep.display.Menu;
import de.sepab.sheep.entities.IEntity;
import de.sepab.sheep.handler.AI;
import de.sepab.sheep.handler.IInput;

public interface ILevel {
	public LinkedList<IEntity> getSheepList();
	
	public LinkedList<IEntity> getDogList();
	
	

	public LinkedList<IEntity> getPowerUpList();
	
	public LinkedList<IEntity> getObstacleList();
	
	public LinkedList<IEntity> getCageList();

	public void resetLists();
	
	public void resetLevel();

	public void addDog(int x, int y, int speed, int powerUpLife);
	
	public void addSheep(int x, int y, int speed, int powerUpLife);
	
	public void addPowerUp();
	
	public void addObstacle(int x, int y, int sprite);
	
	public void addCage(int x, int y);
	
	public void removeDog(IEntity entity);
	
	public void removeSheep(IEntity entity);
	
	public void removePowerUp(IEntity entity);
	
	public void removeObstacle(IEntity entity);
	
	public void removeCage(IEntity entity);

	public void getReferences(AI ai, GameBoard gameBoard, ITimer timer,IInput input, ICollision collision, Menu menu);
	
	public void TimerStart();
}
