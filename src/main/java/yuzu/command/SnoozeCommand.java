package yuzu.command;

import yuzu.Storage;
import yuzu.task.*;
import yuzu.TaskList;
import yuzu.ui.Ui;
import java.time.LocalDate;

/**
 * Represents a command to snooze/postpone a task to a new date.
 */
public class SnoozeCommand extends Command {
    private int index;
    private LocalDate newDate;

    public SnoozeCommand(int index, LocalDate newDate) {
        this.index = index;
        this.newDate = newDate;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        assert tasks != null : "TaskList should not be null";
        assert newDate != null : "Snooze date should not be null";

        try {
            Task taskToSnooze = tasks.get(index);

            if (taskToSnooze instanceof ToDo) {
                ui.showMessage("I can only snooze a Todo task with a deadline!");
                return;
            }

            taskToSnooze.setDate(newDate);
            ui.showMessage("Ok! I have snoozed this task to " + newDate + ":");
            ui.showMessage("  " + taskToSnooze);
            storage.save(tasks);

        } catch (IndexOutOfBoundsException e) {
            ui.showMessage("Oops! I couldn't find a task with this index number.");
        }
    }
}