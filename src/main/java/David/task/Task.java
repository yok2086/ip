package David.task;

public class Task {
    protected String description;
    protected boolean isDone;

    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    public String getStatusIcon() {
        return (isDone ? "X" : " "); // mark done task with X
    }

    public String getDescription() {
        return description;
    }

    public boolean setDone(boolean status) {
        return isDone = status;
    }

    @Override
    public String toString() {
        return "[" + getStatusIcon() + "]";
    }

    public String toFileFormat() {
        return "";
    }

}