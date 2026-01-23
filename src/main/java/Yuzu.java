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

        // Read in until bye
        while (true) {
            String input = scanner.nextLine();

            if (input.equals("bye")) {
                System.out.println("-------------------------------------\n" + "Bye. Hope to see you again soon!" + "\n-------------------------------------");
                break;
            }
            // Echo
            System.out.println("-------------------------------------\n" + input + "\n-------------------------------------");
        }

        scanner.close();
    }
}
