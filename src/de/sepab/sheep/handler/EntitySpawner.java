package de.sepab.sheep.handler;

import de.sepab.sheep.entities.Cage;
import de.sepab.sheep.entities.IEntity;
import de.sepab.sheep.entities.Obstacle;
import de.sepab.sheep.entities.PowerUp;
import de.sepab.sheep.entities.Sheep;
import de.sepab.sheep.logic.IRandomGenerator;
import de.sepab.sheep.logic.RandomGenerator;

public class EntitySpawner implements IEntitySpawner {

   private IRandomGenerator randomGenerator;

   public EntitySpawner() {
      randomGenerator = new RandomGenerator();
   }

   public IEntity spawn(String entityName, int posX, int posY, int spritePos) {
      if (entityName == Constants.SHEEP) {
         return new Sheep(posX, posY, 3, 0);
      }
      else if (entityName == Constants.OBSTACLE) {
         return new Obstacle(posX, posY, 0);
      }
      else if (entityName == Constants.CAGE) {
         return new Cage(posX, posY);
      }
      else {
         return null;
      }
   }

   public PowerUp createPowerUp(int posX, int posY) {
      int random = 1;//randomGenerator.getRandomNumber(1, 5);

      if (random == Constants.POWERUP_TYPE_SPEED) {
         return new PowerUp(posX, posY,  random);
      }
      else if (random == Constants.POWERUP_TYPE_SLOW) {
         return new PowerUp(posX, posY, random);
      }
      else if (random == Constants.POWERUP_TYPE_BEAM) {
         return new PowerUp(posX, posY, random);
      }
      else if (random == Constants.POWERUP_TYPE_TIME) {
         return new PowerUp(posX, posY, random);
      }
      else {
         return new PowerUp(posX, posY, random);
      }

   }

}