package yuzu.task;

/**
 * Represents a task that starts at a specific time and ends at a specific time.
 * An Event object contains a description, a start time, and an end time.
 */
public class Event extends Task {
    private String from;
    private String to;

    /**
     * Initializes a new Event task with description, start time, and end time.
     *
     * @param description The description of the event.
     * @param from The start time of the event.
     * @param to The end time of the event.
     */
    public Event(String description, String from, String to) {
        super(description);
        this.from = from;
        this.to = to;
    }

    /**
     * Returns a string representation of the event task.
     *
     * @return A formatted string representation of the event.
     */
    @Override
    public String toString() {
        return "[E]" + super.toString() + " (from: " + from + " to: " + to + ")";
    }

    /**
     * Returns a formatted string for the event task.
     *
     * @return A description of the event task.
     */
    @Override
    public String toFileFormat() {
        return "E | " + (isDone ? "1" : "0") + " | " + description + " | " + from + " | " + to;
    }
}