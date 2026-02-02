package yuzu;
import yuzu.task.Task;

import java.util.ArrayList;

/**
 * Represents a list of tasks in this Yuzu bot.
 * It provides methods to manipulate and get tasks information from the list.
 */
public class TaskList {
    private final ArrayList<Task> tasks;

    /**
     * Initializes an empty task list.
     */
    public TaskList() {
        this.tasks = new ArrayList<>();
    }

    /**
     * Initializes a task list with a list of tasks.
     *
     * @param tasks The list of tasks.
     */
    public TaskList(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }

    /**
     * Adds a task to the list.
     *
     * @param task The task to be added.
     */
    public void add(Task task) {
        tasks.add(task);
    }

    /**
     * Removes task at the specified index from the list.
     *
     * @param index The index of the task to be removed.
     * @return The task that was removed.
     */
    public Task remove(int index) {
        return tasks.remove(index);
    }

    /**
     * Get task at the specified index.
     *
     * @param index The index of the task to be get.
     * @return The task at the specified index.
     */
    public Task get(int index) {
        return tasks.get(index);
    }

    /**
     * Returns the number of tasks in the list.
     *
     * @return The size of the task list.
     */
    public int size() {
        return tasks.size();
    }
}