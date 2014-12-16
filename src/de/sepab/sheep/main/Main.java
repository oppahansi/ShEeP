package de.sepab.sheep.main;


import de.sepab.sheep.display.GameBoard;
import de.sepab.sheep.display.Menu;
import de.sepab.sheep.handler.AI;
import de.sepab.sheep.handler.DataLoader;
import de.sepab.sheep.handler.IDataLoader;
import de.sepab.sheep.handler.IInput;
import de.sepab.sheep.handler.Input;
import de.sepab.sheep.logic.Collision;
import de.sepab.sheep.logic.ICollision;
import de.sepab.sheep.logic.ILevel;
import de.sepab.sheep.logic.IMovement;
import de.sepab.sheep.logic.IRandomGenerator;
import de.sepab.sheep.logic.ITimer;
import de.sepab.sheep.logic.Level;
import de.sepab.sheep.logic.Movement;
import de.sepab.sheep.logic.RandomGenerator;
import de.sepab.sheep.logic.Timer;

public class Main {
	

	
	public Main() {
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		IDataLoader dataLoader = new DataLoader();
		dataLoader.loadHighscore();
		ILevel level = new Level();
		level.addDog(32, 32);
		level.addSheep(128, 32);
		ITimer timer = new Timer();
		timer.stop();

		
		
		ICollision collision = new Collision(level.getDogList(), level.getSheepList(), level.getPowerUpList(), level
			.getObstacleList(),1280, 960);
		IMovement movement = new Movement(collision);
		Input input = new Input(movement, level.getDogList());
		Menu menu = new Menu(dataLoader);
		IRandomGenerator randomGenerator = new RandomGenerator();
		AI ai = new AI(100, 5, level.getSheepList(), movement, collision);
		
		
		menu.run(level, randomGenerator, collision, movement, input, ai, timer);
			
	}
	
	

}
