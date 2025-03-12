package David;

import java.util.ArrayList;
import java.util.Scanner;
import David.task.Task;

public class Ui {
    public static final String LINE_SEPERATOR = "____________________________________________________________";
    private Scanner scanner;

    public Ui() {
        scanner = new Scanner(System.in);
    }

    public static String printTaskType(ArrayList<Task> task, int i) {
        return LINE_SEPERATOR + System.lineSeparator() + " Got it. I've added this task:" + System.lineSeparator()
                + task.get(i).toString() + System.lineSeparator()
                + "Now you have " + (i + 1) + " tasks in the list." + System.lineSeparator() + LINE_SEPERATOR;
    }
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

    public String readLine() {
        return scanner.nextLine().trim();
    }

    public void printHello() {
        System.out.println(LINE_SEPERATOR + "\n" +
                " Hello! I'm David\n" +
                " What can I do for you?\n" +
                LINE_SEPERATOR + "\n");
    }

    public static void printBye() {
        System.out.println(" Bye. Hope to see you again soon!\n" +
                LINE_SEPERATOR);
    }

    public static void printMark(ArrayList<Task> task, int index) {
        System.out.println(LINE_SEPERATOR + "\n" + "Nice! I've marked this task as done:\n" + "[" + task.get(index).getStatusIcon() + "] " + task.get(index).getDescription() + "\n" + LINE_SEPERATOR);
    }

    public static void printUnmark(ArrayList<Task> task, int index) {
        System.out.println(LINE_SEPERATOR + "\n" + "[" + task.get(index).getStatusIcon() + "] " + task.get(index).getDescription() + "\n" + LINE_SEPERATOR);
    }

    public static void showLoadingError() {
        System.out.println(LINE_SEPERATOR);
        System.out.println("The file could not be loaded.");
        System.out.println(LINE_SEPERATOR);
    }

    public static void printError(String message) {
        System.out.println(LINE_SEPERATOR);
        System.out.println("OOPS! Your input is invalid.");
        System.out.println("[ Please refer to the error message ] \n- [error]: "+ message);
        System.out.println(LINE_SEPERATOR);
    }
}


