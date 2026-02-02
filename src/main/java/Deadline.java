import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

class Deadline extends Task {
    private LocalDateTime due;
    private static final DateTimeFormatter INPUT = DateTimeFormatter.ofPattern("d/M/yyyy HHmm");

    public Deadline(String description, String due) {
        super(description);
        this.due = LocalDateTime.parse(due, INPUT);
    }

    public LocalDateTime getDueDate() {
        return this.due;
    }

    @Override
    public String toString() {
        return "[D]" + super.toString() +
                " (by: " + due.format(DateTimeFormatter.ofPattern("MMM dd yyyy")) + ")";
    }

    @Override
    public String toFileFormat() {
        return "D | " + super.toFileFormat() + " | " + this.due;
    }
}