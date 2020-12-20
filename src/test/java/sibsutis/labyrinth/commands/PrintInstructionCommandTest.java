package sibsutis.labyrinth.commands;

import org.junit.Assert;
import org.junit.Test;
import sibsutis.labyrinth.writer.WriterStub;

public class PrintInstructionCommandTest {
    private final Command command = new PrintInstructionCommand(new WriterStub());

    @Test
    public void returnTrue_whenRightCommand() {
        boolean result = command.verify("pinst");

        Assert.assertTrue(result);
    }
}