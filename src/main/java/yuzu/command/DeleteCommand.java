package yuzu.command;
import yuzu.Storage;
import yuzu.task.*;
import yuzu.TaskList;
import yuzu.ui.Ui;

public class DeleteCommand extends Command {
    private int index;

    public DeleteCommand(int index) {
        this.index = index;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        Task removed = tasks.remove(index);
        ui.showMessage("Noted. I've removed this task:");
        ui.showMessage("  " + removed);
        ui.showMessage("Now you have " + tasks.size() + " tasks in the list.");
        storage.save(tasks);
    }
}