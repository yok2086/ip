import David.Storage;
import David.Ui;
import David.TaskList;
import David.Parser;
import David.ui.DavidException;


/**
 * The main class of the David application, responsible for initializing
 * the core components and handling user interactions.
 */
public class David {
    private Storage storage;
    private TaskList tasks;
    private Ui ui;
    private Parser parser;


    /**
     * Constructor for the David application.
     * Initializes the UI, storage, task list, and command parser.
     *
     * @param filePath The file path where tasks are stored.
     */
    public David(String filePath) {
        ui = new Ui();
        storage = new Storage(filePath);
        try {
            tasks = new TaskList(storage.loadTasks());
        } catch (DavidException e) {
            ui.showLoadingError();
            tasks = new TaskList();
        }
        parser = new Parser(ui, tasks, storage);
    }


    /**
     * Runs the main event loop of the application, handling user input.
     * The loop continues until the user enters the exit command.
     */
    public void run() {
        ui.printGreeting();
        ui.printHello();
        boolean isExit = false;
        while (!isExit) {
            String input = ui.readLine();
            isExit = parser.readCommand(input);
        }
        ui.printBye();
    }


    /**
     * The main entry point of the program.
     * Initializes the application and starts the event loop.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        new David("./data/tasks.txt").run();
    }
}









