import java.util.Scanner;

public class Yuzu {
    public static void main(String[] args) {
        String msg = "Hello! I'm Yuzu\nWhat can I do for you?\n-------------------------------------";
        System.out.println(msg);

        Scanner scanner = new Scanner(System.in);
        Task[] tasks = new Task[100];
        int count = 0;

        while (true) {
            String input = scanner.nextLine();
            System.out.println("-------------------------------------");

            if (input.equals("bye")) {
                System.out.println("Bye. Hope to see you again soon!");
                System.out.println("-------------------------------------");
                break;
            }

            if (input.equals("list")) {
                System.out.println("Here are the tasks in your list:");
                for (int i = 0; i < count; i++) {
                    System.out.println((i + 1) + "." + tasks[i]);
                }
            } else if (input.startsWith("mark")) {
                int index = Integer.parseInt(input.split(" ")[1]) - 1;
                tasks[index].markDone();
                System.out.println("Nice! I've marked this task as done:\n  " + tasks[index]);
            } else if (input.startsWith("unmark")) {
                int index = Integer.parseInt(input.split(" ")[1]) - 1;
                tasks[index].markUnDone();
                System.out.println("OK, I've marked this task as not done yet:\n  " + tasks[index]);
            } else {
                // Create new tasks here: ToDo, Deadline, Event
                Task newTask = null;

                if (input.startsWith("todo ")) {
                    newTask = new ToDo(input.substring(5));
                } else if (input.startsWith("deadline ")) {
                    String[] parts = input.substring(9).split(" /by ");
                    newTask = new Deadline(parts[0], parts[1]);
                } else if (input.startsWith("event ")) {
                    String[] parts = input.substring(6).split(" /from ");
                    String[] timeParts = parts[1].split(" /to ");
                    newTask = new Event(parts[0], timeParts[0], timeParts[1]);
                }

                if (newTask != null) {
                    tasks[count] = newTask;
                    count++;
                    System.out.println("Got it. I've added this task:");
                    System.out.println("  " + newTask);
                    System.out.println("Now you have " + count + " tasks in the list.");
                }
            }
            System.out.println("-------------------------------------");
        }
        scanner.close();
    }
}