package de.sepab.sheep.logic;

import java.util.LinkedList;

import de.sepab.sheep.display.GameBoard;
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

	int time = 10, count = 0;
	boolean locked = false;

	public void getReferences(AI ai, GameBoard gameBoard, ITimer timer,IInput input) {
		this.ai = ai;
		this.gameBoard = gameBoard;
		this.timer = timer;
		this.input = input;
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
		powerUpList.add(entitySpawner.createPowerUp());
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
		if((this.timer.getTime() % 10 == 0) && !(this.locked) && (this.timer.getTime() != 0)) {
			this.locked = true;
			for (IEntity i : this.dogList) {
				i.decrementPowerUpLife();
			}
			for (IEntity i : this.sheepList) {
				i.decrementPowerUpLife();
			}
		}
		else if(this.timer.getTime() % 11 == 0) {
			this.locked=false;
		}
		for (IEntity i : this.dogList) {
			((IDog)i).checkPowerUpLife();
		}
		for (IEntity i : this.sheepList) {
			((ISheep)i).checkPowerUpLife();
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
			this.reducePowerUpTime();
			break;
		case ONCOUNT:
			break;
		case MULTIPLAYER:
			break;

		default:
			break;
		}



		input.makeTurn();
		ai.makeTurns();
		gameBoard.repaint();
//		count++;
//		if(timer)
	}

	@Override
	public void TimerStart() {
		swingTimer.start();
		timer.reset()	;
		// TODO Auto-generated method stub

	}

	@Override
	public void resetLists() {
		this.dogList = new LinkedList<>();
		this.sheepList = new LinkedList<>();
		this.obstacleList = new LinkedList<>();
		this.powerUpList = new LinkedList<>();
		this.cageList = new LinkedList<>();
		// TODO Auto-generated method stub
		
	}
}


