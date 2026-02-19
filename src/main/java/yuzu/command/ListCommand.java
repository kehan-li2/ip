package yuzu.command;
import yuzu.Storage;
import yuzu.task.*;
import yuzu.TaskList;
import yuzu.ui.Ui;

/**
 * Represents a command to list all tasks in the task list.
 * This command get every task and displays them.
 */
public class ListCommand extends Command {
    /**
     * Executes the list command by iterating through the task list and
     * displaying each task to the user. If the list is empty, a message
     * will be displayed to the user.
     *
     * @param tasks   The list of tasks to be displayed.
     * @param ui      The user interface to display the task list.
     * @param storage The storage handler (not used in this command).
     */
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        assert tasks != null : "TaskList should not be null during execution";
        assert ui != null : "UI should not be null during execution";

        ui.showMessage("Here is the list of your tasks:");
        int listSize = tasks.size();
        assert listSize >= 0 : "TaskList size cannot lesser than 0";

        if (listSize > 0) {
            for (int i = 0; i < listSize; i++) {
                Task currentTask = tasks.get(i);
                assert currentTask != null : "Get task at index " + i + " should not be null";
                ui.showMessage((i + 1) + "." + currentTask);
            }
        } else {
            ui.showMessage("There is no tasks in the list yet");
        }
    }
}