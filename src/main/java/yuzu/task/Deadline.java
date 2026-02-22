package yuzu.task;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * A Deadline task
 * A Deadline object contains a description and specific due date or time.
 */
public class Deadline extends Task {
    protected String due;

    public Deadline(String description, String by) {
        super(description);
        this.due = by;
        this.date = LocalDate.parse(by);
    }

    /**
     * Updates the due date of the deadline.
     * Allows the snooze command to update the due date
     *
     * @param newDate The new date to set for this deadline.
     */
    @Override
    public void setDate(LocalDate newDate) {
        super.setDate(newDate);
        this.due = newDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }

    @Override
    public String toString() {
        return "[D]" + super.toString() + " by " + due;
    }

    public String getDueDate() {
        return this.due;
    }

    @Override
    public String toFileFormat() {
        return "D | " + (isDone ? "1" : "0") + " | " + description + " | " + due;
    }
}