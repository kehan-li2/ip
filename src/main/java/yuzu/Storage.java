package yuzu;
import yuzu.task.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * Handle to load and save task data to file.
 * It ensures the directories and files exist before performing I/O operations.
 */
public class Storage {
    private final String filePath;
    private final String folderPath;

    /**
     * Initializes a Storage object with a specified file path.
     *
     * @param filePath The relative or absolute path to the data file.
     */
    public Storage(String filePath) {
        this.filePath = filePath;
        this.folderPath = filePath.substring(0, filePath.lastIndexOf("/"));
    }

    /**
     * Loads tasks from the local file.
     * Creates the folder and file if do not exist.
     *
     * @return An ArrayList of tasks loaded from the file.
     * @throws IOException If an error occurs during file creation or reading.
     */
    public ArrayList<Task> load() throws IOException {
        File folder = new File(folderPath);
        if (!folder.exists()) {
            folder.mkdirs();
        }

        File file = new File(filePath);
        if (!file.exists()) {
            file.createNewFile();
        }

        ArrayList<Task> tasks = new ArrayList<>();
        List<String> lines = Files.readAllLines(Paths.get(filePath));

        for (String line : lines) {
            String[] parts = line.split(" \\| ");
            Task task = null;
            switch (parts[0]) {
                case "T":
                    task = new ToDo(parts[2]);
                    break;
                case "D":
                    task = new Deadline(parts[2], parts[3]);
                    break;
                case "E":
                    task = new Event(parts[2], parts[3], parts[3]);
                    break;
            }
            if (task != null) {
                if (parts[1].equals("1")) task.markDone();
                tasks.add(task);
            }
        }
        return tasks;
    }

    /**
     * Saves the list of tasks to the storage file.
     *
     * @param tasks The TaskList containing tasks to be saved.
     */
    public void save(TaskList tasks) {
        try (FileWriter fw = new FileWriter(filePath)) {
            for (int i = 0; i < tasks.size(); i++) {
                Task t = tasks.get(i);
                fw.write(t.toFileFormat() + System.lineSeparator());
            }
        } catch (IOException e) {
            System.out.println("Error saving tasks: " + e.getMessage());
        }
    }
}