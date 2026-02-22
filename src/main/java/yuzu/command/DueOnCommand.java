package yuzu.command;
import yuzu.Storage;
import yuzu.task.*;
import yuzu.TaskList;
import yuzu.ui.Ui;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 * Represents a command to find tasks that are due on a specific date and time.
 * It filters the task list for Deadline tasks that match the target date-time.
 */
public class DueOnCommand extends Command {
    private String searchDate;
    private static final DateTimeFormatter OUTPUT_FORMAT = DateTimeFormatter.ofPattern("MMM d yyyy");
    private static final DateTimeFormatter INPUT_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    /**
     * Initializes a DueOnCommand with the specified date string.
     *
     * @param date The date-time string in "d/M/yyyy HHmm" format to search for.
     */
    public DueOnCommand(String date) {
        this.searchDate = date;
    }

    /**
     * Executes the command by parsing the search date and displaying all Deadline
     * tasks that match the target date and time.
     *
     * @param tasks   The list of tasks to search through.
     * @param ui      The user interface for displaying matching tasks.
     * @param storage The storage handler (not directly used by this command).
     * @return The according msgs after execute this due on command
     */
    @Override
    public String execute(TaskList tasks, Ui ui, Storage storage) {
        assert tasks != null : "TaskList cannot be null for search";

        try {
            LocalDate due = LocalDate.parse(searchDate.trim(), INPUT_FORMAT);
            StringBuilder sb = new StringBuilder("Tasks due on " + due.format(OUTPUT_FORMAT) + ":\n");
            int count = 0;

            for (int i = 0; i < tasks.size(); i++) {
                Task task = tasks.get(i);
                // only for task that have a date
                if (task.getDate() != null && task.getDate().equals(due)) {
                    sb.append("  ").append(task).append("\n");
                    count++;
                }
            }

            String response = (count == 0)
                    ? "No tasks found due on " + due.format(OUTPUT_FORMAT) + "."
                    : sb.toString().trim();
            ui.showMessage(response);

            return response;
        } catch (DateTimeParseException e) {
            return "Oops! Please input date in yyyy-MM-dd format (eg. 2026-02-22).";
        }
    }
}