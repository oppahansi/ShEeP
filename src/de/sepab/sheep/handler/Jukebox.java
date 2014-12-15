package de.sepab.sheep.handler;

import java.io.File;
import java.io.IOException;
import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;
import javax.sound.sampled.LineUnavailableException;
import javax.swing.*;

public class Jukebox extends JApplet implements IJukebox{

	private Sequence background;
	private Sequencer player;
	private Sound bark;

	public static void main(String[] args)
		throws IOException, LineUnavailableException, InvalidMidiDataException, MidiUnavailableException, InterruptedException {
		Jukebox jukebox = new Jukebox();
		jukebox.play(Constants.SOUND_NAME_BACKGROUND);
		Thread.sleep(5000);
		jukebox.play(Constants.SOUND_NAME_BARK);
	}

	public Jukebox() throws InvalidMidiDataException, IOException, MidiUnavailableException {
		background = MidiSystem.getSequence(new File(Constants.FILE_PATH_SOUND_BACKGROUND));
		player = MidiSystem.getSequencer();
		player.setSequence(background);
		bark = new Sound(Constants.FILE_PATH_SOUND_BARK);
	}

	@Override
	public void play(final String soundName) throws IOException, LineUnavailableException, MidiUnavailableException {
		if(soundName == Constants.SOUND_NAME_BACKGROUND) {
			player.open();
			player.setLoopCount(0);  // repeat 0 times (play once)
			// player.setLoopCount(Sequencer.LOOP_CONTINUOUSLY); endless
			player.start();
		}
		if(soundName == Constants.SOUND_NAME_BARK) {
			bark.play();
		}
	}

	@Override
	public void stop(final String soundName) {
		if(soundName == Constants.SOUND_NAME_BACKGROUND) {
			player.stop();
		}
		if(soundName == Constants.SOUND_NAME_BARK) {
			bark.stop();
		}
	}

	@Override
	public void stop() {
		player.stop();
		bark.stop();
	}
}