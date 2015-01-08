package de.sepab.sheep.handler;

import de.sepab.sheep.entities.IEntity;

public interface IEntitySpawner {

    public IEntity spawn(String name, int x, int y, int sprite);
    public IEntity createPowerUp(int posX, int posY);

}
