package yuzu.command;

import yuzu.Storage;
import yuzu.TaskList;
import yuzu.task.Task;
import yuzu.ui.Ui;

/**
 * Represents a command to find tasks by keyword.
 */
public class FindCommand extends Command {
    private String keyword;

    /**
     * Initializes a FindCommand with the specified search keyword.
     *
     * @param keyword The keyword to be searched for.
     */
    public FindCommand(String keyword) {
        this.keyword = keyword;
    }

    /**
     * Executes the find command to search the task list by keyword,
     * then display them to the user.
     *
     * @param tasks   The list of tasks.
     * @param ui      The user interface to display matching results.
     * @param storage The storage handler (not used in this command).
     */
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        ui.showMessage("Here are the matching tasks in your list:");
        int count = 0;
        for (int i = 0; i < tasks.size(); i++) {
            Task t = tasks.get(i);
            if (t.getDescription().contains(keyword)) {
                count++;
                ui.showMessage(count + "." + t);
            }
        }
        if (count == 0) {
            ui.showMessage("No matching tasks found.");
        }
    }
}