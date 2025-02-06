import java.util.Scanner;
public class David {
    public static void main(String[] args) {
//        String logo = " ____        _        \n"
//                + "|  _ \\ _   _| | _____ \n"
//                + "| | | | | | | |/ / _ \\\n"
//                + "| |_| | |_| |   <  __/\n"
//                + "|____/ \\__,_|_|\\_\\___|\n";
//        System.out.println("Hello from\n" + logo);
        String[] values = new String[100];
        System.out.println("____________________________________________________________\n" +
                " Hello! I'm David\n" +
                " What can I do for you?\n" +
                "____________________________________________________________\n");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        int i = 0;
        while (!input.equals("bye")) {
            if(input.equals("list")) {
                for (int j = 0; j < i ; j++) {
                    System.out.println("____________________________________________________________\n" + (j + 1) + "." + values[j]);
                }
            }
            else {
                System.out.println("____________________________________________________________\n"
                        + "added: " + input + "\n" + "____________________________________________________________");
                values[i] = input;  // store user input in array
                i++;
            }
            input = scanner.nextLine();


        }
        System.out.println(" Bye. Hope to see you again soon!\n" +
                "____________________________________________________________");
    }
}
