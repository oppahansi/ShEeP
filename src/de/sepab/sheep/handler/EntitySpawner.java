package de.sepab.sheep.handler;

import de.sepab.sheep.entities.*;
import de.sepab.sheep.logic.Timer;

public class EntitySpawner implements IEntitySpawner{


	
    public EntitySpawner() {
        Timer timer = new Timer();
    }

    public IEntity spawn(String entityName, int posX, int posY, int spritePos) {
        if (entityName == Constants.DOG) {
            return new Dog(posX, posY, null, 5);	//damm
        } else if (entityName == Constants.SHEEP) {
            return new Sheep(posX, posY);
        } else if (entityName == Constants.POWER_UP) {
            return new PowerUp(posX, posY);
        } else if (entityName == Constants.OBSTACLE) {
            return new Obstacle(posX, posY);
        } else if (entityName == Constants.CAGE) {
            return new Cage(posX, posY);
        } else {
            return null;
        }
    }
}