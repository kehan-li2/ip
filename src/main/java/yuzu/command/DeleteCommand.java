package yuzu.command;
import yuzu.Storage;
import yuzu.task.*;
import yuzu.TaskList;
import yuzu.ui.Ui;

/**
 * Represents a command to delete task from the task list.
 * This command removes task based on the index.
 */
public class DeleteCommand extends Command {
    private int index;

    /**
     * Initializes a DeleteCommand with the specified index.
     *
     * @param index The index of the task to be removed.
     */
    public DeleteCommand(int index) {
        this.index = index;
    }

    /**
     * Executes the delete command by removing the task at specified index,
     * display a confirmation message, and then save the updated list to storage.
     *
     * @param tasks   The list of tasks which the task will be removed.
     * @param ui      The user interface to display msgs.
     * @param storage The storage to save the updated task list.
     */
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        Task removed = tasks.remove(index);
        ui.showMessage("Noted. I've removed this task:");
        ui.showMessage("  " + removed);
        ui.showMessage("Now you have " + tasks.size() + " tasks in the list.");
        storage.save(tasks);
    }
}