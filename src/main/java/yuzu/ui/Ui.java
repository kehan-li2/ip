package yuzu.ui;

import java.util.Scanner;

/**
 * Handles the user interface of the application.
 * It is responsible for reading user input and displaying messages to the user.
 */
public class Ui {
    private final Scanner scanner;
    private static final String DIVIDER = "-------------------------------------";
    private String lastMessage;

    /**
     * Initializes a new Ui object and sets up the scanner for user input.
     */
    public Ui() {
        this.scanner = new Scanner(System.in);
    }

    /**
     * Reads the next line of user input.
     *
     * @return The command string entered by user.
     */
    public String readCommand() {
        return scanner.nextLine();
    }

    /**
     * Displays the welcome message to user.
     */
    public void showWelcome() {
        System.out.println("Hello! I'm Yuzu\nWhat can I do for you?\n" + DIVIDER);
    }

    /**
     * Prints a horizontal divider line to the console for message separation.
     */
    public void showLine() {
        System.out.println(DIVIDER);
    }

    /**
     * Displays an error message to the user.
     *
     * @param message To show error message.
     */
    public void showError(String message) {
        System.out.println(" OOPS!!! " + message);
    }

    /**
     * Displays a general message to the user.
     *
     * @param message The message string that is going to be printed.
     */
    public void showMessage(String message) {
        System.out.println(message);
    }

    /**
     * Get the last message displayed on the UI
     *
     * @return The string for the msg
     */
    public String getLastMessage() {
        return this.lastMessage;
    }
}