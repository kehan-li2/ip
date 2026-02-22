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

    public SnoozeCommand(int index, LocalDate newDate) {
        this.index = index;
        this.newDate = newDate;
    }

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