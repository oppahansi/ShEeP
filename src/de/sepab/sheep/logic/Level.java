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
		swingTimer = new javax.swing.Timer(16, this);
		swingTimer.stop();
		timer = new Timer();
		timer.stop();
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
	
	public void getGameBaord(GameBoard gameBoard){
		this.gameBoard = gameBoard;
	}
	
	public void actionPerformed(ActionEvent arg0) {
//		System.out.print("test");
//		System.out.print(timer.getTime() + "");
		switch (gameModus) {
		case ONTIME:
//			if (timer.getTime() >= 60) {
//				swingTimer.stop();
//				timer.stop();
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
		input.makeTurns();
		gameBoard.repaint();
		
	}

	@Override
	public void TimerStart() {
		swingTimer.start();
		timer.start();
		// TODO Auto-generated method stub
		
	}
}


