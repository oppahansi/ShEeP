package de.sepab.sheep.handler.movement;

import java.util.LinkedList;

import de.sepab.sheep.entities.IEntity;
import de.sepab.sheep.entities.ISheep;
import de.sepab.sheep.handler.data.IRandomGenerator;
import de.sepab.sheep.handler.data.RandomGenerator;

public class AI {
	
	private int iq;
	private int loss;
	private LinkedList<IEntity> sheeps;
	private IMovementHandler movementHandler;
	private ICollisionHandler collisionHandler;
	private IRandomGenerator randomGenerator = new RandomGenerator();
	
	public AI(int iq, int loss, LinkedList<IEntity> sheeps, IMovementHandler movementHandler, ICollisionHandler collisionHandler) {
		this.iq = iq;
		this.loss = loss;
		this.sheeps = sheeps;
		this.movementHandler = movementHandler;
		this.collisionHandler = collisionHandler;
	}
	
	public void makeTurns() {
		for(IEntity i : this.sheeps)
		{
			this.movementHandler.move(i, this.calcNextStep(i));
		}
	}
	
	private int calcNextStep(IEntity entity) {
		ISheep sheep = (ISheep)entity;
		int nextStep = this.snityCheck(sheep.getThoughts());
		this.checkPath(sheep.getThoughts());
		return nextStep;
	}
	
	private int snityCheck(int[] thoughts) {
		return 0;
	}
	
	private void checkPath(int[] thoughts) {
		
	}
	
}
