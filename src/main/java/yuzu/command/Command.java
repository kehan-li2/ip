package yuzu.command;
import yuzu.Storage;
import yuzu.TaskList;
import yuzu.ui.Ui;

/**
 * Represents an executable command of the Yuzu bot.
 * This is an abstract class which is the base for all specific commands implementations.
 */
public abstract class Command {
    /**
     * Executes the command using the provided task list, UI, and storage.
     *
     * @param tasks   The list of tasks.
     * @param ui      The user interface for user interaction.
     * @param storage The storage to load and save data.
     * @throws Exception If an error occurs during command execution.
     */
    public abstract String execute(TaskList tasks, Ui ui, Storage storage) throws Exception;

    /**
     * Indicates whether should terminate the bot.
     *
     * @return True if the application should exit, false otherwise.
     */
    public boolean isExit() {
        return false;
    }
}