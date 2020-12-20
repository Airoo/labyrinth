package sibsutis.labyrinth.commands;

import org.junit.Assert;
import org.junit.Test;
import sibsutis.labyrinth.writer.WriterStub;

public class NewLabyrinthCommandTest {
    private final Command command = new NewLabyrinthCommand(new WriterStub());

    @Test
    public void returnTrue_whenRightCommand() {
        boolean result = command.verify("new 4 4");

        Assert.assertTrue(result);
    }
}