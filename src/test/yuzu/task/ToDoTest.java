package yuzu.task;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ToDoTest {
    @Test
    public void testToString() {
        assertEquals("[T][ ] read book", new ToDo("read book").toString());
    }

    @Test
    public void testMarkDone() {
        ToDo todo = new ToDo("read book");
        todo.markAsDone();
        assertEquals("[T][X] read book", todo.toString());
    }
}