package de.sepab.sheep.logic;

import java.util.LinkedList;

import de.sepab.sheep.display.GameBoard;
import de.sepab.sheep.display.Menu;
import de.sepab.sheep.entities.*;
import de.sepab.sheep.handler.AI;
import de.sepab.sheep.handler.EntitySpawner;
import de.sepab.sheep.handler.IEntitySpawner;
import de.sepab.sheep.handler.IInput;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Level implements ILevel, ActionListener{

	private IEntitySpawner entitySpawner;

	public enum GameModus {
		ONTIME, ONCOUNT, MULTIPLAYER
	}

	LinkedList<IEntity> dogList = new LinkedList<>();
	LinkedList<IEntity> sheepList = new LinkedList<>();
	LinkedList<IEntity> powerUpList = new LinkedList<>();
	LinkedList<IEntity> obstacleList = new LinkedList<>();
	LinkedList<IEntity> cageList = new LinkedList<>();


	GameModus gameModus = GameModus.ONTIME;
	AI ai;
	GameBoard gameBoard;
	javax.swing.Timer swingTimer;
	ITimer timer;
	IInput input;
	ICollision collision;
	Menu menu;

	int time = 10, count = 0;
	boolean locked_1 = false;
	boolean locked_2 = false;

	public void getReferences(AI ai, GameBoard gameBoard, ITimer timer,IInput input, ICollision collision, Menu menu) {
		this.ai = ai;
		this.gameBoard = gameBoard;
		this.timer = timer;
		this.input = input;
		this.collision = collision;
		this.menu = menu;
	}

	public LinkedList<IEntity> getDogList() {
		return dogList;
	}

	public LinkedList<IEntity> getSheepList() {
		return sheepList;
	}

	public LinkedList<IEntity> getPowerUpList() {
		return powerUpList;
	}

	public LinkedList<IEntity> getObstacleList() {
		return obstacleList;
	}

	public LinkedList<IEntity> getCageList() {
		return cageList;
	}

	public Level() {
		entitySpawner = new EntitySpawner();
		swingTimer = new javax.swing.Timer(33, this);
		swingTimer.stop();
		timer = new Timer();
	}


	public void addDog(int x, int y, int speed, int powerUpLife) {
		dogList.add(new Dog(x, y, speed, powerUpLife, this.sheepList, 100));
	}

	public void addSheep(int x, int y, int speed, int powerUplIfe){
		sheepList.add(new Sheep(x, y, speed, powerUplIfe));
	}


	public void addPowerUp() {
		powerUpList.add(entitySpawner.createPowerUp(50, 50));
	}
	
	public void addObstacle(int x, int y, int sprite) {
		obstacleList.add(new Obstacle(x, y, sprite));
	}
	
	public void addCage(int x, int y) {
		cageList.add(new Cage(x, y));
	}

	public void getGameBaord(GameBoard gameBoard){
		this.gameBoard = gameBoard;
	}

	private void reducePowerUpTime() {
		if((this.timer.getTime() % 10 == 0) && !(this.locked_1) && (this.timer.getTime() != 0)) {
			this.locked_1 = true;
			for (IEntity i : this.dogList) {
				i.decrementPowerUpLife();
			}
			for (IEntity i : this.sheepList) {
				i.decrementPowerUpLife();
			}
		}
		else if(this.timer.getTime() % 11 == 0) {
			this.locked_1 = false;
		}
		for (IEntity i : this.dogList) {
			((IDog)i).checkPowerUpLife();
		}
		for (IEntity i : this.sheepList) {
			((ISheep)i).checkPowerUpLife();
		}
	}

	private void unscareSheeps() {
		if((this.timer.getTime() % ai.getScariness() == 0) && !(this.locked_2) && (this.timer.getTime() != 0)) {
			for (IEntity i : this.sheepList) {
				((ISheep)i).scare(false, 0, 0);
			}
		}
		else if(this.timer.getTime() % ai.getScariness()+1 == 0){
			this.locked_2 = false;
		}
	}

	public void actionPerformed(ActionEvent arg0) {
		//System.out.print("test");
		timer.start();
		//System.out.print(timer.getTime() + "");
		switch (gameModus) {
		case ONTIME:
//			if ((timer.getTime() + time) <= 0) {
//				swingTimer.stop();
//				timer.stop();
//				System.out.print("ende");
//			}
			break;
		case ONCOUNT:
			break;
		case MULTIPLAYER:
			break;

		default:
			break;
		}

		//
		//System.out.println(this.collision.Count(0, 0, 32, 32));
		//
		
		this.reducePowerUpTime();
		this.unscareSheeps();
		input.makeTurn();
		ai.makeTurns();
		gameBoard.repaint();
		menu.setGameBoardTime(timer.getTime());
//		count++;
//		if(timer)
	}

	@Override
	public void TimerStart() {
		swingTimer.start();
		timer.reset();
	}

	@Override
	public void resetLists() {
		this.dogList.clear();
		this.sheepList.clear();
		this.obstacleList.clear();
		this.powerUpList.clear();
		this.cageList.clear();
	}

	@Override
	public void removeDog(IEntity entity) {
		dogList.remove(entity);
		
	}

	@Override
	public void removeSheep(IEntity entity) {
		sheepList.remove(entity);
	}

	@Override
	public void removePowerUp(IEntity entity) {
		powerUpList.remove(entity);
	}

	@Override
	public void removeObstacle(IEntity entity) {
		obstacleList.remove(entity);
	}

	@Override
	public void removeCage(IEntity entity) {
		cageList.remove(entity);
	}

	@Override
	public void resetLevel() {
		this.resetLists();
		this.swingTimer.restart();
		this.swingTimer.stop();
		this.timer.reset();
	}
}


