public class Task {
    private String description;
    private boolean isDone;

    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    public void markDone() {
        isDone = true;
    }

    public void markUnDone() {
        isDone = false;
    }

    public boolean isDone() {
        return isDone;
    }

    public String getDescription() {
        return description;
    }

    public String toString() {
        return "[" + (isDone ? "X" : " ") + "] " + description;
    }

    public String toFileFormat() {
        return (isDone ? "1" : "0") + " | " + description;
    }
}
