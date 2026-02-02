package yuzu.task;

/**
 * A Deadline task
 * A Deadline object contains a description and specific due date or time.
 */
public class Deadline extends Task {
    protected String due;

    /**
     * Initializes a new Deadline task with description and due date.
     *
     * @param description The description of the task.
     * @param due The date or time the task due on.
     */
    public Deadline(String description, String due) {
        super(description);
        this.due = due;
    }

    /**
     * Returns a string description of the deadline task.
     *
     * @return A formatted string of the deadline task information.
     */
    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by " + due+ ")";
    }

    /**
     * Get the due date of the task.
     *
     * @return The due date.
     */
    public String getDueDate() {
        return this.due;
    }
}