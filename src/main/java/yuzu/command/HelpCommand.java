package yuzu.command;

import yuzu.Storage;
import yuzu.TaskList;
import yuzu.ui.Ui;

/**
 * The guide menu display to user
 */
public class HelpCommand extends Command {

    @Override
    public String execute(TaskList tasks, Ui ui, Storage storage) {
        String helpMessage = "Here is the commands list:\n\n"
                + "1. todo <description>\n"
                + "2. deadline <description> /by <YYYY-MM-DD>\n"
                + "3. event <description> /on <YYYY-MM-DD> /from <HH:mm> /to <HH:mm>\n"
                + "4. list\n"
                + "5. mark <index>\n"
                + "6. unmark <index>\n"
                + "7. snooze <index> /to <YYYY-MM-DD>\n"
                + "8. delete <index>\n"
                + "9. find <keyword>\n"
                + "10. due on <YYYY-MM-DD>\n"
                + "11. help\n"
                + "12. bye";

        ui.showMessage(helpMessage);
        return helpMessage;
    }
}