package yuzu.command;
import yuzu.Storage;
import yuzu.task.*;
import yuzu.TaskList;
import yuzu.ui.Ui;

/**
 * Represents a command to add task to the task list.
 * This command used to add ToDo, Deadline, and Event tasks.
 */
public class AddCommand extends Command {
    private Task task;

    /**
     * Initializes an AddCommand with the specified task.
     *
     * @param task The task to be added.
     */
    public AddCommand(Task task) {
        this.task = task;
    }

    /**
     * Executes the add command by adding the task to the list,
     * then display a success message, and saving the updated list to storage.
     *
     * @param tasks The list of tasks.
     * @param ui The user interface for displaying feedback.
     * @param storage To save the updated task list.
     */
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        tasks.add(task);
        ui.showMessage("Got it. I've added this task:\n  " + task);
        ui.showMessage("Now you have " + tasks.size() + " tasks in the list.");
        storage.save(tasks);
    }
}