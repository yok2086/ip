package David.event;


import David.task.Task;


public class Event extends Task {
    protected String from;
    protected String to;


    /**
     * Constructs an Event task with the given description, start time, and end time.
     *
     * @param description The description of the Event task.
     * @param from        The start time of the event.
     * @param to          The end time of the event.
     */
    public Event(String description, String from, String to) {
        super(description);
        this.from = from;
        this.to = to;
    }


    /**
     * Returns a string representation of the Event task.
     *
     * @return A string showing the task's type, description, start time, and end time.
     */
    @Override
    public String toString() {
        return "[E]" + super.toString() + " " + description + " (from: " + from + " to: " + to + ")";
    }


    /**
     * Returns a file format string representation of the Event task.
     *
     * @return A string formatted for saving to a file, including the task type, completion status, description, start time, and end time.
     */
    public String toFileFormat() {
        return "E | " + (isDone ? "1" : "0") + " | " + description + " | " + from + " | " + to;
    }


}

