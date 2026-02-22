package yuzu.command;

import yuzu.Storage;
import yuzu.task.*;
import yuzu.TaskList;
import yuzu.ui.Ui;

/**
 * Represents a command to mark a specific task in the task list as completed.
 * The task is identified by the index number in the task list.
 */
public class MarkCommand extends Command {
    private int index;

    /**
     * Initializes a MarkCommand with the specified task index.
     *
     * @param index The index of the task to be marked.
     */
    public MarkCommand(int index) {
        this.index = index;
    }

    /**
     * Executes the mark command by getting the task and mark it as done,
     * display a success message, and then save the updated list to storage.
     *
     * @param tasks   The list of tasks containing the task to be marked.
     * @param ui      The user interface to display feedback to the user.
     * @param storage The storage handler to save the updated task list.
     * @return A confirmation message for the GUI.
     */
    @Override
    public String execute(TaskList tasks, Ui ui, Storage storage) {
        assert tasks != null : "TaskList cannot be null for mark";
        assert index >= 0 && index < tasks.size() : "Task index is out of bounds";

        try {
            Task task = tasks.get(index);
            task.markDone();

            String response = "Nice! I've marked this task as done:\n  " + task;
            ui.showMessage(response);
            storage.save(tasks);
            return response;
        } catch (IndexOutOfBoundsException e) {
            return "Error: Could not find task at index " + (index + 1);
        }
    }
}