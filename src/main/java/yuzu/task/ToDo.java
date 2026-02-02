package yuzu.task;

/**
 * Represents a todo task.
 * A ToDo object corresponds to a simple todo task.
 */
public class ToDo extends Task {
    /**
     * Initializes a new ToDo task with the specified description.
     *
     * @param description The description of the task.
     */
    public ToDo(String description) {
        super(description);
    }

    /**
     * Returns a string representation of the ToDo task.
     *
     * @return A formatted string representation of the task.
     */
    @Override
    public String toString() {
        return "[T]" + super.toString();
    }

    /**
     * Returns a formatted string to save the task to a data file.
     *
     * @return A string represents the task's information.
     */
    @Override
    public String toFileFormat() {
        return "T | " + (isDone ? "1" : "0") + " | " + description;
    }
}