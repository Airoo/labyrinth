package sibsutis.labyrinth.commands;

import sibsutis.labyrinth.core.Labyrinth;

public class ExitCommand implements Command {
    private static final String EXIT_CODE = "exit";

    @Override
    public boolean verify(String command) {
        return EXIT_CODE.equalsIgnoreCase(command);
    }

    @Override
    public void execute(String command, Labyrinth labyrinth) {
        System.out.println("До скорой встречи");
        System.exit(0);
    }
}
