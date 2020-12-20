package sibsutis.labyrinth.commands;

import org.junit.Assert;
import org.junit.Test;
import sibsutis.labyrinth.writer.WriterStub;

public class PrintStructureCommandTest {
    private final Command command = new PrintStructureCommand(new WriterStub());

    @Test
    public void returnTrue_whenRightCommand() {
        boolean result = command.verify("pstr");

        Assert.assertTrue(result);
    }
}