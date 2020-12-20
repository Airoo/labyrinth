package sibsutis.labyrinth.commands;

import sibsutis.labyrinth.core.Labyrinth;
import sibsutis.labyrinth.examples.LabyrinthExample;
import sibsutis.labyrinth.utils.Parser;
import sibsutis.labyrinth.writer.Writer;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SetExampleCommand implements Command {
    private static final String EX_CODE = "ex";
    private static final Set<Integer> EXAMPLES = Stream.of(1, 2, 3).collect(Collectors.toSet());
    private static final String ERROR_COMMAND = "Команда ex с неверными аргументом - %s. Доступны примеры 1, 2, 3";

    private final Writer writer;

    public SetExampleCommand(Writer writer) {
        this.writer = writer;
    }

    @Override
    public boolean verify(String command) {
        if (command.startsWith(EX_CODE)) {
            Integer value = Parser.parseLastOne(command);
            if (value != null) {
                if (EXAMPLES.contains(value)) {
                    return true;
                }
            }
            writer.writeLn(String.format(ERROR_COMMAND, value));
        }
        return false;
    }

    @Override
    public void execute(String command, Labyrinth labyrinth) {
        Integer value = Parser.parseLastOne(command);
        Labyrinth example = null;
        if (value == 1) {
            example = LabyrinthExample.EXAMPLE_ONE;
        } else if (value == 2) {
            example = LabyrinthExample.EXAMPLE_TWO;
        } else if (value == 3) {
            example = LabyrinthExample.EXAMPLE_THREE;
        }
        labyrinth.setWidth(example.getWidth());
        labyrinth.setHeight(example.getHeight());
        labyrinth.setCore(example.getCore());
    }
}
