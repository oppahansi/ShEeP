package de.sepab.sheep.handler;

import de.sepab.sheep.entities.Cage;
import de.sepab.sheep.entities.Dog;
import de.sepab.sheep.entities.IEntity;
import de.sepab.sheep.entities.Obstacle;
import de.sepab.sheep.entities.PowerUp;
import de.sepab.sheep.entities.Sheep;
import de.sepab.sheep.logic.RandomGenerator;

public class EntitySpawner implements IEntitySpawner {

   private int random;
   private RandomGenerator randomGenerator;

   public EntitySpawner(int gameMod) {

   }

   public IEntity spawn(String entityName, int posX, int posY, int spritePos) {
      if (entityName == Constants.SHEEP) {
         return new Sheep(posX, posY);
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

   public PowerUp spawnPowerUp() {
      int x = randomGenerator.getRandomNumber(1, 1280);
      int y = randomGenerator.getRandomNumber(1, 960);
      random = randomGenerator.getRandomNumber(1, 6);

      if (random == Constants.POWERUP_TYPE_SPEED) {
         return createPowerUp(x, y, random);
      } else if (random == Constants.POWERUP_TYPE_SLOW) {
         return createPowerUp(x, y, random);
      } else if (random == Constants.POWERUP_TYPE_BARK) {
         return createPowerUp(x, y, random);
      } else if (random == )
   }

   private PowerUp createPowerUp(int x, int y, int type) {
      return new PowerUp(x, y, 0, type);
   }
}