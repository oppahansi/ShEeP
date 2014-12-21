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
//		level.addDog(32*15, 64);
//		level.addDog(32*18, 64);
//		level.addSheep(128, 32);
//		level.addSheep(128, 96);
//		level.addSheep(128, 144);
//		level.addSheep(128, 240);
//		for (int x = 0; x < 25; x++) {
//			for (int y = 0; y < 15; y++) {
//				level.addSheep(128 + x*32, 32 + y*32);
//			}
//		}
		
//		level.addSheep(32*3, 0);
//		level.addSheep(32*4, 0);
//		level.addSheep(32*5, 0);
//		level.addSheep(32*6, 0);
//		level.addSheep(32*7, 0);
//		level.addSheep(32*8, 0);
//		
//		level.addSheep(32*2, 32);
//		level.addSheep(32*3, 32);
//		level.addSheep(32*8, 32);
//		level.addSheep(32*9, 32);
//		
//		level.addSheep(32, 32*2);
//		level.addSheep(32*2, 32*2);
//		level.addSheep(32*9, 32*2);
//		level.addSheep(32*10, 32*2);
//		
//		level.addSheep(32, 32*3);
//		level.addSheep(32*10, 32*3);
//		
//		level.addSheep(32, 32*4);
//		level.addSheep(32*2, 32*4);
//		level.addSheep(32*7, 32*4);
//		level.addSheep(32*10, 32*4);
//		
//		level.addSheep(32, 32*5);
//		level.addSheep(32*2, 32*5);
//		level.addSheep(32*7, 32*5);
//		level.addSheep(32*10, 32*5);
//		
//		level.addSheep(32, 32*6);
//		level.addSheep(32*2, 32*6);
//		level.addSheep(32*3, 32*6);
//		level.addSheep(32*7, 32*6);
//		level.addSheep(32*8, 32*6);
//		level.addSheep(32*10, 32*6);
//		
//		level.addSheep(32, 32*7);
//		level.addSheep(32*2, 32*7);
//		level.addSheep(32*3, 32*7);
//		level.addSheep(32*5, 32*7);
//		level.addSheep(32*7, 32*7);
//		level.addSheep(32*8, 32*7);
//		level.addSheep(32*10, 32*7);
//		
//		level.addSheep(32, 32*8);
//		level.addSheep(32*4, 32*8);
//		level.addSheep(32*10, 32*8);
//		
//		level.addSheep(32, 32*9);
//		level.addSheep(32*3, 32*9);
//		level.addSheep(32*10, 32*9);
//		
//		level.addSheep(32, 32*10);
//		level.addSheep(32*4, 32*10);
//		level.addSheep(32*5, 32*10);
//		level.addSheep(32*10, 32*10);
//		
//		level.addSheep(32, 32*11);
//		level.addSheep(32*10, 32*11);
//		
//		level.addSheep(32, 32*12);
//		level.addSheep(32*2, 32*12);
//		level.addSheep(32*3, 32*12);
//		level.addSheep(32*4, 32*12);
//		level.addSheep(32*5, 32*12);
//		level.addSheep(32*6, 32*12);
//		level.addSheep(32*10, 32*12);
//		
//		level.addSheep(32, 32*13);
//		level.addSheep(32*10, 32*13);
//		
//		level.addSheep(32, 32*14);
//		level.addSheep(32*6, 32*14);
//		level.addSheep(32*8, 32*14);
//		level.addSheep(32*10, 32*14);
//		
//		level.addSheep(32, 32*15);
//		level.addSheep(32*6, 32*15);
//		level.addSheep(32*8, 32*15);
//		level.addSheep(32*10, 32*15);
//		level.addSheep(32*18, 32*15);
//		level.addSheep(32*19, 32*15);
//		level.addSheep(32*20, 32*15);
//		
//		level.addSheep(32, 32*16);
//		level.addSheep(32*6, 32*16);
//		level.addSheep(32*8, 32*16);
//		level.addSheep(32*10, 32*16);
//		level.addSheep(32*11, 32*16);
//		level.addSheep(32*17, 32*16);
//		level.addSheep(32*18, 32*16);
//		level.addSheep(32*20, 32*16);
//		
//		level.addSheep(32, 32*17);
//		level.addSheep(32*6, 32*17);
//		level.addSheep(32*8, 32*17);
//		level.addSheep(32*11, 32*17);
//		level.addSheep(32*13, 32*17);
//		level.addSheep(32*14, 32*17);
//		level.addSheep(32*15, 32*17);
//		level.addSheep(32*16, 32*17);
//		level.addSheep(32*17, 32*17);
//		level.addSheep(32*20, 32*17);
//		
//		level.addSheep(32, 32*18);
//		level.addSheep(32*6, 32*18);
//		level.addSheep(32*8, 32*18);
//		level.addSheep(32*11, 32*18);
//		level.addSheep(32*12, 32*18);
//		level.addSheep(32*16, 32*18);
//		level.addSheep(32*18, 32*18);
//		level.addSheep(32*19, 32*18);
//		
//		level.addSheep(32, 32*19);
//		level.addSheep(32*5, 32*19);
//		level.addSheep(32*9, 32*19);
//		level.addSheep(32*11, 32*19);
//		level.addSheep(32*13, 32*19);
//		level.addSheep(32*14, 32*19);
//		level.addSheep(32*15, 32*19);
//		level.addSheep(32*19, 32*19);
//		
//		level.addSheep(32, 32*20);
//		level.addSheep(32*6, 32*20);
//		level.addSheep(32*8, 32*20);
//		level.addSheep(32*12, 32*20);
//		level.addSheep(32*16, 32*20);
//		level.addSheep(32*18, 32*20);
//		level.addSheep(32*19, 32*20);
//		
//		level.addSheep(32, 32*21);
//		level.addSheep(32*2, 32*21);
//		level.addSheep(32*7, 32*21);
//		level.addSheep(32*16, 32*21);
//		level.addSheep(32*19, 32*21);
//		
//		level.addSheep(32*2, 32*22);
//		level.addSheep(32*16, 32*22);
//		level.addSheep(32*17, 32*22);
//		level.addSheep(32*18, 32*22);
//		level.addSheep(32*19, 32*22);
//		
//		level.addSheep(32*2, 32*23);
//		level.addSheep(32*3, 32*23);
//		level.addSheep(32*17, 32*23);
//		
//		level.addSheep(32*2, 32*24);
//		level.addSheep(32*3, 32*24);
//		level.addSheep(32*4, 32*24);
//		level.addSheep(32*14, 32*24);
//		level.addSheep(32*15, 32*24);
//		level.addSheep(32*16, 32*24);
//		
//		level.addSheep(32, 32*25);
//		level.addSheep(32*2, 32*25);
//		level.addSheep(32*4, 32*25);
//		level.addSheep(32*5, 32*25);
//		level.addSheep(32*6, 32*25);
//		level.addSheep(32*7, 32*25);
//		level.addSheep(32*8, 32*25);
//		level.addSheep(32*10, 32*25);
//		level.addSheep(32*11, 32*25);
//		level.addSheep(32*12, 32*25);
//		level.addSheep(32*13, 32*25);
//		
//		level.addSheep(0, 32*26);
//		level.addSheep(32*2, 32*26);
//		level.addSheep(32*4, 32*26);
//		level.addSheep(32*7, 32*26);
//		level.addSheep(32*8, 32*26);
//		level.addSheep(32*10, 32*26);
//		
//		level.addSheep(0, 32*27);
//		level.addSheep(32*4, 32*27);
//		level.addSheep(32*6, 32*27);
//		level.addSheep(32*8, 32*27);
//		level.addSheep(32*10, 32*27);
//		
//		level.addSheep(32, 32*28);
//		level.addSheep(32*2, 32*28);
//		level.addSheep(32*3, 32*28);
//		level.addSheep(32*4, 32*28);
//		level.addSheep(32*6, 32*28);
//		level.addSheep(32*10, 32*28);
//		
//		level.addSheep(32*7, 32*29);
//		level.addSheep(32*8, 32*29);
//		level.addSheep(32*9, 32*29);
//		level.addSheep(32*10, 32*29);
		
		
		
		
		
		ITimer timer = new Timer();
		timer.stop();

		
		
		
		ICollision collision = new Collision(level.getDogList(), level.getSheepList(), level.getPowerUpList(), level.getObstacleList(),1280,960);
		IMovement movement = new Movement(collision);
		Input input = new Input(movement, level.getDogList());
		Menu menu = new Menu(dataLoader);
		IRandomGenerator randomGenerator = new RandomGenerator();
		AI ai = new AI(100, 5, level.getSheepList(), movement, collision);
		
		
		menu.run(level, randomGenerator, collision, movement, input, ai, timer);
			
	}
	
	

}
