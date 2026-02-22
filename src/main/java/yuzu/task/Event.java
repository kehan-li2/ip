package yuzu.task;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Represents a task that starts at a specific time and ends at a specific time.
 */
public class Event extends Task {
    private String dateString;
    private String time;

    public Event(String description, String datePart, String timeRange) {
        super(description);
        this.dateString = datePart.trim(); // here is the date for event "2026-03-01"
        this.time = timeRange.trim();      // this will be the specific timing eg. "14:00 to 16:00"
        try {
            this.date = LocalDate.parse(this.dateString);
        } catch (Exception e) {
            this.date = null;
        }
    }

    /**
     * Updates the event timing.
     * Since an event has two parts, current snooze only changes 'from'.
     */
    @Override
    public void setDate(LocalDate newDate) {
        super.setDate(newDate);
        this.dateString = newDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }

    @Override
    public String toString() {
        return "[E]" + super.toString() + " on " + dateString + " from " + time;
    }

    @Override
    public String toFileFormat() {
        return "E | " + (isDone ? "1" : "0") + " | " + description + " | " + dateString + " | " + time;
    }
}