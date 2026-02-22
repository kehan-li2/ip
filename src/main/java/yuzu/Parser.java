package yuzu;
import yuzu.command.*;
import yuzu.task.*;

import java.time.LocalDate;

/**
 * Deals with all the user input string command.
 * It interprets the input string and returns the corresponding Command object for execution.
 */
public class Parser {
    /**
     * Parses the user input into a specific Command object.
     *
     * @param input The string of input typed by user.
     * @return A Command object.
     * @throws Exception If the input format is invalid or the command is unrecognized.
     */
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
                throw new Exception("The description of an event cannot be empty.");
            }

            try {
                String rest = input.substring(6).trim();
                // Split /on, /from, /to
                String[] parts = rest.split(" /on | /from | /to ");

                if (parts.length < 4) {
                    throw new Exception("Please use format: event [desc] /on [YYYY-MM-DD] /from [HH:mm] /to [HH:mm]");
                }

                String description = parts[0].trim();
                String datePart = parts[1].trim();
                String timeRange = parts[2].trim() + " to " + parts[3].trim();

                return new AddCommand(new Event(description, datePart, timeRange));
            } catch (Exception e) {
                throw new Exception("Error parsing event. Ensure you have /on, /from and /to correctly.");
            }
        } else if (input.startsWith("find")) {
            if (input.trim().equals("find")) {
                throw new Exception("The keyword for find cannot be empty.");
            }
            return new FindCommand(input.substring(5).trim());
        } else if (input.startsWith("snooze")) {
            // Expected update date format: "snooze 2 /to 2026-03-12"
            try {
                String[] parts = input.substring(7).split(" /to ");
                int index = Integer.parseInt(parts[0].trim()) - 1;
                LocalDate newDate = LocalDate.parse(parts[1].trim());

                return new SnoozeCommand(index, newDate);
            } catch (Exception e) {
                throw new Exception("Please use the format: snooze [index] /to [YYYY-MM-DD]");
            }
        } else if (input.startsWith("help")) {
            return new HelpCommand();
        } else {
                throw new Exception("I'm sorry, but I don't know what that means :-(\n");
            }
        }
}