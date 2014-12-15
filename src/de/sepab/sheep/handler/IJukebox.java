package de.sepab.sheep.handler;

import java.io.IOException;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.sampled.LineUnavailableException;

public interface IJukebox {

   public void play(String soundName) throws IOException, LineUnavailableException, MidiUnavailableException;

   public void stop(String soundName);

   public void stop();
}