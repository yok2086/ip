package David.deadline;
import David.task.Task;

public class Deadline extends Task {
    protected String by;

    public Deadline(String description, String by) {
        super(description);
        this.by = by;
    }

    @Override
    public String toString() {
        return "[D]" + super.toString() + " " + description + " (by: " + by + ")";
    }

    public String toFileFormat() {
        return "D | " + (isDone ? "1" : "0") + " | " + description + " | " + by;
    }
}