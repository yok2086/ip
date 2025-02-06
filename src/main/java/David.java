import java.util.Scanner;

public class David {
    public static final String LINE_SEPERATOR = "____________________________________________________________";

    public static void main(String[] args) {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);
        String[] values = new String[100];
        Task[] task = new Task[100];

        printHello();
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        int i = 0;
        while (!input.equals("bye")) {
            if (input.equals("list")) {
                System.out.println(LINE_SEPERATOR + "\n" + "Here are the tasks in your list:\n");
                for (int j = 0; j < i; j++) {
                    System.out.println((j + 1) + "." + "[" + task[j].getStatusIcon() + "] " + values[j] + "\n" + LINE_SEPERATOR);
                    int index = input.indexOf(" ");
                }
            } else if (input.startsWith("mark")) {
                markTask(task, getIndex(input));
                printMark(task, getIndex(input));

            } else if (input.startsWith("unmark")) {
                unmarkTask(task, getIndex(input));
                printUnmark(task, getIndex(input));
            } else {
                System.out.println(LINE_SEPERATOR + "\n"
                        + "added: " + input + "\n" + LINE_SEPERATOR);
                values[i] = input;  // store user input in array
                task[i] = new Task(input);
                i++;
            }
            input = scanner.nextLine();

        }
        printBye();
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

    public static void markTask(Task[] task, int index) {
        task[index].isDone = true;
        ;
    }

    public static void unmarkTask(Task[] task, int index) {
        task[index].isDone = false;
    }

    public static void printMark(Task[] task, int index) {
        System.out.println(LINE_SEPERATOR + "\n" + "Nice! I've marked this task as done:\n" + "[" + task[index].getStatusIcon() + "] " + task[index].getDescription() + "\n" + LINE_SEPERATOR);
    }

    public static void printUnmark(Task[] task, int index) {
        System.out.println(LINE_SEPERATOR + "\n" + "[" + task[index].getStatusIcon() + "] " + task[index].getDescription() + "\n" + LINE_SEPERATOR);
    }

    public static int getIndex(String marking) {
        int index = marking.indexOf(" ");
        return (Integer.parseInt(marking.substring(index + 1)) - 1);
    }
}

