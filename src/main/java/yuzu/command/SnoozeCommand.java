package yuzu.command;

import yuzu.Storage;
import yuzu.task.*;
import yuzu.TaskList;
import yuzu.ui.Ui;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Represents a command to snooze/postpone a task to a new date.
 */
public class SnoozeCommand extends Command {
    private int index;
    private LocalDate newDate;
    private static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("MMM d yyyy");

    /**
     * Construct a SnoozeCommand with the task index and new date.
     *
     * @param index   The task index.
     * @param newDate The new LocalDate that the task should be postponed to.
     */
    public SnoozeCommand(int index, LocalDate newDate) {
        this.index = index;
        this.newDate = newDate;
    }

    /**
     * Execute the snooze command by updating the target task's date.
     * Tasks without date will not be able to execute this command
     *
     * @param tasks   The task list.
     * @param ui      The UI to display the result message.
     * @param storage The storage handler to save the updated task list.
     * @return A string response of the snooze operation result.
     */
    @Override
    public String execute(TaskList tasks, Ui ui, Storage storage) {
        assert tasks != null : "TaskList cannot be null for snooze";
        assert newDate != null : "Snooze date cannot be null";

        try {
            Task taskToSnooze = tasks.get(index);

            if (taskToSnooze instanceof ToDo) {
                return "I can only snooze a Todo task with a date!";
            }

            taskToSnooze.setDate(newDate);
            String formattedDate = newDate.format(DATE_FORMAT);
            String response = "Ok! I have snoozed this task to " + formattedDate + ":\n  " + taskToSnooze;

            ui.showMessage(response);
            storage.save(tasks);
            return response;
        } catch (IndexOutOfBoundsException e) {
            return "Oops! I couldn't find a task with index number" + (index + 1) + ".";
        }
    }
}