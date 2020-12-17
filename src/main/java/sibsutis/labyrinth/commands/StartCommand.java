package sibsutis.labyrinth.commands;

import sibsutis.labyrinth.core.Labyrinth;
import sibsutis.labyrinth.utils.Pair;
import sibsutis.labyrinth.writer.Writer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;

public class StartCommand implements Command {
    private static final String START_CODE = "start";
    private static final String ERROR_COMMAND = "Лабиринт не содержит стартовой точки (тип 2)";
    private static final String RESULT_WITHOUT_EXIT = "Лабиринт не содержит выхода";
    private static final String RESULT_WITH_EXIT = "Выход найден. Просмотрите лабиринт";
    private static final int EXIT_CODE = 4;

    private static final List<Function<Pair<Integer, Integer>, Pair<Integer, Integer>>> STEPS = Arrays.asList(
            dot -> Pair.of(dot.getLeft(), dot.getRight() + 1),
            dot -> Pair.of(dot.getLeft(), dot.getRight() - 1),
            dot -> Pair.of(dot.getLeft() + 1, dot.getRight()),
            dot -> Pair.of(dot.getLeft() - 1, dot.getRight())
    );

    private final Writer writer;

    public StartCommand(Writer writer) {
        this.writer = writer;
    }

    @Override
    public boolean verify(String command) {
        return START_CODE.equalsIgnoreCase(command);
    }

    @Override
    public void execute(String command, Labyrinth labyrinth) {
        int[][] core = labyrinth.getCore();

        Pair<Integer, Integer> startPoint = null;

        for (int i = 0; i < core.length; i++) {
            for (int j = 0; j < core[i].length; j++) {
                if (core[i][j] == 2) {
                    startPoint = Pair.of(i, j);
                    break;
                }
            }
        }

        if (startPoint == null) {
            writer.write(ERROR_COMMAND);
            return;
        }

        List<Pair<Integer, Integer>> result = search(startPoint, labyrinth, new ArrayList<>());
        if (result.isEmpty()) {
            writer.write(RESULT_WITHOUT_EXIT);
        } else {
            for (Pair<Integer, Integer> dot : result) {
                core[dot.getLeft()][dot.getRight()] = EXIT_CODE;
            }
            writer.write(RESULT_WITH_EXIT);
        }
    }

    private List<Pair<Integer, Integer>> search(Pair<Integer, Integer> dot, Labyrinth labyrinth, List<Pair<Integer, Integer>> path) {
        int[][] core = labyrinth.getCore();
        int width = labyrinth.getWidth() - 1;
        int height = labyrinth.getHeight() - 1;
        int y = dot.getLeft();
        int x = dot.getRight();

        if (x > width || x < 0 || y > height || y < 0) {
            return Collections.emptyList();
        }
        if (core[y][x] == 1) {
            return Collections.emptyList();
        }
        if (core[y][x] == 3) {
            path.add(dot);
            return path;
        }

        path.add(dot);

        // выполняем движение по лабиринту во все 4 стороны, проверяя что нет зацикливания
        for (Function<Pair<Integer, Integer>, Pair<Integer, Integer>> step : STEPS) {
            Pair<Integer, Integer> nextStep = step.apply(dot);
            if (!path.contains(nextStep)) {
                List<Pair<Integer, Integer>> resultPath = search(nextStep, labyrinth, new ArrayList<>(path));
                if (!resultPath.isEmpty()) {
                    return resultPath;
                }
            }
        }

        return Collections.emptyList();
    }
}
