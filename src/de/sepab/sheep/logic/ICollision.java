package de.sepab.sheep.logic;

import de.sepab.sheep.entities.IEntity;

public interface ICollision {
	
	public boolean calcCollision(IEntity entitiy, int posX, int posY);
	public boolean isoccupied(int x,int y);
	public int Count(int Ax, int Ay,int Bx,int By);

}