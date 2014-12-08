package de.sepab.sheep.handler;

import java.util.LinkedList;

import de.sepab.sheep.entities.IEntity;
import de.sepab.sheep.entities.ISheep;
import de.sepab.sheep.logic.ICollision;
import de.sepab.sheep.logic.IMovement;
import de.sepab.sheep.logic.IRandomGenerator;
import de.sepab.sheep.logic.RandomGenerator;

public class AI {
	
	/*
	 * Mitte:	0
	 * Oben:	1
	 * Rechts:	2
	 * Unten:	3
	 * Links:	4
	 */
	
	private int iq;
	private int loss;
	private LinkedList<IEntity> sheeps;
	private IMovement movementHandler;
	private ICollision collisionHandler;
	private IRandomGenerator randomGenerator = new RandomGenerator();
	
	public AI(int iq, int loss, LinkedList<IEntity> sheeps, IMovement movementHandler, ICollision collisionHandler) {
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
		int nextStep = this.sanityCheck(entity);
		this.checkPath(sheep.getThoughts());
		return nextStep;
	}
	
	private int sanityCheck(IEntity sheep) {
		boolean[] possibleSteps = {false, false, false, false};
		int[] realNextSteps;
		int n = 0;
		int step = 0;
		int tmpX = 0, tmpY = 0;
		switch(((ISheep)sheep).getThoughts()[0]) {
		case (0):
			break;
		case (1):
			tmpY=1;
			break;
		case (2):
			tmpX=1;
			break;
		case (3):
			tmpY=-1;
			break;
		case (4):
			tmpX=-1;
			break;
		}
		if(!this.collisionHandler.calcCollision(sheep, sheep.getX()+tmpX, sheep.getY()+tmpY)) {
			step = ((ISheep)sheep).getThoughts()[0];
		}
		else {
			if(!this.collisionHandler.calcCollision(sheep, sheep.getX(), sheep.getY()+1)) possibleSteps[0]=true;
			if(!this.collisionHandler.calcCollision(sheep, sheep.getX()+1, sheep.getY())) possibleSteps[1]=true;
			if(!this.collisionHandler.calcCollision(sheep, sheep.getX(), sheep.getY()-1)) possibleSteps[2]=true;
			if(!this.collisionHandler.calcCollision(sheep, sheep.getX()-1, sheep.getY())) possibleSteps[3]=true;
			for(int i=0; i<possibleSteps.length;i++) {
				if(possibleSteps[i]) n++;
			}
			realNextSteps = new int[n];
			n=0;
			for(int i=0; i<possibleSteps.length; i++) {
				if(possibleSteps[i]) {
					realNextSteps[n]=i;
					n++;
				}
			}
			if(realNextSteps.length == 0) step=0;
			else {
				step=realNextSteps[randomGenerator.getRandomNumber(0, (realNextSteps.length-1))];
			}
		}
		if(((ISheep)sheep).isScared()) {
			int chance = this.randomGenerator.getRandomNumberDistrubution(this.iq, this.loss);
			if(!(chance > -this.loss && chance < this.loss)) {
				step=0;
			}
		}
		return step;
	}
	
	private void checkPath(int[] thoughts) {
		if(thoughts[4] == 0) {
			int chance = this.randomGenerator.getRandomNumberDistrubution(this.iq, this.loss);
			if(!(chance > -this.loss && chance < this.loss)) {
				for(int i=0; i<5; i++) {
					thoughts[i] = this.randomGenerator.getRandomNumber(1, 4);
				}
			}
			else {
				int tmp = this.randomGenerator.getRandomNumber(1, 4);
				for(int i=0; i<4; i++) {
					thoughts[i] = tmp;
				}
			}
		}
		else {
			for(int i=0; i<4; i++) {
				thoughts[i] = thoughts[i+1];
			}
			thoughts[4] = thoughts[this.randomGenerator.getRandomNumber(0, 3)];
		}
	}
	
}
