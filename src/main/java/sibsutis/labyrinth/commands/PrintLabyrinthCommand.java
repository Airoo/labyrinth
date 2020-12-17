package sibsutis.labyrinth.commands;

import sibsutis.labyrinth.core.Labyrinth;

public class PrintLabyrinthCommand implements Command {
    private static final String PLAB_CODE = "plab";

    @Override
    public boolean verify(String command) {
        return PLAB_CODE.equalsIgnoreCase(command);
    }

    @Override
    public void execute(String command, Labyrinth labyrinth) {
        int[][] core = labyrinth.getCore();
        for (int[] raw : core) {
            for (int i : raw) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
