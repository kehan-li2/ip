package yuzu.command;
import yuzu.Storage;
import yuzu.task.*;
import yuzu.TaskList;
import yuzu.ui.Ui;

/**
 * Represents a command to mark a specific task in the task list as not completed.
 * The task is identified by the index number in the task list.
 */
public class UnmarkCommand extends Command {
    private int index;

    /**
     * Initializes an UnmarkCommand with the specified task index.
     *
     * @param index The index of the task to be unmarked.
     */
    public UnmarkCommand(int index) {
        this.index = index;
    }

    /**
     * Executes the unmark command by getting the task, marking it as not done,
     * display a confirmation message, and then save the updated list to storage.
     *
     * @param tasks   The list of tasks.
     * @param ui      The user interface to display feedback.
     * @param storage The storage handler to save the updated task list.
     */
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        Task task = tasks.get(index);
        task.markUnDone();
        ui.showMessage("OK, I've marked this task as not done yet:\n  " + task);
        storage.save(tasks);
    }
}