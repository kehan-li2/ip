package yuzu.command;
import yuzu.Storage;
import yuzu.task.*;
import yuzu.TaskList;
import yuzu.ui.Ui;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DueOnCommand extends Command {
    private String searchDate;

    public DueOnCommand(String date) {
        this.searchDate = date;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        LocalDateTime target = LocalDateTime.parse(searchDate, DateTimeFormatter.ofPattern("d/M/yyyy HHmm"));

        for (int i = 0; i < tasks.size(); i++) {
            Task t = tasks.get(i);
            if (t instanceof Deadline due) {
                if (due.getDueDate().equals(target)) {
                    ui.showMessage(due.toString());
                }
            }
        }
    }
}