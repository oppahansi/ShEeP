package de.sepab.sheep.model.entities;

public interface IEntity {
    public int getPosX();
    public void setPosX();
    public int getPosY();
    public void setPosY();
    public int[] getSprite();
    

    public void event();
    public void move();

}
