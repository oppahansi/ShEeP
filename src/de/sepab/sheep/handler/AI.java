package de.sepab.sheep.handler;

import de.sepab.sheep.entities.IEntity;
import de.sepab.sheep.entities.ISheep;
import de.sepab.sheep.logic.*;

public class AI {
	
	/*
	 * Mitte:	0
	 * Oben:	1
	 * Rechts:	2
	 * Unten:	3
	 * Links:	4
	 */
	
	private int iq;
	private final int scariness;
	private ILevel level;
	private IMovement movementHandler;
	private ICollision collisionHandler;
	private IRandomGenerator randomGenerator = new RandomGenerator();
	
	public AI(int iq, int scariness, ILevel level, IMovement movementHandler, ICollision collisionHandler) {
		this.iq = iq;
		this.scariness = scariness;
		this.level = level;
		this.movementHandler = movementHandler;
		this.collisionHandler = collisionHandler;
	}

	public int getScariness() {
		return this.scariness;
	}

	public void makeTurns() {
		
		for(IEntity i : this.level.getSheepList())
		{
			this.movementHandler.move(i, this.execNextStep(i));
		}
	}
	
	private int execNextStep(IEntity entity) {
		if(((ISheep)entity).isScared()) {
			int z = 16;	//z ist die unschärfe
			int x = ((ISheep)entity).getScareX() - entity.getPosX();
			int y = ((ISheep)entity).getScareY() - entity.getPosY();
			//0|-|+
			if(x<z && x>-z) {
				if(y<z && y>-z) {
					//rnd
					int rnd = this.randomGenerator.getRandomNumber(1, 4);
					for(int i=0; i<((ISheep)entity).getThoughts().length/16; i++) {
						((ISheep)entity).getThoughts()[i] = rnd;
					}
				}
				else if(y<0) {
					//unten
					for(int i=0; i<((ISheep)entity).getThoughts().length/16; i++) {
						((ISheep)entity).getThoughts()[i] = 3;
					}
				}
				else if(y>0) {
					//oben
					for(int i=0; i<((ISheep)entity).getThoughts().length/16; i++) {
						((ISheep)entity).getThoughts()[i] = 1;
					}
				}
			}
			else if(x<0) {
				if(y<z && y>-z) {
					//rechts
					for(int i=0; i<((ISheep)entity).getThoughts().length/16; i++) {
						((ISheep)entity).getThoughts()[i] = 2;
					}
				}
				else if(y<0) {
					//unten rechts
					int[] tmp = {2, 3};
					int a = tmp[this.randomGenerator.getRandomNumber(0, 1)];
					int b = tmp[this.randomGenerator.getRandomNumber(0, 1)];
					for(int i=0; i<((ISheep)entity).getThoughts().length/16; i++) {
						if(i % 2 == 0) ((ISheep)entity).getThoughts()[i] = a;
						else ((ISheep)entity).getThoughts()[i] = b;
					}
				}
				else if(y>0) {
					//oben rechts
					int[] tmp = {1, 2};
					int a = tmp[this.randomGenerator.getRandomNumber(0, 1)];
					int b = tmp[this.randomGenerator.getRandomNumber(0, 1)];
					for(int i=0; i<((ISheep)entity).getThoughts().length/16; i++) {
						if(i % 2 == 0) ((ISheep)entity).getThoughts()[i] = a;
						else ((ISheep)entity).getThoughts()[i] = b;
					}
				}
			}
			else if(x>0) {
				if(y<z && y>-z) {
					//links
					for(int i=0; i<((ISheep)entity).getThoughts().length/16; i++) {
						((ISheep)entity).getThoughts()[i] = 4;
					}
				}
				else if(y<0) {
					//unten links
					int[] tmp = {3, 4};
					int a = tmp[this.randomGenerator.getRandomNumber(0, 1)];
					int b = tmp[this.randomGenerator.getRandomNumber(0, 1)];
					for(int i=0; i<((ISheep)entity).getThoughts().length/16; i++) {
						if(i % 2 == 0) ((ISheep)entity).getThoughts()[i] = a;
						else ((ISheep)entity).getThoughts()[i] = b;
					}
				}
				else if(y>0) {
					//oben links
					int[] tmp = {1, 4};
					int a = tmp[this.randomGenerator.getRandomNumber(0, 1)];
					int b = tmp[this.randomGenerator.getRandomNumber(0, 1)];
					for(int i=0; i<((ISheep)entity).getThoughts().length/16; i++) {
						if(i % 2 == 0) ((ISheep)entity).getThoughts()[i] = a;
						else ((ISheep)entity).getThoughts()[i] = b;
					}
				}
			}
		}
		else {
			//Normal thoughts
			this.calcNextSteps((ISheep)entity);
		}
		//
		this.checkNextStep(entity);
		//Buffer leeren und ausführen
		int tmp = ((ISheep)entity).getThoughts()[0];
		for(int i=1; i<((ISheep)entity).getThoughts().length; i++) {
			((ISheep)entity).getThoughts()[i-1] = ((ISheep)entity).getThoughts()[i];
			if(i+1==((ISheep)entity).getThoughts().length) ((ISheep)entity).getThoughts()[i] = 0;
		}
		return tmp;
	}

	private void calcNextSteps(ISheep sheep) {
		//Do sane shit here
		if(sheep.getThoughts()[0] == 0) {
			//
			int tmp = this.randomGenerator.getRandomNumber(0, 4);
			//
			for(int i=0; i<sheep.getThoughts().length; i++) {
				sheep.getThoughts()[i] = tmp;
			}
		}
	}

	private void checkNextStep(IEntity entity) {
		int[] z = {0};
		boolean t = false;
		switch(((ISheep)entity).getThoughts()[0]){
			case(1):
				entity.setRotation(((ISheep)entity).getThoughts()[0]);
				if (!(this.collisionHandler.calcCollision(entity,entity.getPosX(),entity.getPosY()-entity.getSpeed())))
				{
					z = new int[]{2, 3, 4};
					t = true;
					((ISheep)entity).scare(false, 0, 0);
				}
				break;
			case(2):
				entity.setRotation(((ISheep)entity).getThoughts()[0]);
				if (!(this.collisionHandler.calcCollision(entity,entity.getPosX()+entity.getSpeed(),entity.getPosY())))
				{
					z = new int[]{1, 3, 4};
					t = true;
					((ISheep)entity).scare(false, 0, 0);
				}
				break;
			case(3):
				entity.setRotation(((ISheep)entity).getThoughts()[0]);
				if (!(this.collisionHandler.calcCollision(entity,entity.getPosX(),entity.getPosY()+entity.getSpeed())))
				{
					z = new int[]{1, 2, 4};;
					t = true;
					((ISheep)entity).scare(false, 0, 0);
				}
				break;
			case(4):
				entity.setRotation(((ISheep)entity).getThoughts()[0]);
				if (!(this.collisionHandler.calcCollision(entity,entity.getPosX()-entity.getSpeed(),entity.getPosY())))
				{
					z = new int[]{1, 2, 3};
					t = true;
					((ISheep)entity).scare(false, 0, 0);
				}
				break;
		}
		if(t) {
			int tmp = this.randomGenerator.getRandomNumber(0, 2);
			for (int i = 0; i < 16; i++) {
				((ISheep) entity).getThoughts()[i] = z[tmp];
			}
		}
	}

}
