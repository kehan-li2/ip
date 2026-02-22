package yuzu;

import yuzu.command.Command;
import yuzu.ui.Ui;
import yuzu.task.*;

/**
 * The entry point for this Yuzu bot.
 * Coordinates the interaction between the UI, storage, command and tasks.
 */
public class Yuzu {
    private Storage storage;
    private TaskList tasks;
    private Ui ui;

    private static final String FOLDER_PATH = "data";
    private static final String FILE_PATH = FOLDER_PATH + "/yuzu.txt";

    /**
     * Initializes a new Yuzu application instance with the specified file path for storage.
     *
     * @param filePath The path to the file where the task data is stored.
     */
    public Yuzu(String filePath) {
        ui = new Ui();
        storage = new Storage(filePath);
        try {
            // to init data
            tasks = new TaskList(storage.load());
        } catch (Exception e) {
            ui.showMessage("Initialize storage failed: " + e.getMessage());
            tasks = new TaskList();
        }
    }

    /**
     * Overloaded constructor for GUI initialization.
     */
    public Yuzu() {
        this(FILE_PATH);
    }

    /**
     * Starts the main application loop, reading user commands and executing them until exit.
     */
    public void run() {
        ui.showWelcome();
        boolean isExit = false;

        while (!isExit) {
            try {
                String fullCommand = ui.readCommand();
                ui.showLine();

                Command c = Parser.parse(fullCommand);
                c.execute(tasks, ui, storage);
                isExit = c.isExit();

            } catch (Exception e) {
                ui.showError(e.getMessage());
            } finally {
                ui.showLine();
            }
        }
    }

    /**
     * Get a response for user's message
     *
     * @param input the user input.
     * @return The response after execute the command.
     */
    public String getResponse(String input) {
        try {
            Command c = Parser.parse(input);
            return c.execute(tasks, ui, storage);
        } catch (Exception e) {
            return "Error: " + e.getMessage();
        }
    }

    /**
     * The main entry point of the application.
     *
     * @param args The command line arguments (not used).
     */
    public static void main(String[] args) {
        new Yuzu(FILE_PATH).run();
    }
}