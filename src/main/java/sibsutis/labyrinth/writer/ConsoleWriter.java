package sibsutis.labyrinth.writer;

/**
 * Класс вывода сообщения в консоль
 *
 * @see Writer
 */
public class ConsoleWriter implements Writer {
    public void writeLn(String message) {
        System.out.println(message);
    }

    public void write(String message) {
        System.out.print(message);
    }
}
