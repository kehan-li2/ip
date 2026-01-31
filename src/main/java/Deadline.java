import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

class Deadline extends Task {
    protected LocalDate due;

    public Deadline(String description, String due) {
        super(description);
        this.due = LocalDate.parse(due);
    }

    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: " +
                due.format(DateTimeFormatter.ofPattern("MMM dd yyyy")) + ")";
    }

    @Override
    public String toFileFormat() {
        return "D | " + super.toFileFormat() + " | " + this.due;
    }
}