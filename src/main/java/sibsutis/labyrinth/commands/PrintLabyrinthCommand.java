package sibsutis.labyrinth.commands;

import sibsutis.labyrinth.core.Labyrinth;
import sibsutis.labyrinth.writer.Writer;

public class PrintLabyrinthCommand implements Command {
    private static final String PLAB_CODE = "plab";

    private final Writer writer;

    public PrintLabyrinthCommand(Writer writer) {
        this.writer = writer;
    }

    @Override
    public boolean verify(String command) {
        return PLAB_CODE.equalsIgnoreCase(command);
    }

    @Override
    public void execute(String command, Labyrinth labyrinth) {
        int[][] core = labyrinth.getCore();
        for (int[] raw : core) {
            for (int i : raw) {
                writer.write(i + " ");
            }
            writer.writeLn("");
        }
    }
}
