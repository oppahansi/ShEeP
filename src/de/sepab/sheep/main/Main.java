package de.sepab.sheep.main;


import de.sepab.sheep.view.menu.Menu;


import de.sepab.sheep.model.corelogic.DataLoader;
import de.sepab.sheep.model.corelogic.GameBoard;
import de.sepab.sheep.model.corelogic.RandomGenerator;
import de.sepab.sheep.model.entities.IEntity;
import de.sepab.sheep.model.entities.Obstacle;
import de.sepab.sheep.model.entities.Player;
import de.sepab.sheep.model.entities.Sheep;


public class Main {

    public static void main(String[] args){
    	DataLoader dl = new DataLoader();
    	GameBoard gb = new GameBoard();
    	RandomGenerator rg = new RandomGenerator();
    	int[] dogSprite = {0,0};
    	Player player1 = new Player(50, 50, dogSprite);
    	Player player2 = new Player(100, 100, dogSprite);
//    	int[] i = {0,64};
//    	Obstacle obstacle1 = new Obstacle(32,32, i);
//    	int[] j = {32,0};
//    	Obstacle obstacle2 = new Obstacle(64,32, j);
//    	int[] k = {64,0};
//    	Obstacle obstacle3 = new Obstacle(96,32, k);
//    	int[] l = {32,32};
//    	Obstacle obstacle4 = new Obstacle(32,64, l);
//    	int[] m = {0,128};
//    	Obstacle obstacle5 = new Obstacle(32,96, m);
//    	Obstacle obstacle6 = new Obstacle(64,96, j);
//    	Obstacle obstacle7 = new Obstacle(96,96, k);
//    	
    	gb.addDog(player1);
    	gb.addDog(player2);
//    	gb.addObstacle(obstacle1);
//    	gb.addObstacle(obstacle2);
//    	gb.addObstacle(obstacle3);
//    	gb.addObstacle(obstacle4);
//    	gb.addObstacle(obstacle5);
//    	gb.addObstacle(obstacle6);
//    	gb.addObstacle(obstacle7);
    	Menu.run(gb, dl, rg);
    }
}