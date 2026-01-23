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
        String[] tasks = new String[100];
        int count = 0;

        // Read in until bye
        while (true) {
            String input = scanner.nextLine();

            if (input.equals("bye")) {
                System.out.println("-------------------------------------\n" + "Bye. Hope to see you again soon!" + "\n-------------------------------------");
                break;
            }

            if (input.equals("list")) {
                System.out.println("-------------------------------------");
                for (int i = 0; i < count; i++) {
                    System.out.println((i + 1) + ". " + tasks[i]);
                }
                System.out.println("-------------------------------------");
                continue;
            }

            tasks[count]= input;
            count++;
            System.out.println("-------------------------------------\nadded: " + input + "\n-------------------------------------");
        }

        scanner.close();
    }
}
