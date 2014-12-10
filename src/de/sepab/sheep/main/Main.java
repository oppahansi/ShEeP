package de.sepab.sheep.main;

import de.sepab.sheep.display.Menu;
import de.sepab.sheep.handler.DataLoader;
import de.sepab.sheep.handler.Input;
import de.sepab.sheep.logic.Level;
import de.sepab.sheep.logic.RandomGenerator;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		DataLoader dl = new DataLoader();
		dl.loadHighscore();
		Input input = new Input();
		Menu menu = new Menu(dl, input);
		RandomGenerator rg = new RandomGenerator();
		Level lvl = new Level();
		menu.run(lvl, rg);
	}

}
