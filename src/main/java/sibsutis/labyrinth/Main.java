package sibsutis.labyrinth;

import sibsutis.labyrinth.commands.*;
import sibsutis.labyrinth.core.Labyrinth;
import sibsutis.labyrinth.examples.LabyrinthExample;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    private static final Set<Command> COMMANDS = new HashSet<>();
    private static final String INTRODUCING = "Добро пожаловать. Это программа поиска пути в лабиринте\n" +
            "Для выполнения алгоритма поиска необходимо создать лабиринт";

    static {
        COMMANDS.add(new ExitCommand());
        COMMANDS.add(new NewLabyrinthCommand());
        COMMANDS.add(new PrintInstructionCommand());
        COMMANDS.add(new PrintLabyrinthCommand());
        COMMANDS.add(new PrintStructureCommand());
        COMMANDS.add(new SetCommand());
        COMMANDS.add(new StartCommand());
        COMMANDS.add(new SetExampleCommand());
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println(INTRODUCING);
            new PrintStructureCommand().execute(null, null);
            new PrintInstructionCommand().execute(null, null);
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
