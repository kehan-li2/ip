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
        ui.showMessage("Here are the tasks in your list:");
        if (tasks.size() > 0) {
            for (int i = 0; i < tasks.size(); i++) {
                ui.showMessage((i + 1) + "." + tasks.get(i));
            }
        } else {
            ui.showMessage("There is no tasks in the list yet");
        }
    }
}