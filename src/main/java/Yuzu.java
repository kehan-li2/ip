public class Yuzu {
    private Storage storage;
    private TaskList tasks;
    private Ui ui;

    private static final String FOLDER_PATH = "../../../data";
    private static final String FILE_PATH = FOLDER_PATH + "/yuzu.txt";

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

    public static void main(String[] args) {
        new Yuzu(FILE_PATH).run();
    }
}