import java.util.Scanner;

public class Ui {
    private final Scanner scanner;
    private static final String DIVIDER = "-------------------------------------";

    public Ui() {
        this.scanner = new Scanner(System.in);
    }

    public String readCommand() {
        return scanner.nextLine();
    }

    public void showWelcome() {
        System.out.println("Hello! I'm Yuzu\nWhat can I do for you?\n" + DIVIDER);
    }

    public void showLine() {
        System.out.println(DIVIDER);
    }

    public void showError(String message) {
        System.out.println(" OOPS!!! " + message);
    }

    public void showMessage(String message) {
        System.out.println(message);
    }
}