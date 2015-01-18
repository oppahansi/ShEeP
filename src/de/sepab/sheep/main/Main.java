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

		Menu menu = new Menu();
		menu.setDataLoader(new DataLoader());
		menu.setLevel(new Level());
		menu.setTimer(new Timer());
		menu.setCollision(new Collision(menu.level.getDogList(), menu.level.getSheepList(), menu.level.getPowerUpList(), menu.level.getObstacleList(),menu.level.getCageList(), menu.getWidth(), menu.getHeight()));
		menu.setMovement(new Movement(menu.getCollision()));
		menu.setInput(new Input(menu.getMovement(), menu.getLevel().getDogList()));
		menu.setAi(new AI(100, 1, menu.getLevel(), menu.getMovement(), menu.getCollision()));
		menu.run();
			
	}
	
	

}
