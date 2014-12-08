package de.sepab.sheep.handler;

import de.sepab.sheep.entities.*;

public class EntitySpawner {

    public IEntity spawn(String entityName) {
        if (entityName == Constants.DOG) {
            return new Dog();
        } else if (entityName == Constants.SHEEP) {
            return new Sheep();
        } else if (entityName == Constants.POWER_UP) {
            return new PowerUp();
        } else if (entityName == Constants.OBSTACLE) {
            return new Obstacle();
        } else if (entityName == Constants.CAGE) {
            return new Cage();
        } else {
            return null;
        }
    }
}