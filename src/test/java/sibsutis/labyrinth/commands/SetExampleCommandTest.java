package sibsutis.labyrinth.commands;

import org.junit.Assert;
import org.junit.Test;
import sibsutis.labyrinth.writer.WriterStub;

public class SetExampleCommandTest {
    private final Command command = new SetExampleCommand(new WriterStub());

    @Test
    public void returnTrue_whenRightCommand() {
        boolean result = command.verify("ex 1");

        Assert.assertTrue(result);
    }
}