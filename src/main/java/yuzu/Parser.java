package yuzu;
import yuzu.command.*;
import yuzu.task.*;

public class Parser {
    public static Command parse(String input) throws Exception {
        if (input.equals("bye")) {
            return new ExitCommand();
        }

        if (input.equals("list")) {
            return new ListCommand();
        } else if (input.startsWith("mark")) {
            int index = Integer.parseInt(input.split(" ")[1]) - 1;
            return new MarkCommand(index);
        } else if (input.startsWith("unmark")) {
            int index = Integer.parseInt(input.split(" ")[1]) - 1;
            return new UnmarkCommand(index);
        } else if (input.startsWith("delete")) {
            int index = Integer.parseInt(input.split(" ")[1]) - 1;
            return new DeleteCommand(index);
        } else if (input.startsWith("due on")) {
            String searchDate = input.substring(7).trim();
            return new DueOnCommand(searchDate);
        } else if (input.startsWith("todo")) {
            if (input.trim().equals("todo")) {
                throw new Exception("The description of a todo cannot be empty.");
            }
            return new AddCommand(new ToDo(input.substring(5)));
        } else if (input.startsWith("deadline")) {
            if (input.trim().equals("deadline")) {
                throw new Exception("The description of a deadline cannot be empty.");
            }
            String[] parts = input.substring(8).split(" /by ");
            return new AddCommand(new Deadline(parts[0].trim(), parts[1].trim()));
        } else if (input.startsWith("event")) {
            if (input.trim().equals("event")) {
                throw new Exception("The description of a event cannot be empty.");
            }
            String[] parts = input.substring(5).split(" /from ");
            String[] timeParts = parts[1].split(" /to ");
            return new AddCommand(new Event(parts[0], timeParts[0], timeParts[1]));
        } else {
            throw new Exception("I'm sorry, but I don't know what that means :-(\n");
        }
    }
}