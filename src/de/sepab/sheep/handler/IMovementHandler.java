package de.sepab.sheep.handler;

import de.sepab.sheep.entities.IEntity;

public interface IMovementHandler {
	
	public void move(IEntity entity, int direction);
	
}
