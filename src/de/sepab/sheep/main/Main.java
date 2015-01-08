package de.sepab.sheep.main;


import de.sepab.sheep.display.Menu;
import de.sepab.sheep.handler.AI;
import de.sepab.sheep.handler.DataLoader;
import de.sepab.sheep.handler.Input;
import de.sepab.sheep.logic.Collision;
import de.sepab.sheep.logic.Level;
import de.sepab.sheep.logic.Movement;
import de.sepab.sheep.logic.RandomGenerator;
import de.sepab.sheep.logic.Timer;

public class Main {
	

	
	public Main() {
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

		Menu.setDataLoader(new DataLoader());
		Menu.getDataLoader().loadHighscore();
		Menu.setLevel(new Level());
		Menu.setTimer(new Timer());
		Menu.setCollision(new Collision(Menu.level.getDogList(), Menu.level.getSheepList(), Menu.level.getPowerUpList(), Menu.level.getObstacleList(), 1280, 960));
		Menu.setMovement(new Movement(Menu.getCollision()));
		Menu.setInput(new Input(Menu.getMovement(), Menu.getLevel().getDogList()));
		Menu.setRandomGenerator(new RandomGenerator());
		Menu.setAi(new AI(100, 5, Menu.getLevel(), Menu.getMovement(), Menu.getCollision()));
		Menu.run();
			
	}
	
	

}
