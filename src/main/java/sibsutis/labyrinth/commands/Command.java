package sibsutis.labyrinth.commands;

import sibsutis.labyrinth.core.Labyrinth;

public interface Command {
    /**
     * Верификация команды
     *
     * @param command - команда
     * @return true - если команда верная и false - если команда неверная
     */
    boolean verify(String command);

    /**
     * Выполнение команды которая прошла верификацию
     *
     * @param command   - команда для исполнения
     * @param labyrinth - лабиринт для исполненния команды
     */
    void execute(String command, Labyrinth labyrinth);
}
