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
         return new Obstacle(posX, posY);
      }
      else if (entityName == Constants.CAGE) {
         return new Cage(posX, posY);
      }
      else {
         return null;
      }
   }

   public PowerUp createPowerUp() {
      int x = randomGenerator.getRandomNumber(1, 1280);
      int y = randomGenerator.getRandomNumber(1, 960);
      int random = randomGenerator.getRandomNumber(1, 6);

      if (random == Constants.POWERUP_TYPE_SPEED) {
         return new PowerUp(x, y,  random);
      }
      else if (random == Constants.POWERUP_TYPE_SLOW) {
         return new PowerUp(x, y, random);
      }
      else if (random == Constants.POWERUP_TYPE_BARK) {
         return new PowerUp(x, y, random);
      }
      else if (random == Constants.POWERUP_TYPE_TELEPORT) {
         return new PowerUp(x, y, random);
      }
      else if (random == Constants.POWERUP_TYPE_CONFUSION) {
         return new PowerUp(x, y, random);
      }
      else {
         return new PowerUp(x, y, random);
      }
   }

}