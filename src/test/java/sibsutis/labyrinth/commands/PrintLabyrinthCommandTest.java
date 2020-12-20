package sibsutis.labyrinth.commands;

import org.junit.Assert;
import org.junit.Test;
import sibsutis.labyrinth.writer.WriterStub;

public class PrintLabyrinthCommandTest {
    private final Command command = new PrintLabyrinthCommand(new WriterStub());

    @Test
    public void returnTrue_whenRightCommand() {
        boolean result = command.verify("plab");

        Assert.assertTrue(result);
    }
}