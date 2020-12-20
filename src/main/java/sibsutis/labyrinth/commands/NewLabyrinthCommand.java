package sibsutis.labyrinth.commands;

import sibsutis.labyrinth.core.Labyrinth;
import sibsutis.labyrinth.utils.Pair;
import sibsutis.labyrinth.utils.Parser;
import sibsutis.labyrinth.writer.Writer;

public class NewLabyrinthCommand implements Command {
    private static final String ERROR = "Команда new с неверными аргументами - %s. Min 4, max 20";
    private static final String NEW_CODE = "new";
    private static final int MIN = 3;
    private static final int MAX = 21;

    private final Writer writer;

    public NewLabyrinthCommand(Writer writer) {
        this.writer = writer;
    }

    @Override
    public boolean verify(String command) {
        if (command.startsWith(NEW_CODE)) {
            Pair<Integer, Integer> values = Parser.parseLastTwo(command);
            if (values != null) {
                int width = values.getLeft();
                int height = values.getRight();
                if (width > MIN && width < MAX && height > MIN && height < MAX) {
                    return true;
                }
            }
            writer.writeLn(String.format(ERROR, command));
        }
        return false;
    }

    @Override
    public void execute(String command, Labyrinth labyrinth) {
        Pair<Integer, Integer> values = Parser.parseLastTwo(command);
        int width = values.getLeft();
        int height = values.getRight();
        int[][] core = new int[height][];
        for (int i = 0; i < height; i++) {
            int[] raw = new int[width];
            for (int j = 0; j < width; j++) {
                raw[j] = 1;
            }
            core[i] = raw;
        }
        labyrinth.setCore(core);
        labyrinth.setHeight(height);
        labyrinth.setWidth(width);
    }

}
