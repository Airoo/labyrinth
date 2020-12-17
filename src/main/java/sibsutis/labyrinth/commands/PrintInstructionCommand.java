package sibsutis.labyrinth.commands;

import sibsutis.labyrinth.core.Labyrinth;
import sibsutis.labyrinth.writer.Writer;

public class PrintInstructionCommand implements Command {
    private static final String PINST_CODE = "pinst";
    private static final String INSTRUCTION_INFO = "Команды:\n" +
            "new a b - создание нового лабиринта (где a - ширина, b - высота). По умолчанию все ячейки лабиринта заполняются - 1\n" +
            "set x y t - изменение типа ячейки (x координата по ширине, y - по высоте, t - новый тип ячейки)\n" +
            "plab - распечатать лабиринт\n" +
            "start - поиск пути в лабиринте\n" +
            "exit - выход из программы\n" +
            "pstr - распечатать структуру алгоритма\n" +
            "pinst - распечатать команды алгоритма" +
            "ex x - загрузить пример лабиринта (x - номер примера (1, 2, 3))";

    private final Writer writer;

    public PrintInstructionCommand(Writer writer) {
        this.writer = writer;
    }

    @Override
    public boolean verify(String command) {
        return PINST_CODE.equalsIgnoreCase(command);
    }

    @Override
    public void execute(String command, Labyrinth labyrinth) {
        writer.write(INSTRUCTION_INFO);
    }
}
