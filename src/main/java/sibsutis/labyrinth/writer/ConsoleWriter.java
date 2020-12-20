package sibsutis.labyrinth.writer;

public class ConsoleWriter implements Writer {
    public void writeLn(String message) {
        System.out.println(message);
    }

    public void write(String message) {
        System.out.print(message);
    }
}
