package sibsutis.labyrinth.commands;

import org.junit.Assert;
import org.junit.Test;
import sibsutis.labyrinth.writer.WriterStub;

public class ExitCommandTest {
    private final Command command = new ExitCommand(new WriterStub());

    @Test
    public void returnTrue_whenRightCommand() {
        boolean result = command.verify("exit");

        Assert.assertTrue(result);
    }
}