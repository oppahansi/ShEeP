package de.sepab.sheep.model.corelogic;

import java.util.LinkedList;

import de.sepab.sheep.model.entities.IEntity;
import de.sepab.sheep.model.entities.ISheep;

public interface IGameBoard {
	
	public LinkedList<IEntity> getGameBoard();
	public LinkedList<IEntity> getSheep();
	public LinkedList<IEntity> getDog();
	public LinkedList<IEntity> getObstacle();
	public LinkedList<IEntity> getCage();
	public LinkedList<IEntity> getPowerUp();
	public void addSheep(IEntity sheep);
	public void addDog(IEntity dog);
	public void addObstacle(IEntity obstacle);
	public void addCage(IEntity cage);
	public void addPowerUp(IEntity powerUp);
}
