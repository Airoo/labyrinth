package sibsutis.labyrinth.commands;

import org.junit.Assert;
import org.junit.Test;
import sibsutis.labyrinth.writer.WriterStub;

public class SetCommandTest {
    private final Command command = new SetCommand(new WriterStub());

    @Test
    public void returnTrue_whenRightCommand() {
        boolean result = command.verify("set 1 1 1");

        Assert.assertTrue(result);
    }
}