package sibsutis.labyrinth;

import sibsutis.labyrinth.commands.*;
import sibsutis.labyrinth.core.Labyrinth;
import sibsutis.labyrinth.examples.LabyrinthExample;
import sibsutis.labyrinth.writer.ConsoleWriter;
import sibsutis.labyrinth.writer.Writer;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

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

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            writer.write(INTRODUCING);
            new PrintStructureCommand(writer).execute(null, null);
            new PrintInstructionCommand(writer).execute(null, null);
            Labyrinth labyrinth = LabyrinthExample.DEFAULT_LABYRINTH;
            while (true) {
                String input = scanner.nextLine().trim();
                if (input.trim().length() > 1) {
                    for (Command command : COMMANDS) {
                        if (command.verify(input)) {
                            command.execute(input, labyrinth);
                        }
                    }
                }
            }
        } finally {
            scanner.close();
        }

    }
}
