package sibsutis.labyrinth.commands;

import sibsutis.labyrinth.core.Labyrinth;
import sibsutis.labyrinth.writer.Writer;

public class PrintStructureCommand implements Command {
    private static final String PSTR_CODE = "pstr";
    private static final String STRUCTURE_INFO = "Минимаьный размер стенки лаибинта составляет 4 ячейки, максимальный - 20 ячеек\n" +
            "Описание структуры лабиринта:\n" +
            "0 - проход\n" +
            "1 - стена\n" +
            "2 - проход, начальная точка\n" +
            "3 - проход, конечная точка\n" +
            "4 - проход, часть пути\n" +
            "Тип 2 и 3 можно располагать только на крайней границе лабиринта" +
            "Тип 2 и 3 должны содержаться в лабиринте в единичном экзепляре" +
            "Тип 0 должен содержаться внутри лабиринта";

    private final Writer writer;

    public PrintStructureCommand(Writer writer) {
        this.writer = writer;
    }

    @Override
    public boolean verify(String command) {
        return PSTR_CODE.equalsIgnoreCase(command);
    }

    @Override
    public void execute(String command, Labyrinth labyrinth) {
        writer.writeLn(STRUCTURE_INFO);
    }
}
