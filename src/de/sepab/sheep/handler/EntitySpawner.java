package de.sepab.sheep.handler;

import de.sepab.sheep.entities.*;
import de.sepab.sheep.handler.Constants;

public class EntitySpawner implements IEntitySpawner{

	@Override
	public IEntity spawn(String name, int x, int y, int sprite) {
		// TODO Auto-generated method stub
		return null;
	}

//    public IEntity spawn(String entityName, int posX, int posY, int spritePos) {
//        if (entityName == Constants.DOG) {
//            return new Dog(posX, posY, spritePos);
//        } else if (entityName == Constants.SHEEP) {
//            return new Sheep(posX, posY, spritePos);
//        } else if (entityName == Constants.POWER_UP) {
//            return new PowerUp(posX, posY, spritePos);
//        } else if (entityName == Constants.OBSTACLE) {
//            return new Obstacle(posX, posY, spritePos);
//        } else if (entityName == Constants.CAGE) {
//            return new Cage(posX, posY, spritePos);
//        } else {
//            return null;
//        }
//    }
}