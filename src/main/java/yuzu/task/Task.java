package yuzu.task;

/**
 * The general task for Yuzu bot.
 * A Task consists of description and completion status.
 */
public class Task {
    protected String description;
    protected boolean isDone;

    /**
     * Initializes a new Task with the specified description.
     * The task is not completed when was created.
     *
     * @param description The description of the task.
     */
    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    /**
     * Marks the task as completed.
     */
    public void markDone() {
        isDone = true;
    }

    /**
     * Marks the task not completed.
     */
    public void markUnDone() {
        isDone = false;
    }

    /**
     * Checks if the task is completed.
     *
     * @return True if the task is done, false otherwise.
     */
    public boolean isDone() {
        return isDone;
    }

    /**
     * Get the task description.
     *
     * @return The task description.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Returns a string representation of the task.
     *
     * @return A formatted string representing the task.
     */
    public String toString() {
        return "[" + (isDone ? "X" : " ") + "] " + description;
    }

    /**
     * Returns a formatted string to save the task to a data file.
     *
     * @return A string represents the task's information.
     */
    public String toFileFormat() {
        return (isDone ? "1" : "0") + " | " + description;
    }
}
