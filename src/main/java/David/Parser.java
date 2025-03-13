package David;


import java.util.ArrayList;


import David.deadline.Deadline;
import David.event.Event;
import David.task.Task;
import David.todo.Todo;
import David.ui.DavidException;


/**
 * The Parser class handles user input, processes commands, and executes appropriate actions
 * on the task list, including adding, deleting, and marking tasks.
 */
public class Parser {
    public static final String LINE_SEPERATOR = "____________________________________________________________";
    private final Ui ui;
    private final TaskList task;
    private final Storage storage;


    /**
     * Constructs a Parser object.
     *
     * @param ui      User interface handler.
     * @param tasks   Task list manager.
     * @param storage Storage handler for saving and loading tasks.
     */
    public Parser(Ui ui, TaskList tasks, Storage storage) {
        this.ui = ui;
        this.task = tasks;
        this.storage = storage;
    }


    /**
     * Reads and processes a command input by the user.
     *
     * @param input The command entered by the user.
     * @return true if the command is "bye" to exit the program, false otherwise.
     */
    public boolean readCommand(String input) {
        int i = task.getTasks().size();
        try {
            if (input.equals("list")) {
                System.out.println(LINE_SEPERATOR + "\nHere are the tasks in your list:\n");
                for (int j = 0; j < task.getTasks().size(); j++) {
                    System.out.println((j + 1) + "." + task.getTask(j).toString() + "\n" + LINE_SEPERATOR);
                }
            } else if (input.equals("bye")) {
                return true;

            } else if (input.startsWith("mark")) {
                task.markTask(task, Integer.parseInt(input.split(" ")[1]) - 1);
                ui.printMark(task.getTasks(), Integer.parseInt(input.split(" ")[1]) - 1);
                storage.saveTasks(task.getTasks());
            } else if (input.startsWith("unmark")) {
                task.unmarkTask(task.getTasks(), Integer.parseInt(input.split(" ")[1]) - 1);
                ui.printUnmark(task.getTasks(), Integer.parseInt(input.split(" ")[1]) - 1);
                storage.saveTasks(task.getTasks());
            } else if (input.startsWith("todo")) {
                parseTodo(input, task.getTasks());
                System.out.println(Ui.printTaskType(task.getTasks(), i));
                storage.saveTasks(task.getTasks());
                i++;
            } else if (input.startsWith("deadline")) {
                parseDeadline(input, task.getTasks());
                System.out.println(Ui.printTaskType(task.getTasks(), i));
                storage.saveTasks(task.getTasks());
                i++;
            } else if (input.startsWith("event")) {
                parseEvent(input, task.getTasks());
                System.out.println(Ui.printTaskType(task.getTasks(), i));
                storage.saveTasks(task.getTasks());
                i++;


            } else if (input.startsWith("delete")) {
                TaskList.deleteTask(task.getTasks(), Integer.parseInt(input.split(" ")[1]) - 1);
                storage.saveTasks(task.getTasks());
                i--;
            } else if (input.startsWith("find")) {
                boolean found = false;
                for (i = 0; i < task.getTasks().size(); i++) {
                    if (task.getTask(i).getDescription().contains(input.substring(input.indexOf(" ") + 1))) {
                        System.out.println((i + 1) + "." + task.getTask(i).toString() + "\n" + LINE_SEPERATOR);
                        found = true;
                    }
                }
                if (!found) {
                    System.out.println(LINE_SEPERATOR + System.lineSeparator() + "Could not be found" + System.lineSeparator() + LINE_SEPERATOR);
                } else {
                    System.out.println(System.lineSeparator() + "These tasks were found" + System.lineSeparator() + LINE_SEPERATOR);
                }
            } else {
                throw new IllegalArgumentException(LINE_SEPERATOR + System.lineSeparator() + " Sorry... I don't know what you mean by that? Could you try again?" + System.lineSeparator() + LINE_SEPERATOR);
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } catch (DavidException e) {
            System.out.println(LINE_SEPERATOR + System.lineSeparator() + " Oops! The description of a task should NOT be blank! Please try again :)" + System.lineSeparator() + LINE_SEPERATOR);
        }
        catch (IndexOutOfBoundsException e) {
            System.out.println("Does not exist, try again. " + System.lineSeparator() + LINE_SEPERATOR);
        }


        return false;
    }


    /**
     * Marks a task as done or not done.
     *
     * @param index The index of the task.
     * @param isDone The status to mark the task.
     * @param ui The UI instance to show all messages.
     */


    /**
     * Parses and adds a Todo task from the user input.
     *
     * @param input The user command string.
     * @param task  The task list where the new task will be added.
     * @throws DavidException If the description of the task is missing.
     */
    private static void parseTodo(String input, ArrayList<Task> task) throws DavidException {
        task.add(new Todo(input.substring(TaskList.getIndex(input, " ") + 1)));
    }


    /**
     * Parses and adds an Event task from the user input.
     *
     * @param input The user command string.
     * @param task  The task list where the new task will be added.
     * @throws DavidException If the description of the task is missing.
     */
    private static void parseEvent(String input, ArrayList<Task> task) throws DavidException {
        task.add(new Event((input.substring(TaskList.getIndex(input, " ") + 1, TaskList.getIndex(input, "/") - 1)), input.substring(TaskList.getIndex(input, "from") + 5, TaskList.getIndex(input, "to") - 2), input.substring(TaskList.getIndex(input, "to") + 3)));
    }


    /**
     * Parses and adds a Deadline task from the user input.
     *
     * @param input The user command string.
     * @param task  The task list where the new task will be added.
     * @throws DavidException If the description of the task is missing.
     */
    private static void parseDeadline(String input, ArrayList<Task> task) throws DavidException {
        task.add(new Deadline((input.substring(TaskList.getIndex(input, " ") + 1, TaskList.getIndex(input, "/") - 1)), input.substring(TaskList.getIndex(input, "by") + 3)));
    }


}







