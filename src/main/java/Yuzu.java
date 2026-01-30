import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Yuzu {
    // Keep the data folder under ip dir
    private static final String FOLDER_PATH = "../../../data";
    private static final String FILE_PATH = FOLDER_PATH + "/yuzu.txt";

    // Handle the file is not exist
    public static void initData() {
        try {
            File folder = new File(FOLDER_PATH);
            if (!folder.exists()) {
                folder.mkdirs();
            }

            File file = new File(FILE_PATH);
            if (!file.exists()) {
                file.createNewFile();
            }

        } catch (IOException e) {
            System.out.println("Initialize storage failed: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        initData();

        Scanner scanner = new Scanner(System.in);
        ArrayList<Task> tasks = new ArrayList<>();
        loadTasks(tasks);
        int count = 0;

        String msg = "Hello! I'm Yuzu\nWhat can I do for you?\n-------------------------------------";
        System.out.println(msg);

        while (true) {
            String input = scanner.nextLine();
            System.out.println("-------------------------------------");

            if (input.equals("bye")) {
                System.out.println("Bye. Hope to see you again soon!");
                System.out.println("-------------------------------------");
                break;
            }

            try {
                if (input.equals("list")) {
                    System.out.println("Here are the tasks in your list:");
                    if(tasks.size() > 0) {
                        for (int i = 0; i < tasks.size(); i++) {
                            System.out.println((i + 1) + "." + tasks.get(i));
                        }
                    } else {
                        System.out.println("There is no tasks in the list yet");
                    }

                } else if (input.startsWith("mark")) {
                    int index = Integer.parseInt(input.split(" ")[1]) - 1;
                    Task task = tasks.get(index);
                    task.markDone();
                    System.out.println("Nice! I've marked this task as done:\n  " + task);
                } else if (input.startsWith("unmark")) {
                    int index = Integer.parseInt(input.split(" ")[1]) - 1;
                    Task task = tasks.get(index);
                    task.markUnDone();
                    System.out.println("OK, I've marked this task as not done yet:\n  " + task);
                } else if (input.startsWith("delete")) {
                    int index = Integer.parseInt(input.split(" ")[1]) - 1;
                    Task task = tasks.get(index);
                    tasks.remove(index);
                    System.out.println("Noted. I've removed this task:");
                    System.out.println("  " + task);
                    System.out.println("Now you have " + tasks.size() + " tasks in the list.");
                } else {
                    // Create new tasks here: ToDo, Deadline, Event
                    Task newTask = null;

                    if (input.startsWith("todo")) {
                        if (input.trim().equals("todo")) {
                            throw new Exception("The description of a todo cannot be empty.");
                        }
                        newTask = new ToDo(input.substring(5));
                    } else if (input.startsWith("deadline")) {
                        if (input.trim().equals("deadline")) {
                            throw new Exception("The description of a deadline cannot be empty.");
                        }
                        String[] parts = input.substring(8).split(" /by ");
                        newTask = new Deadline(parts[0], parts[1]);
                    } else if (input.startsWith("event")) {
                        if (input.trim().equals("event")) {
                            throw new Exception("The description of a event cannot be empty.");
                        }
                        String[] parts = input.substring(5).split(" /from ");
                        String[] timeParts = parts[1].split(" /to ");
                        newTask = new Event(parts[0], timeParts[0], timeParts[1]);
                    } else {
                        throw new Exception("I'm sorry, but I don't know what that means :-(\n");
                    }

                    if (newTask != null) {
                        tasks.add(newTask);
                        System.out.println("Got it. I've added this task:");
                        System.out.println("  " + newTask);
                        System.out.println("Now you have " + count + " tasks in the list.");
                    }
                }
                System.out.println("-------------------------------------");

            } catch (Exception e) {
                System.out.println(" OOPS!!! " + e.getMessage());
                System.out.println("-------------------------------------");
            }
        }

        scanner.close();
    }

    // If the file exists, load data from it
    private static void loadTasks(ArrayList<Task> tasks) {
        try {
            List<String> lines = Files.readAllLines(Paths.get(FILE_PATH));
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
        } catch (IOException e) {
            System.out.println("Error loading tasks.");
        }
    }
}