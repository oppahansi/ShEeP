package de.sepab.sheep.handler;

import de.sepab.sheep.entities.PowerUp;
import de.sepab.sheep.logic.IRandomGenerator;
import de.sepab.sheep.logic.RandomGenerator;

public class EntitySpawner implements IEntitySpawner {

   private IRandomGenerator randomGenerator;

   public EntitySpawner() {
      randomGenerator = new RandomGenerator();
   }

   public PowerUp createPowerUp(int posX, int posY) {
      int random = randomGenerator.getRandomNumber(1, 6);

      if (random == Constants.POWERUP_TYPE_SPEED) {
         return new PowerUp(posX, posY, random);
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