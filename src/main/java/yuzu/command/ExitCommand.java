package yuzu.command;
import yuzu.Storage;
import yuzu.task.*;
import yuzu.TaskList;
import yuzu.ui.Ui;

/**
 * Represents a command to terminate the Yuzu bot.
 * After executed, it displays a message and ask the bot to stop.
 */
public class ExitCommand extends Command {
    /**
     * Executes the exit command by display a message to the user.
     *
     * @param tasks   The list of tasks (not used in this command).
     * @param ui      The user interface for displaying the message.
     * @param storage The storage handler (not used in this command).
     */
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        ui.showMessage("Bye. Hope to see you again soon!");
    }

    /**
     * Tell the bot should terminate.
     *
     * @return true, indicating the loop should stop.
     */
    @Override
    public boolean isExit() {
        return true;
    }
}