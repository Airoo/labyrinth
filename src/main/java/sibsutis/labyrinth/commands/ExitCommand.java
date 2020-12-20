package sibsutis.labyrinth.commands;

import sibsutis.labyrinth.core.Labyrinth;
import sibsutis.labyrinth.writer.Writer;

/**
 * Команда завершения работы
 *
 * @see Command
 */
public class ExitCommand implements Command {
    private static final String EXIT_CODE = "exit";

    private final Writer writer;

    public ExitCommand(Writer writer) {
        this.writer = writer;
    }

    @Override
    public boolean verify(String command) {
        return EXIT_CODE.equalsIgnoreCase(command);
    }

    @Override
    public void execute(String command, Labyrinth labyrinth) {
        writer.writeLn("До скорой встречи");
        System.exit(0);
    }
}
