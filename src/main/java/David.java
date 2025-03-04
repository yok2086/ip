import java.util.Scanner;
import java.util.ArrayList;
import David.task.Task;
import David.ui.DavidException;
import David.deadline.Deadline;
import David.event.Event;
import David.todo.Todo;
import David.StorageManager;

public class David {
    public static final String LINE_SEPERATOR = "____________________________________________________________";

    public static void main(String[] args) {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);
        ArrayList<Task> task = new ArrayList<>();
        task = StorageManager.loadTasks();
        printHello();

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        int i = task.size();
        char input_type = input.charAt(input.indexOf("[") + 1);
        while (!input.equals("bye")) {
            try {
                if (input.equals("list")) {
                    System.out.println(LINE_SEPERATOR + "\nHere are the tasks in your list:\n");
                    for (int j = 0; j < task.size(); j++) {
                        System.out.println((j + 1) + "." + task.get(j).toString() + "\n" + LINE_SEPERATOR);
                    }
                }
                else if (input.startsWith("mark")) {
                    markTask(task, Integer.parseInt(input.split(" ")[1]) - 1);
                    printMark(task, Integer.parseInt(input.split(" ")[1]) - 1);
                    StorageManager.saveTasks(task);
                } else if (input.startsWith("unmark")) {
                    unmarkTask(task, Integer.parseInt(input.split(" ")[1]) - 1);
                    printUnmark(task, Integer.parseInt(input.split(" ")[1]) - 1);
                    StorageManager.saveTasks(task);
                } else if (input.startsWith("todo")) {
                    task.add(new Todo(input.substring(getIndex(input, " ") + 1)));
                    System.out.println(printTaskType(task, i));
                    StorageManager.saveTasks(task);
                    i++;
                } else if (input.startsWith("deadline")) {
                    task.add(new Deadline((input.substring(getIndex(input, " ") + 1, getIndex(input, "/") - 1)), input.substring(getIndex(input, "by") + 3)));
                    System.out.println(printTaskType(task, i));
                    StorageManager.saveTasks(task);
                    i++;
                } else if (input.startsWith("event")) {
                    task.add(new Event((input.substring(getIndex(input, " ") + 1, getIndex(input, "/") - 1)), input.substring(getIndex(input, "from") + 5, getIndex(input, "to") - 2), input.substring(getIndex(input, "to") + 3)));
                    System.out.println(printTaskType(task, i));
                    StorageManager.saveTasks(task);
                    i++;

                }
                else if (input.startsWith("delete")) {
                    deleteTask(task, Integer.parseInt(input.split(" ")[1]) - 1);
                    StorageManager.saveTasks(task);
                    i--;
                }

                else {
                    throw new IllegalArgumentException(LINE_SEPERATOR + System.lineSeparator() + " Sorry... I don't know what you mean by that? Could you try again?" + System.lineSeparator() + LINE_SEPERATOR);
                }
            }
         catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
          catch (DavidException e) {
                System.out.println(LINE_SEPERATOR + System.lineSeparator() + " Oops! The description of a task should NOT be blank! Please try again :)" + System.lineSeparator() + LINE_SEPERATOR);
            }
            input = scanner.nextLine();

        }
        printBye();
    }
    private static String printTaskType(ArrayList<Task> task, int i) {
        return LINE_SEPERATOR + System.lineSeparator() + " Got it. I've added this task:" + System.lineSeparator()
                + task.get(i).toString() + System.lineSeparator()
                + "Now you have " + (i + 1) + " tasks in the list." + System.lineSeparator() + LINE_SEPERATOR;
    }

    private static void printHello() {
        System.out.println(LINE_SEPERATOR + "\n" +
                " Hello! I'm David\n" +
                " What can I do for you?\n" +
                LINE_SEPERATOR + "\n");
    }

    private static void printBye() {
        System.out.println(" Bye. Hope to see you again soon!\n" +
                LINE_SEPERATOR);
    }

    public static void markTask(ArrayList<Task> task, int index) {
        task.get(index).setDone(true);
    }

    public static void unmarkTask(ArrayList<Task> task, int index) {
        task.get(index).setDone(false);
    }

    public static void deleteTask(ArrayList<Task> task, int index) {
        System.out.println(LINE_SEPERATOR + "\n" + "Noted. I've removed this task:\n" + "[" + task.get(index).getStatusIcon() + "] " + task.get(index).getDescription() + "\n" + LINE_SEPERATOR);
        task.remove(index);
    }

    public static void printMark(ArrayList<Task> task, int index) {
        System.out.println(LINE_SEPERATOR + "\n" + "Nice! I've marked this task as done:\n" + "[" + task.get(index).getStatusIcon() + "] " + task.get(index).getDescription() + "\n" + LINE_SEPERATOR);
    }

    public static void printUnmark(ArrayList<Task> task, int index) {
        System.out.println(LINE_SEPERATOR + "\n" + "[" + task.get(index).getStatusIcon() + "] " + task.get(index).getDescription() + "\n" + LINE_SEPERATOR);
    }

    public static int getIndex(String marking, String find) throws DavidException {
        int index = marking.indexOf(find);
        if (index == -1) {
            throw new DavidException();
        }
        return index;
    }

}

