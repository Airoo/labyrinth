package sibsutis.labyrinth.commands;

import sibsutis.labyrinth.core.Labyrinth;

public interface Command {
    boolean verify(String command);

    void execute(String command, Labyrinth labyrinth);
}
