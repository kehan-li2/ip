import java.util.Scanner;

public class Yuzu {
    public static void main(String[] args) {
//        String logo = " ____        _        \n"
//                + "|  _ \\ _   _| | _____ \n"
//                + "| | | | | | | |/ / _ \\\n"
//                + "| |_| | |_| |   <  __/\n"
//                + "|____/ \\__,_|_|\\_\\___|\n";
//        System.out.println("Hello from\n" + logo);

        String msg = "Hello! I'm Yuzu\n" +
                "What can I do for you?\n" +
                "-------------------------------------";
        System.out.println(msg);

        // Read in user input and say goodbye
        Scanner scanner = new Scanner(System.in);
        Task[] tasks = new Task[100];
        int count = 0;

        // Read in until bye
        while (true) {
            String input = scanner.nextLine();

            // Used for bye
            if (input.equals("bye")) {
                System.out.println("-------------------------------------\n" + "Bye. Hope to see you again soon!" + "\n-------------------------------------");
                break;
            }

            // List out the tasks
            if (input.equals("list")) {
                System.out.println("-------------------------------------\n" + "Here are the tasks in your list:\n");
                for (int i = 0; i < count; i++) {
                    System.out.println((i + 1) + ". " + tasks[i]);
                }
                System.out.println("-------------------------------------");
                continue;
            }

            // Mark the task as done
            if (input.startsWith("mark")) {
                int index = Integer.parseInt(input.split(" ")[1]) - 1;
                tasks[index].markDone();

                System.out.println("-------------------------------------");
                System.out.println("Nice! I've marked this task as done:");
                System.out.println(tasks[index]);
                System.out.println("-------------------------------------");
                continue;
            }

            // Mark the task as undone
            if (input.startsWith("unmark")) {
                int index = Integer.parseInt(input.split(" ")[1]) - 1;
                tasks[index].markUnDone();

                System.out.println("-------------------------------------");
                System.out.println("OK, I've marked this task as not done yet:");
                System.out.println(tasks[index]);
                System.out.println("-------------------------------------");
                continue;
            }

            tasks[count] = new Task(input);
            count++;
            System.out.println("-------------------------------------\nadded: " + input + "\n-------------------------------------");
        }

        scanner.close();
    }
}
