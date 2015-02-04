package de.sepab.sheep.logic;

import static org.junit.Assert.*;
import de.sepab.sheep.logic.Collision;
import de.sepab.sheep.entities.*;
import java.util.LinkedList;
import org.junit.Test;

public class CollisionTest {
	
	
	Sheep sheep1 = new Sheep (80, 80, 1, 0, 1);
	Sheep sheep2 = new Sheep (160,160, 1, 0, 1);
	Sheep sheep3 = new Sheep (800, 800, 1, 0, 1);
	Sheep sheep4 = new Sheep (350, 350, 1, 0, 1);
	Dog dog1 = new Dog (300, 300, 1, 0, null, 1);
	Dog dog2 = new Dog (400, 400, 1, 0, null, 1);
	LinkedList<IEntity> dogList = new LinkedList<IEntity>();
	LinkedList<IEntity> cageList = new LinkedList<IEntity>();
	LinkedList<IEntity> powerUpList = new LinkedList<IEntity>();
	LinkedList<IEntity> obstacleList = new LinkedList<IEntity>();
	LinkedList<IEntity> sheepList = new LinkedList<IEntity>();

	
	Collision c = new Collision (dogList, sheepList, powerUpList, obstacleList, cageList, 1000, 1000);
	
	@Test
	public void testCount1(){
		dogList.add(dog1);
		dogList.add(dog2);
		sheepList.add(sheep1);
		sheepList.add(sheep2);
		sheepList.add(sheep3);
		int counted = c.Count(40, 40, 400, 400);
		int expected = 2;
		assertEquals ("Zwei Schafe im Gehege", expected, counted);
		sheepList.add(sheep4);
		expected = 3;
		counted = c.Count(40, 40, 400, 400);
		assertEquals ("Drei Schafe im Gehege", expected, counted);
	}
	
	@Test
	public void testCount2() {
		dogList.add(dog1);
		dogList.add(dog2);
		sheepList.add(sheep1);
		sheepList.add(sheep2);
		sheepList.add(sheep3);
		int counted = c.Count(40,40, 400, 400,700, 700, 900, 900);
		int expected = 2001;
		assertEquals ("Drei Schafe in den Gehegen", expected, counted);
		sheepList.add(sheep4);
		expected = 3001;
		counted = c.Count(40,40, 400, 400, 700, 700, 900, 900);
		assertEquals ("Vier Schafe in den Gehegen", expected, counted);
	}
	
	@Test
	public void testCalcCollision() {
		dogList.add(dog1);
		dogList.add(dog2);
		sheepList.add(sheep1);
		sheepList.add(sheep2);
		sheepList.add(sheep3);
		sheepList.add(sheep4);
		boolean actual = c.calcCollision(dog1, 800, 800);
		boolean expected = false;
		assertEquals ("Kollision", actual, expected);
		actual =  c.calcCollision (dog1, 769, 769);
		assertEquals ("Kollision", actual, expected);
		actual =  c.calcCollision (dog1, 768, 769);
		expected = true;
		assertEquals ("Keine Kollision", actual, expected);
	}

	@Test
	public void testPortSheep() {
		boolean expected = false;
		boolean actual = (sheep1.getPosX() != 80 || sheep1.getPosY() != 80);
		assertEquals ("Schaf wurde noch nicht teleportiert", expected, actual);
		c.portSheep(sheep1);
		expected = true;
		actual = (sheep1.getPosX() != 80 || sheep1.getPosY() != 80);
		assertEquals ("Schaf wurde teleportiert", expected, actual);
	}
	
	
	@Test
	public void testIsoccupied() {
		dogList.add(dog1);
		dogList.add(dog2);
		sheepList.add(sheep1);
		sheepList.add(sheep2);
		sheepList.add(sheep3);
		boolean actual = c.isoccupied(800, 800);
		boolean expected = false;
		assertEquals ("Standort ist besetzt", actual, expected);
		actual = c.isoccupied(500, 500);
		expected = true;
		assertEquals ("Standort ist frei", actual, expected);
		actual = c.isoccupied(600, 600);
		expected = true;
		assertEquals ("Standort ist frei", actual, expected);
	
	}


}
