package David.todo;


import David.task.Task;


public class Todo extends Task {
    /**
     * Constructs a Todo task with the given description.
     *
     * @param description The description of the Todo task.
     */
    public Todo(String description) {
        super(description);
    }


    /**
     * Returns a string representation of the Todo task.
     *
     * @return A string showing the task's type and description.
     */
    @Override
    public String toString() {
        return "[T]" + super.toString() + " " + description;
    }


    /**
     * Returns a file format string representation of the Todo task.
     *
     * @return A string formatted for saving to a file, including the task type, completion status, and description.
     */
    public String toFileFormat() {
        return "T | " + (isDone ? "1" : "0") + " | " + description;
    }
}

