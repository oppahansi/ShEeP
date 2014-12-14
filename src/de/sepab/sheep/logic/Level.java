package de.sepab.sheep.logic;

import java.util.LinkedList;

import de.sepab.sheep.display.GameBoard;
import de.sepab.sheep.entities.*;
import de.sepab.sheep.handler.AI;
import de.sepab.sheep.handler.IInput;
import de.sepab.sheep.main.Main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Level implements ILevel, ActionListener{
	
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
	int time = 60, count = 0;
	
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
		swingTimer = new javax.swing.Timer(33, this);
		swingTimer.stop();
		timer = new Timer();
		timer.stop();
	}

	public void addDog(int x, int y) {
		dogList.add(new Dog(x, y));
	}
	
	public void addSheep(int x, int y){
		sheepList.add(new Sheep(x, y));
	}
	
	public void addPowerUp(int x, int y) {
		powerUpList.add(new PowerUp(x, y));
	}
	
	public void addObstacle(int x, int y) {
		obstacleList.add(new Obstacle(x, y));
	}
	
	public void addCage(int x, int y) {
		cageList.add(new Cage(x, y));
	}
	
	public void getGameBaord(GameBoard gameBoard){
		this.gameBoard = gameBoard;
	}
	
	public void actionPerformed(ActionEvent arg0) {
//		System.out.print("test");
		timer.start();
//		System.out.print(timer.getTime() + "");
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
}


