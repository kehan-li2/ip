package yuzu.command;
import yuzu.Storage;
import yuzu.task.*;
import yuzu.TaskList;
import yuzu.ui.Ui;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Represents a command to find tasks that are due on a specific date and time.
 * It filters the task list for Deadline tasks that match the target date-time.
 */
public class DueOnCommand extends Command {
    private String searchDate;

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
     */
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        LocalDateTime target = LocalDateTime.parse(searchDate, DateTimeFormatter.ofPattern("d/M/yyyy HHmm"));

        for (int i = 0; i < tasks.size(); i++) {
            Task t = tasks.get(i);
            if (t instanceof Deadline due) {
                if (due.getDueDate().equals(target)) {
                    ui.showMessage(due.toString());
                }
            }
        }
    }
}