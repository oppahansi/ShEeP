package de.sepab.sheep.entities;

import de.sepab.sheep.handler.Constants;

public class PowerUp extends Entity {

   private int type;
   private boolean visibility = true;

   public PowerUp(int posX, int posY, int type) {
      super(posX, posY, 0, 0);
      this.type = type;
   }

   public int getType() {
      return type;
   }

   @Override
   public boolean isChained() {
      return false;
   }

   public void event(IEntity entity) {
      switch (this.type) {
         case Constants.POWERUP_TYPE_SPEED:
            if(entity instanceof ISheep) {
               ((ISheep)entity).setAddSpeed(10);
            }
            else {
               entity.setSpeed(10);
            }
            break;
         case Constants.POWERUP_TYPE_SLOW:
            entity.setSpeed(2);
            break;
         case Constants.POWERUP_TYPE_DEAF:
            if (entity instanceof ISheep) {
               ((ISheep) entity).deafy(true);
            }
            break;
         case Constants.POWERUP_TYPE_TIME:
            if (entity instanceof IDog) {
               // add time here
            }
            break;
         case Constants.POWERUP_TYPE_CONFUSION:
            if (entity instanceof IDog) {
               entity.confuse(true);
            }
            break;
      }
   }

   @Override
   public void setVisible(final boolean visibility) {
      this.visibility = visibility;
   }

   @Override
   public boolean isVisible() {
      return visibility;
   }
}