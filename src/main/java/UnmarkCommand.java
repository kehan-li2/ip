public class UnmarkCommand extends Command {
    private int index;

    public UnmarkCommand(int index) {
        this.index = index;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        Task task = tasks.get(index);
        task.markUnDone();
        ui.showMessage("OK, I've marked this task as not done yet:\n  " + task);
        storage.save(tasks);
    }
}