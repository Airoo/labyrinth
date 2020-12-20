package sibsutis.labyrinth.commands;

import sibsutis.labyrinth.core.Labyrinth;
import sibsutis.labyrinth.utils.Parser;
import sibsutis.labyrinth.utils.Triple;
import sibsutis.labyrinth.writer.Writer;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SetCommand implements Command {
    private static final String ERROR_COMMAND = "Команда set с неверными аргументами - %s. Доступны типы 0, 1, 2, 3";
    private static final String ERROR_BORDER = "Неверные границы в параметре. Лабиринт имеет граицы по x - %s, по y - %S";
    private static final String ERROR_BORDER_TYPE = "Тип 2 или 3 можно распологать только на крайней границе лабиринта";
    private static final String ERROR_INNER_BORDER_TYPE = "Тип 0 можно распологать только внутри лабиринта";
    private static final String SET_CODE = "set";
    private static final Set<Integer> TYPE_CODES = Stream.of(0, 1, 2, 3).collect(Collectors.toSet());
    private static final int ZERO = 0;

    private final Writer writer;

    public SetCommand(Writer writer) {
        this.writer = writer;
    }

    @Override
    public boolean verify(String command) {
        if (command.startsWith(SET_CODE)) {
            Triple<Integer, Integer, Integer> values = Parser.parseLastThree(command);
            if (values != null) {
                int x = values.getLeft();
                int y = values.getMiddle();
                int type = values.getRight();
                if (TYPE_CODES.contains(type)) {
                    return true;
                }
            }
            writer.writeLn(String.format(ERROR_COMMAND, command));
        }
        return false;
    }

    @Override
    public void execute(String command, Labyrinth labyrinth) {
        Triple<Integer, Integer, Integer> values = Parser.parseLastThree(command);
        int x = values.getLeft() - 1;
        int y = values.getMiddle() - 1;
        int type = values.getRight();

        int width = labyrinth.getWidth() - 1;
        int height = labyrinth.getHeight() - 1;

        if (x < ZERO || y < ZERO || x > width || y > height) {
            writer.writeLn(String.format(ERROR_BORDER, width, height));
            return;
        }

        if ((type == 2 || type == 3) && (x > 0 && x < width && y > 0 && y < height)) {
            writer.writeLn(ERROR_BORDER_TYPE);
            return;
        }
        if ((type == 0) && (x <= 0 || x >= width || y <= 0 || y >= height)) {
            writer.writeLn(ERROR_INNER_BORDER_TYPE);
            return;
        }

        int[][] core = labyrinth.getCore();

        // проверяем что в лабиринте уже нет типа 2 или 3 и если есть - заменяем на 1
        if (type == 2 || type == 3) {
            for (int i = 0; i < core.length; i++) {
                for (int j = 0; j < core[i].length; j++) {
                    if (core[i][j] == type) {
                        core[i][j] = 1;
                    }
                }
            }
        }

        core[height - y][x] = type;
    }
}
