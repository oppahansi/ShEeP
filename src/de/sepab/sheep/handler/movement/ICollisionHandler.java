package de.sepab.sheep.handler.movement;

import de.sepab.sheep.entities.IEntity;

public interface ICollisionHandler {
	
	public boolean calcCollision(IEntity entitiy, int posX, int posY);
	
}
