import java.util.Scanner;
public class David {
    public static void main(String[] args) {
//        String logo = " ____        _        \n"
//                + "|  _ \\ _   _| | _____ \n"
//                + "| | | | | | | |/ / _ \\\n"
//                + "| |_| | |_| |   <  __/\n"
//                + "|____/ \\__,_|_|\\_\\___|\n";
//        System.out.println("Hello from\n" + logo);

        System.out.println("____________________________________________________________\n" +
                " Hello! I'm David\n" +
                " What can I do for you?\n" +
                "____________________________________________________________\n");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        while(!input.equals("bye")) {

            System.out.println("____________________________________________________________\n"
                    + input + "!!\n" + "____________________________________________________________");
            input = scanner.nextLine();
        }

        System.out.println(" Bye. Hope to see you again soon!\n" +
                "____________________________________________________________");
    }
}