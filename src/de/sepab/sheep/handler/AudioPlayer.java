package de.sepab.sheep.handler;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class AudioPlayer implements IAudioPlayer {

   private Clip clip;

   public AudioPlayer(String filePath) {

      try {
         AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(getClass().getResourceAsStream(filePath));
         AudioFormat baseFormat = audioInputStream.getFormat();
         AudioFormat decodeFormat = new AudioFormat(
            AudioFormat.Encoding.PCM_SIGNED,
            baseFormat.getSampleRate(),
            16,
            baseFormat.getChannels(),
            baseFormat.getChannels() * 2,
            baseFormat.getSampleRate(),
            false
         );
         AudioInputStream decodedAudioInputStream = AudioSystem.getAudioInputStream(decodeFormat, audioInputStream);
         clip = AudioSystem.getClip();
         clip.open(decodedAudioInputStream);
      }
      catch (Exception e) {
         e.printStackTrace();
      }

   }

   @Override
   public void play() {
      if (clip == null) {
         return;
      }
      stop();
      clip.setFramePosition(0);
      clip.start();
   }

   @Override
   public void stop() {
      if (clip.isRunning()) {
         clip.stop();
      }
   }

   @Override
   public void close() {
      stop();
      clip.close();
   }
}