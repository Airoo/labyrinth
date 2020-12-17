package sibsutis.labyrinth.writer;

public class ConsoleWriter implements Writer {
    public void write(String message) {
        System.out.println(message);
    }
}
