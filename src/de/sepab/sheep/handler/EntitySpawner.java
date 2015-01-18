package de.sepab.sheep.handler;

import de.sepab.sheep.entities.PowerUp;
import de.sepab.sheep.logic.RandomGenerator;

public class EntitySpawner implements IEntitySpawner {

   public PowerUp createPowerUp(int posX, int posY) {
      int powerType = RandomGenerator.getRandomNumber(1, 5);

      if (powerType == Constants.POWERUP_TYPE_SPEED) {
         return new PowerUp(posX, posY, powerType);
      }
      else if (powerType == Constants.POWERUP_TYPE_SLOW) {
         return new PowerUp(posX, posY, powerType);
      }
      else if (powerType == Constants.POWERUP_TYPE_BEAM) {
         return new PowerUp(posX, posY, powerType);
      }
      else if (powerType == Constants.POWERUP_TYPE_DEAF) {
         return new PowerUp(posX, posY, powerType);
      }
      else {
         return new PowerUp(posX, posY, powerType);
      }
   }
}