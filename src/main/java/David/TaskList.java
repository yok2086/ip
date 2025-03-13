package David;

import java.util.ArrayList;

import David.task.Task;
import David.ui.DavidException;


/**
 * Represents a list of tasks. Provides methods to manipulate tasks,
 * such as marking, unmarking, and deleting tasks.
 */
public class TaskList {
    public static final String LINE_SEPERATOR = "____________________________________________________________";
    private final ArrayList<Task> tasks;


    /**
     * Default constructor that initializes an empty task list.
     */
    public TaskList() {
        tasks = new ArrayList<>();
    }


    /**
     * Constructor that initializes the task list with an existing list of tasks.
     *
     * @param tasks The list of tasks to initialize with.
     */
    public TaskList(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }


    /**
     * Marks a task as completed by setting its done status to true.
     *
     * @param task  The TaskList object containing the task.
     * @param index The index of the task to mark.
     */
    public static void markTask(TaskList task, int index) {
        task.getTask(index).setDone(true);
    }


    /**
     * Unmarks a task as incomplete by setting its done status to false.
     *
     * @param task  The list of tasks.
     * @param index The index of the task to unmark.
     */
    public static void unmarkTask(ArrayList<Task> task, int index) {
        task.get(index).setDone(false);
    }


    /**
     * Deletes a task from the task list.
     *
     * @param task  The list of tasks.
     * @param index The index of the task to delete.
     */
    public static void deleteTask(ArrayList<Task> task, int index) {
        System.out.println(LINE_SEPERATOR + "\n" + "Noted. I've removed this task:\n" + "[" + task.get(index).getStatusIcon() + "] " + task.get(index).getDescription() + "\n" + LINE_SEPERATOR);
        task.remove(index);
    }


    /**
     * Returns the list of tasks.
     *
     * @return The list of tasks.
     */
    public ArrayList<Task> getTasks() {
        return tasks;
    }


    /**
     * Retrieves a task at a specific index.
     *
     * @param index The index of the task to retrieve.
     * @return The task at the given index.
     */
    public Task getTask(int index) {
        return tasks.get(index);
    }


    /**
     * Finds the index of a given substring within a string.
     *
     * @param marking The string to search within.
     * @param find    The substring to find.
     * @return The index of the substring if found.
     * @throws DavidException if the substring is not found.
     */
    public static int getIndex(String marking, String find) throws DavidException {
        int index = marking.indexOf(find);
        if (index == -1) {
            throw new DavidException();
        }
        return index;
    }


}

