package David.todo;
import David.task.Task;

public class Todo extends Task {

    public Todo(String description) {
        super(description);
    }

    @Override
    public String toString() {
        return  "[T]" + super.toString() + " " + description;
    }

    public String toFileFormat() {
        return "T | " + (isDone ? "1" : "0") + " | " + description;
    }
}