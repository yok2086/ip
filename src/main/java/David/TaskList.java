package David;

import java.util.ArrayList;

import David.task.Task;
import David.ui.DavidException;

public class TaskList {
    public static final String LINE_SEPERATOR = "____________________________________________________________";
    private final ArrayList<Task> tasks;

    public TaskList() {
        tasks = new ArrayList<>();
    }

    public TaskList(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }

    public static void markTask(TaskList task, int index) {
        task.getTask(index).setDone(true);
    }

    public static void unmarkTask(ArrayList<Task> task, int index) {
        task.get(index).setDone(false);
    }

    public static void deleteTask(ArrayList<Task> task, int index) {
        System.out.println(LINE_SEPERATOR + "\n" + "Noted. I've removed this task:\n" + "[" + task.get(index).getStatusIcon() + "] " + task.get(index).getDescription() + "\n" + LINE_SEPERATOR);
        task.remove(index);
    }

    public ArrayList<Task> getTasks() {
        return tasks;
    }

    public Task getTask(int index) {
        return tasks.get(index);
    }

    public boolean isEmpty() {
        return tasks.isEmpty();
    }

    public static int getIndex(String marking, String find) throws DavidException {
        int index = marking.indexOf(find);
        if (index == -1) {
            throw new DavidException();
        }
        return index;
    }

}
