/**
 * @Author
 * Alexander Schellenberg
 */

package de.sepab.sheep.entities;

public class PowerUp extends Entity {

   private int type;
   private boolean visibility = true;

   public PowerUp(int posX, int posY, int type) {
      super(posX, posY, 0, 0);
      this.type = type;
   }

   @Override
   public int getType() {
      return type;
   }

   @Override
   public boolean isChained() {
      return false;
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