package yuzu;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;
import yuzu.command.AddCommand;
import yuzu.command.Command;

public class ParserTest {

    @Test
    public void parse_todoCommand_returnsAddCommand() throws Exception {
        // test the todo task
        Command result = Parser.parse("todo read book");
        assertTrue(result instanceof AddCommand);
    }

    @Test
    public void parse_unknownCommand_throwsException() {
        // test invalid input
        assertThrows(Exception.class, () -> {
            Parser.parse("invalidCommand");
        });
    }
}