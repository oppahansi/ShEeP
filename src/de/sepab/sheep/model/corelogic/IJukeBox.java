package de.sepab.sheep.model.corelogic;

import java.io.InputStream;

public interface IJukeBox {
    public void play(String soundFileName);
    public void stop();
    public void stop(String soundFileName);
}
