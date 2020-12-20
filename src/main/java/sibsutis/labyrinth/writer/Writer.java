package sibsutis.labyrinth.writer;

/**
 * Интерфейс вывода сообщения
 */
public interface Writer {
    /**
     * Вывод сообщения на новой строке
     *
     * @param message - сообщение для вывода
     */
    void writeLn(String message);

    /**
     * Вывод сообщения
     *
     * @param message - сообщение для вывода
     */
    void write(String message);
}
