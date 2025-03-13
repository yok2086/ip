package David.deadline;
import David.task.Task;


public class Deadline extends Task {
    protected String by;
    /**
     * Constructs a Deadline task with the given description and deadline.
     * @param description The description of the task.
     * @param by The deadline date for the task.
     */
    public Deadline(String description, String by) {
        super(description);
        this.by = by;
    }
    /**
     * Returns a string representation of the Deadline task.
     * @return A string showing the task's type, description, and deadline.
     */
    @Override
    public String toString() {
        return "[D]" + super.toString() + " " + description + " (by: " + by + ")";
    }
    /**
     * Returns a file format string representation of the Deadline task.
     * @return A string formatted for saving to a file, including the task type, completion status, description, and deadline.
     */
    public String toFileFormat() {
        return "D | " + (isDone ? "1" : "0") + " | " + description + " | " + by;
    }
}

