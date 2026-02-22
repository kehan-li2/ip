package yuzu.command;

import yuzu.Storage;
import yuzu.TaskList;
import yuzu.task.Task;
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
     * @return A formatted string of the task list for the GUI.
     */
    @Override
    public String execute(TaskList tasks, Ui ui, Storage storage) {
        assert tasks != null : "TaskList cannot be null for list";
        assert ui != null : "UI cannot be null for list";

        int listSize = tasks.size();
        assert listSize >= 0 : "TaskList size cannot be negative";

        if (listSize == 0) {
            String noTaskMsg = "There are no tasks in your list yet!";
            ui.showMessage(noTaskMsg);
            return noTaskMsg;
        }

        StringBuilder sb = new StringBuilder("Here are the tasks in your list:\n");
        for (int i = 0; i < listSize; i++) {
            Task currentTask = tasks.get(i);
            assert currentTask != null : "Task at index " + i + " cannot be null";

            sb.append(i + 1).append(".").append(currentTask);
            if (i < listSize - 1) {
                sb.append("\n");
            }
        }

        String response = sb.toString();
        ui.showMessage(response);
        return response;
    }
}