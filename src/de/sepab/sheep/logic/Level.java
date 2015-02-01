package de.sepab.sheep.logic;

import java.util.LinkedList;

import de.sepab.sheep.display.GameBoard;
import de.sepab.sheep.display.Menu;
import de.sepab.sheep.entities.*;
import de.sepab.sheep.handler.AI;
import de.sepab.sheep.handler.Constants;
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

	private LinkedList<IEntity> dogList = new LinkedList<>();
	private LinkedList<IEntity> sheepList = new LinkedList<>();
	private LinkedList<IEntity> powerUpList = new LinkedList<>();
	private LinkedList<IEntity> obstacleList = new LinkedList<>();
	private LinkedList<IEntity> cageList = new LinkedList<>();
	private LinkedList<IEntity> PowerUpIconList = new LinkedList<>();


	private GameModus gameModus = GameModus.ONTIME;
	private AI ai;
	private GameBoard gameBoard;
	private javax.swing.Timer swingTimer;
	private ITimer timer;
	private IInput input;
	private ICollision collision;
	private Menu menu;
	private String name;
	

	int time = 100, count = 0;
	boolean locked_1 = false;
	boolean locked_2 = false;
	boolean spwaned = false;
	public void getReferences(AI ai, GameBoard gameBoard, ITimer timer,IInput input, ICollision collision, Menu menu, String name, GameModus gameModus) {
		this.ai = ai;
		this.gameBoard = gameBoard;
		this.timer = timer;
		this.input = input;
		this.collision = collision;
		this.menu = menu;
		this.name = name;
		this.gameModus = gameModus;
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
	
	public LinkedList<IEntity> getPowerUpIconList() {
		return this.PowerUpIconList;
	}
	
	

	public Level() {
		entitySpawner = new EntitySpawner();
		swingTimer = new javax.swing.Timer(33, this);
		swingTimer.stop();
		timer = new Timer();
	}


	public void addDog(int x, int y, int speed, int powerUpLife, int barkLength) {
		dogList.add(new Dog(x, y, speed, powerUpLife, this.sheepList, barkLength));
	}

	public void addSheep(int x, int y, int speed, int powerUplIfe, int scareSpeed){
		sheepList.add(new Sheep(x, y, speed, powerUplIfe, scareSpeed));
	}


	public void addPowerUp() {
        int posX = RandomGenerator.getRandomNumber(0, menu.getWidth() - 32);
        int posY = RandomGenerator.getRandomNumber(0, menu.getHeight() - 32);
        if (!collision.isoccupied(posX, posY)) {
        	addPowerUp();
            return;
		}
        powerUpList.add(entitySpawner.createPowerUp(posX, posY));
    }
	
	public void spawnSheep() {
		 int posX = RandomGenerator.getRandomNumber(0, menu.getWidth() - 32);
	     int posY = RandomGenerator.getRandomNumber(0, menu.getHeight() - 32);
	     if (!collision.isoccupied(posX, posY)) {
	        spawnSheep();
	        return;
		}
	   addSheep(posX, posY, menu.getSheep().getSpeed(), menu.getSheep().getPowerUpLife(), menu.getSheep().getScareSpeed());
	}
	
	public void addObstacle(int x, int y, int sprite) {
		obstacleList.add(new Obstacle(x, y, sprite));
	}
	
	public void addCage(int x, int y, int x2, int y2) {
		cageList.add(new Cage(x, y, x2, y2));
	}
	
	public void addPowerUpIcon(int x, int y, int type) {
		this.PowerUpIconList.add(new PowerUpIcon(x, y, type));
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
				((ISheep)i).unscare();
			}
		}
		else if(this.timer.getTime() % ai.getScariness()+1 == 0){
			this.locked_2 = false;
		}
	}
	
	
	private void unlockLevel(){
		if (menu.getDataLoader().getLevel() == 2) {
			menu.getDataLoader().setLevel(3);
		}
		if (menu.getDataLoader().getLevel() == 1) {
			menu.getDataLoader().setLevel(2);
		}
		System.out.println("" + menu.getDataLoader().getLevel());
	}

	public void actionPerformed(ActionEvent arg0) {
		//System.out.print("test");
		timer.start();
		//System.out.print(timer.getTime() + "");
		


		if ((timer.getTime()%20) == 0) {
			if (spwaned == false) {
				this.addPowerUp();
				spwaned = true;
			}else{
				spwaned = true;
			}
		}else{
			spwaned = false;
		}
		
		switch (gameModus) {
		case ONTIME:
			menu.setGameBoardTime(this.time - timer.getTime());
			int sheep = this.collision.Count(this.cageList.getFirst().getPosX(),
					 this.cageList.getFirst().getPosY(),
					 ((ICage) this.cageList.getFirst()).getPosX2(),
					 ((ICage)this.cageList.getFirst()).getPosY2());
			menu.setGameBoardSheep1(sheep);
			if (sheep >= sheepList.size()) {
				spawnSheep();
			}
			if ((timer.getTime() - time) >= 0) {
				swingTimer.stop();
				boolean newHighscore = menu.getDataLoader().addHighscore(name, sheep, Constants.SPLAYER_TIME, menu.getMap());
				unlockLevel();
				menu.getDataLoader().saveHighscore();
				menu.getJukeBox().stop();
				menu.setSinglePlayerEndScreen(name, sheep, "Schafe", newHighscore);
			}
			break;
		case ONCOUNT:
			menu.setGameBoardTime(timer.getTime());
			int count = this.collision.Count(this.cageList.getFirst().getPosX(),
					 this.cageList.getFirst().getPosY(),
					 ((ICage) this.cageList.getFirst()).getPosX2(),
					 ((ICage)this.cageList.getFirst()).getPosY2());
			menu.setGameBoardSheep1(count);
			if (count >= sheepList.size()) {
				swingTimer.stop();
				boolean newHighscore = menu.getDataLoader().addHighscore(name, time, Constants.SPLAYER_COUNT, menu.getMap());
				menu.getDataLoader().saveHighscore();
				unlockLevel();
				menu.getJukeBox().stop();
				menu.setSinglePlayerEndScreen(name, time, "Sekunden", newHighscore);
			}
			break;
		case MULTIPLAYER:
			menu.setGameBoardTime(this.time - timer.getTime());
			int sheepCount = this.collision.Count(this.cageList.getFirst().getPosX(),
					 this.cageList.getFirst().getPosY(),
					 ((ICage) this.cageList.getFirst()).getPosX2(),
					 ((ICage)this.cageList.getFirst()).getPosY2(),
					 this.cageList.getLast().getPosX(),
					 this.cageList.getLast().getPosY(),
					 ((ICage) this.cageList.getLast()).getPosX2(),
					 ((ICage)this.cageList.getLast()).getPosY2());
					 menu.setGameBoardSheep1(sheepCount/1000);
					 menu.setGameBoardSheep2(sheepCount%1000);
					 if ((sheepCount/1000 + sheepCount%1000 + 2) >= sheepList.size()) {
							spawnSheep();
						}
			if ((timer.getTime() - time) >= 0) {
				swingTimer.stop();
				menu.getJukeBox().stop();
				String winner;
				if (sheepCount/1000 > sheepCount%1000) {
					winner = "Player 1 wins";
				}else if (sheepCount/1000 < sheepCount%1000) {
					winner = "Player 2 wins";
				} else {
					winner = "Draw";
				}
				menu.setMultiPlayerEndScreen(winner);
			}
			break;

		default:
			break;
		}

		//
		//System.out.println(this.collision.Count(0, 0, 64, 64));
		//
		
		this.reducePowerUpTime();
		this.unscareSheeps();
		this.UpdatePowerUpIcons();
		input.makeTurn();
		ai.makeTurns();
		gameBoard.repaint();
		
//		count++;
//		if(timer)
	}
	
	public int calcHighscore(){
		int i = this.collision.Count(this.cageList.getFirst().getPosX(),
				 this.cageList.getFirst().getPosY(),
				 ((ICage) this.cageList.getFirst()).getPosX2(),
				 ((ICage)this.cageList.getFirst()).getPosY2()) * (this.time - timer.getTime() + 10);
				 return i;
	}


	public void TimerStart() {
		swingTimer.start();
		timer.reset();
	}


	public void resetLists() {
		this.dogList.clear();
		this.sheepList.clear();
		this.obstacleList.clear();
		this.powerUpList.clear();
		this.cageList.clear();
	}


	public void removeDog(IEntity entity) {
		dogList.remove(entity);
		
	}

	public void removeSheep(IEntity entity) {
		sheepList.remove(entity);
	}

	public void removePowerUp(IEntity entity) {
		powerUpList.remove(entity);
	}

	public void removeObstacle(IEntity entity) {
		obstacleList.remove(entity);
	}

	public void removeCage(IEntity entity) {
		cageList.remove(entity);
	}
	
	public void removePowerUpIcon(IEntity entity) {
		this.PowerUpIconList.remove(entity);
	}
	
	private void UpdatePowerUpIcons() {
		for (IEntity powerUpIcon: PowerUpIconList) {
			((IPowerUpIcon)powerUpIcon).setLife(((IPowerUpIcon)powerUpIcon).getLife() - 1);
		}
		int temp = PowerUpIconList.size();
		int count = 0;
		for (int i = 0; i < temp; i++) {
			if (((IPowerUpIcon)PowerUpIconList.get(i - count)).getLife() <= 3) {
				count++;
				PowerUpIconList.remove(PowerUpIconList.get(i));
			}
		}
		for (IEntity powerUpIcon: PowerUpIconList) {
			((IPowerUpIcon)powerUpIcon).calculateSprite();
		}
	}


	public void resetLevel() {
		this.resetLists();
		this.swingTimer.restart();
		this.swingTimer.stop();
		this.timer.reset();
	}
}
	

	
	


