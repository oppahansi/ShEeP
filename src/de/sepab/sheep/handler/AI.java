package de.sepab.sheep.handler;

import de.sepab.sheep.entities.IEntity;
import de.sepab.sheep.entities.ISheep;
import de.sepab.sheep.logic.*;

public class AI implements IAI{
	
	/*
	 * Mitte:	0
	 * Oben:	1
	 * Rechts:	2
	 * Unten:	3
	 * Links:	4
	 */
	
	private int iq;
	private final int scariness = 1;
	private int scareLength;
	private ILevel level;
	private IMovement movementHandler;
	private ICollision collisionHandler;


	public AI(int iq, int scareLength, ILevel level, IMovement movementHandler, ICollision collisionHandler) {
		this.iq = iq;
		this.scareLength = scareLength;
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

	@Override
	public int getIq() {
		return this.iq;
	}

	@Override
	public void setIq(int iq) {
		this.iq = iq;
	}

	@Override
	public int getScareLength() {
		return this.scareLength;
	}

	@Override
	public void setScareLength(int scareLength) {
		this.scareLength = scareLength;
	}

	private int execNextStep(IEntity entity) {
		if(((ISheep)entity).isScared()) {
			int z = 16;	//z ist die unschärfe
			int x = ((ISheep)entity).getScareX() - entity.getPosX();
			int y = ((ISheep)entity).getScareY() - entity.getPosY();
			if(!((ISheep) entity).isDeaf()) {
				//0|-|+
				if (x < z && x > -z) {
					if (y < z && y > -z) {
						//rnd
						int rnd = RandomGenerator.getRandomNumber(1, 4);
						for (int i = 0; i < ((ISheep) entity).getThoughts().length / scareLength; i++) {
							((ISheep) entity).getThoughts()[i] = rnd;
						}
					} else if (y < 0) {
						//unten
						for (int i = 0; i < ((ISheep) entity).getThoughts().length / scareLength; i++) {
							((ISheep) entity).getThoughts()[i] = 3;
						}
					} else if (y > 0) {
						//oben
						for (int i = 0; i < ((ISheep) entity).getThoughts().length / scareLength; i++) {
							((ISheep) entity).getThoughts()[i] = 1;
						}
					}
				} else if (x < 0) {
					if (y < z && y > -z) {
						//rechts
						for (int i = 0; i < ((ISheep) entity).getThoughts().length / scareLength; i++) {
							((ISheep) entity).getThoughts()[i] = 2;
						}
					} else if (y < 0) {
						//unten rechts
						int[] tmp = {2, 3};
						int a = tmp[RandomGenerator.getRandomNumber(0, 1)];
						int b = tmp[RandomGenerator.getRandomNumber(0, 1)];
						for (int i = 0; i < ((ISheep) entity).getThoughts().length / scareLength; i++) {
							if (i % 2 == 0) ((ISheep) entity).getThoughts()[i] = a;
							else ((ISheep) entity).getThoughts()[i] = b;
						}
					} else if (y > 0) {
						//oben rechts
						int[] tmp = {1, 2};
						int a = tmp[RandomGenerator.getRandomNumber(0, 1)];
						int b = tmp[RandomGenerator.getRandomNumber(0, 1)];
						for (int i = 0; i < ((ISheep) entity).getThoughts().length / scareLength; i++) {
							if (i % 2 == 0) ((ISheep) entity).getThoughts()[i] = a;
							else ((ISheep) entity).getThoughts()[i] = b;
						}
					}
				} else if (x > 0) {
					if (y < z && y > -z) {
						//links
						for (int i = 0; i < ((ISheep) entity).getThoughts().length / scareLength; i++) {
							((ISheep) entity).getThoughts()[i] = 4;
						}
					} else if (y < 0) {
						//unten links
						int[] tmp = {3, 4};
						int a = tmp[RandomGenerator.getRandomNumber(0, 1)];
						int b = tmp[RandomGenerator.getRandomNumber(0, 1)];
						for (int i = 0; i < ((ISheep) entity).getThoughts().length / scareLength; i++) {
							if (i % 2 == 0) ((ISheep) entity).getThoughts()[i] = a;
							else ((ISheep) entity).getThoughts()[i] = b;
						}
					} else if (y > 0) {
						//oben links
						int[] tmp = {1, 4};
						int a = tmp[RandomGenerator.getRandomNumber(0, 1)];
						int b = tmp[RandomGenerator.getRandomNumber(0, 1)];
						for (int i = 0; i < ((ISheep) entity).getThoughts().length / scareLength; i++) {
							if (i % 2 == 0) ((ISheep) entity).getThoughts()[i] = a;
							else ((ISheep) entity).getThoughts()[i] = b;
						}
					}
				}
			}
		}
		else if(((ISheep)entity).isChained()) {
			this.calcChainedSteps((ISheep)entity);
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
			//Power-Up greadyness
			int tmp = RandomGenerator.getRandomNumber(1, 4);
			//
			for(int i=0; i<sheep.getThoughts().length; i++) {
				sheep.getThoughts()[i] = tmp;
			}
		}
	}

	private void calcChainedSteps(ISheep sheep) {
		int tmp = 0;
		if(RandomGenerator.getPercentDistribution(iq, 7)) {
			if(((IEntity)sheep).getPosX() <= 480) {
				tmp = 2;
			}
			else {
				tmp = 4;
			}
		}
		for(int i=0; i<16; i++) {
			sheep.getThoughts()[i] = tmp;
		}
	}

	private void checkNextStep(IEntity entity) {
		int unschearfe = 64;
		int[] possibleNextSteps = {0};
		boolean collides = false;
		switch(((ISheep)entity).getThoughts()[0]){
			case(1):
				entity.setRotation(((ISheep)entity).getThoughts()[0]);
				if (!(this.collisionHandler.calcCollision(entity,entity.getPosX(),entity.getPosY()-entity.getSpeed())))
				{
					possibleNextSteps = new int[]{2, 3, 4};
					collides = true;
					((ISheep) entity).unscare();
				}
				if(entity.getPosY() <= unschearfe) {
					possibleNextSteps = new int[]{3, 3, 3, 3, 3, 2, 4};
					collides = true;
					((ISheep)entity).unscare();
				}
				break;
			case(2):
				entity.setRotation(((ISheep)entity).getThoughts()[0]);
				if (!(this.collisionHandler.calcCollision(entity,entity.getPosX()+entity.getSpeed(),entity.getPosY())))
				{
					if(!entity.isChained()) {
						possibleNextSteps = new int[]{1, 3, 4};
						collides = true;
						((ISheep) entity).unscare();
					}
					else {
						collides = true;
						if(entity.getPosY() <= 640/2) {
							possibleNextSteps = new int[]{3};
						}
						else {
							possibleNextSteps = new int[]{1};
						}
					}
				}
				if(entity.getPosX() >= 960-unschearfe) {
					possibleNextSteps = new int[]{4, 4, 4, 4, 4, 1, 3};
					collides = true;
					((ISheep)entity).unscare();
				}
				break;
			case(3):
				entity.setRotation(((ISheep)entity).getThoughts()[0]);
				if (!(this.collisionHandler.calcCollision(entity,entity.getPosX(),entity.getPosY()+entity.getSpeed())))
				{
					possibleNextSteps = new int[]{1, 2, 4};
					collides = true;
					((ISheep) entity).unscare();
				}
				if(entity.getPosY() >= 640-unschearfe) {
					possibleNextSteps = new int[]{1, 1, 1, 1, 1, 2, 4};
					collides = true;
					((ISheep)entity).unscare();
				}
				break;
			case(4):
				entity.setRotation(((ISheep)entity).getThoughts()[0]);
				if (!(this.collisionHandler.calcCollision(entity,entity.getPosX()-entity.getSpeed(),entity.getPosY())))
				{
					if(!entity.isChained()) {
						possibleNextSteps = new int[]{1, 2, 3};
						collides = true;
						((ISheep) entity).unscare();
					}
					else {
						collides = true;
						if(entity.getPosY() <= 960/2) {
							possibleNextSteps = new int[]{3};
						}
						else {
							possibleNextSteps = new int[]{1};
						}
					}
				}
				if(entity.getPosX() <= unschearfe) {
					possibleNextSteps = new int[]{2, 2, 2, 2, 2, 1, 3};
					collides = true;
					((ISheep)entity).unscare();
				}
				break;
		}
		if(collides) {
			int tmp = RandomGenerator.getRandomNumber(0, possibleNextSteps.length-1);
			for (int i = 0; i < ((ISheep)entity).getThoughts().length; i++) {
				((ISheep) entity).getThoughts()[i] = possibleNextSteps[tmp];
			}
		}
	}

}
