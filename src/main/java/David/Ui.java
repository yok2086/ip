package David;


import java.util.ArrayList;
import java.util.Scanner;


import David.task.Task;


public class Ui {
    public static final String LINE_SEPERATOR = "____________________________________________________________";
    private Scanner scanner;


    /**
     * Constructs a Ui instance and initializes the scanner for user input.
     */
    public Ui() {
        scanner = new Scanner(System.in);
    }


    /**
     * Prints the task type and details when a task is added.
     *
     * @param task The list of tasks.
     * @param i    The index of the task in the list.
     * @return A string containing the message about the added task.
     */
    public static String printTaskType(ArrayList<Task> task, int i) {
        return LINE_SEPERATOR + System.lineSeparator() + " Got it. I've added this task:" + System.lineSeparator()
                + task.get(i).toString() + System.lineSeparator()
                + "Now you have " + (i + 1) + " tasks in the list." + System.lineSeparator() + LINE_SEPERATOR;
    }


    /**
     * Prints the greeting message and logo when the program starts.
     */
    public void printGreeting() {
        String logo = "  ______        ____    ,---.  ,---..-./`)  ______                      .---.  \n" +
                "|    _ `''.  .'  __ `. |   /  |   |\\ .-.')|    _ `''.                  \\   /  \n" +
                "| _ | ) _  \\/   '  \\  \\|  |   |  .'/ `-' \\| _ | ) _  \\                 |   |  \n" +
                "|( ''_'  ) ||___|  /  ||  | _ |  |  `-'`\"`|( ''_'  ) |                  \\ /   \n" +
                "| . (_) `. |   _.-`   ||  _( )_  |  .---. | . (_) `. |                   v    \n" +
                "|(_    ._) '.'   _    |\\ (_ o._) /  |   | |(_    ._) '                  _ _   \n" +
                "|  (_.\\.' / |  _( )_  | \\ (_,_) /   |   | |  (_.\\.' /                  (_I_)  \n" +
                "|       .'  \\ (_ o _) /  \\     /    |   | |       .'                  (_(=)_) \n" +
                "'-----'`     '.(_,_).'    `---`     '---' '-----'`                     (_I_)  \n" +
                "                                                                             ";
        System.out.println("Hello from\n" + logo);
    }


    /**
     * Reads a line of input from the user, trimming leading and trailing spaces.
     *
     * @return The trimmed input from the user.
     */
    public String readLine() {
        return scanner.nextLine().trim();
    }


    /**
     * Prints a welcome message when the program starts.
     */
    public void printHello() {
        System.out.println(LINE_SEPERATOR + "\n" +
                " Hello! I'm David\n" +
                " What can I do for you?\n" +
                LINE_SEPERATOR + "\n");
    }


    /**
     * Prints a goodbye message when the program ends.
     */
    public static void printBye() {
        System.out.println(" Bye. Hope to see you again soon!\n" +
                LINE_SEPERATOR);
    }


    /**
     * Prints a message when a task is marked as done.
     *
     * @param task  The list of tasks.
     * @param index The index of the task in the list.
     */
    public static void printMark(ArrayList<Task> task, int index) {
        System.out.println(LINE_SEPERATOR + "\n" + "Nice! I've marked this task as done:\n" + "[" + task.get(index).getStatusIcon() + "] " + task.get(index).getDescription() + "\n" + LINE_SEPERATOR);
    }


    /**
     * Prints a message when a task is unmarked.
     *
     * @param task  The list of tasks.
     * @param index The index of the task in the list.
     */
    public static void printUnmark(ArrayList<Task> task, int index) {
        System.out.println(LINE_SEPERATOR + "\n" + "Okay! I've marked this task as not done:\n" + "[" + task.get(index).getStatusIcon() + "] " + task.get(index).getDescription() + "\n" + LINE_SEPERATOR);
    }


    /**
     * Prints an error message when there is an issue loading a file.
     */
    public static void showLoadingError() {
        System.out.println(LINE_SEPERATOR);
        System.out.println("The file could not be loaded.");
        System.out.println(LINE_SEPERATOR);
    }


}





