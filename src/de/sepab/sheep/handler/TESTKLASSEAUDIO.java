package de.sepab.sheep.handler;

import java.util.HashMap;
import java.util.Map;

public class TESTKLASSEAUDIO {

   public static void main(String[] args) throws InterruptedException {
      Map<String, IJukeBox> sounds = new HashMap<>();

      sounds.put(Constants.SOUND_NAME_BACKGROUND, new JukeBox(Constants.FILE_PATH_SOUND_BACKGROUND));
      sounds.put(Constants.SOUND_NAME_BARK, new JukeBox(Constants.FILE_PATH_SOUND_BARK));

      sounds.get(Constants.SOUND_NAME_BACKGROUND).play();
      Thread.sleep(5000);
      sounds.get(Constants.SOUND_NAME_BARK).play();
      Thread.sleep(5000);
      sounds.get(Constants.SOUND_NAME_BARK).play();
      Thread.sleep(20000);
   }
}
