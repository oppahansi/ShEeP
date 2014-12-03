package de.sepab.sheep.model.corelogic;

import de.sepab.sheep.model.entities.IEntity;

import java.util.LinkedList;

public class GameBoard implements IGameBoard{
    private LinkedList<IEntity> sheepList = new LinkedList<>();
    private LinkedList<IEntity> dogList = new LinkedList<>();
    private LinkedList<IEntity> obstacleList = new LinkedList<>();

	@Override
	public LinkedList<IEntity> getGameBoard() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LinkedList<IEntity> getSheep() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LinkedList<IEntity> getDog() {
		// TODO Auto-generated method stub
		return dogList;
	}

	@Override
	public LinkedList<IEntity> getObstacle() {
		// TODO Auto-generated method stub
		return obstacleList;
	}

	@Override
	public LinkedList<IEntity> getCage() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LinkedList<IEntity> getPowerUp() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addSheep(IEntity sheep) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addDog(IEntity dog) {
		dogList.add(dog);
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addObstacle(IEntity obstacle) {
		// TODO Auto-generated method stub
		obstacleList.add(obstacle);
		
	}

	@Override
	public void addCage(IEntity cage) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addPowerUp(IEntity powerUp) {
		// TODO Auto-generated method stub
		
	}



}
