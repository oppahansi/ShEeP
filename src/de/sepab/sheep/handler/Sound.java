package de.sepab.sheep.handler;

import java.io.File;
import java.io.IOException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Sound {

   private AudioInputStream audioInputStream;
   private Clip clip;

   public Sound(String soundFilePath) {
      try {
         audioInputStream = AudioSystem.getAudioInputStream(new File(soundFilePath).getAbsoluteFile());
         clip = AudioSystem.getClip();
      }
      catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
         e.printStackTrace();
      }
   }

   public void play() throws IOException, LineUnavailableException {
      this.clip.open(audioInputStream);
      this.clip.start();
   }

   public void stop() {
      this.clip.stop();
      this.clip.close();
   }
}