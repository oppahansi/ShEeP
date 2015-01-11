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

   public void event(IEntity entity) {
      switch (this.type) {
         case Constants.POWERUP_TYPE_SPEED:
            entity.setSpeed(10);
            setVisible(false);
            break;
         case Constants.POWERUP_TYPE_SLOW:
            entity.setSpeed(2);
            setVisible(false);
            break;
         case Constants.POWERUP_TYPE_DEAF:
            if (entity instanceof ISheep) {
               ((ISheep) entity).deafy(true);
               setVisible(false);
            }
            break;
         case Constants.POWERUP_TYPE_BEAM:
            if (entity instanceof ISheep) {
               entity.setPosX(150);
               entity.setPosY(300);
               setVisible(false);
            }
            break;
         case Constants.POWERUP_TYPE_TIME:
            if (entity instanceof IDog) {
               // add time here
               setVisible(false);
            }
            break;
         case Constants.POWERUP_TYPE_CONFUSION:
            if (entity instanceof IDog) {
               entity.confuse(true);
               setVisible(false);
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