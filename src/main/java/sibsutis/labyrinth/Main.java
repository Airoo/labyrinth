package sibsutis.labyrinth;

import org.apache.commons.lang3.StringUtils;
import sibsutis.labyrinth.commands.*;
import sibsutis.labyrinth.core.Labyrinth;
import sibsutis.labyrinth.examples.LabyrinthExample;
import sibsutis.labyrinth.writer.ConsoleWriter;
import sibsutis.labyrinth.writer.Writer;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Главный класс для запуска приложения
 *
 * @author Константин Т
 */
public class Main {
    private static final Set<Command> COMMANDS = new HashSet<>();
    private static final String INTRODUCING = "Добро пожаловать. Это программа поиска пути в лабиринте\n" +
            "Для выполнения алгоритма поиска необходимо создать лабиринт";

    private static final Writer writer = new ConsoleWriter();

    static {
        COMMANDS.add(new ExitCommand(writer));
        COMMANDS.add(new NewLabyrinthCommand(writer));
        COMMANDS.add(new PrintInstructionCommand(writer));
        COMMANDS.add(new PrintLabyrinthCommand(writer));
        COMMANDS.add(new PrintStructureCommand(writer));
        COMMANDS.add(new SetCommand(writer));
        COMMANDS.add(new StartCommand(writer));
        COMMANDS.add(new SetExampleCommand(writer));
    }

    /**
     * Запуск приложения
     */
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            writer.writeLn(INTRODUCING);
            new PrintStructureCommand(writer).execute(null, null);
            new PrintInstructionCommand(writer).execute(null, null);
            Labyrinth labyrinth = LabyrinthExample.DEFAULT_LABYRINTH;
            while (true) {
                String input = scanner.nextLine().trim();
                if (StringUtils.isNoneBlank(input.trim())) {
                    for (Command command : COMMANDS) {
                        if (command.verify(input)) {
                            command.execute(input, labyrinth);
                        }
                    }
                }
            }
        }

    }
}
