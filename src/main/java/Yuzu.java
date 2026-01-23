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
                "What can I do for you?";
        System.out.println(msg);

        // Read in user input and say goodbye
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        if (input.equalsIgnoreCase("q")) {
            System.out.println("Bye. Hope to see you again soon!");
        }

        scanner.close();
    }
}
