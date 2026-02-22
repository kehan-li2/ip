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
     * @return A formatted string of matching tasks.
     */
    @Override
    public String execute(TaskList tasks, Ui ui, Storage storage) {
        assert tasks != null : "TaskList cannot be null for search";
        assert keyword != null : "Keyword cannot be null";

        StringBuilder sb = new StringBuilder("Here are the found tasks in your list:\n");
        int count = 0;

        for (int i = 0; i < tasks.size(); i++) {
            Task task = tasks.get(i);
            if (task.getDescription().contains(keyword)) {
                count++;
                sb.append(count).append(".").append(task).append("\n");
            }
        }

        String response;
        if (count == 0) {
            response = "No matching tasks found for: \"" + keyword + "\"";
        } else {
            response = sb.toString().trim();
        }

        ui.showMessage(response);
        return response;
    }
}