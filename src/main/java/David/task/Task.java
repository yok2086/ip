package David.task;


public class Task {
    protected String description;
    protected boolean isDone;


    /**
     * Constructs a Task with the given description, initially marked as not done.
     *
     * @param description The description of the Task.
     */
    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }


    /**
     * Returns the status icon of the task, marking it as done (X) or not done (space).
     *
     * @return A string "X" if the task is done, otherwise a space.
     */
    public String getStatusIcon() {
        return (isDone ? "X" : " "); // mark done task with X
    }


    /**
     * Returns the description of the task.
     *
     * @return The description of the Task.
     */
    public String getDescription() {
        return description;
    }


    /**
     * Sets the task's completion status.
     *
     * @param status The new status of the task (true for done, false for not done).
     * @return The new completion status of the task.
     */
    public boolean setDone(boolean status) {
        return isDone = status;
    }


    /**
     * Returns a string representation of the task, showing its completion status.
     *
     * @return A string representation of the Task, including the status icon.
     */
    @Override
    public String toString() {
        return "[" + getStatusIcon() + "]";
    }


    /**
     * Returns a file format string representation of the task.
     *
     * @return An empty string, to be overridden in subclasses.
     */
    public String toFileFormat() {
        return "";
    }


}



