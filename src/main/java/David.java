import java.util.Scanner;
import java.io.FileNotFoundException;
import David.Storage;
import David.Ui;
import David.TaskList;
import David.Parser;
import David.ui.DavidException;

public class David {
    private Storage storage;
    private TaskList tasks;
    private Ui ui;
    private Parser parser;

    public David(String filePath) {
        ui = new Ui();
        storage = new Storage(filePath);
        try {
            tasks = new TaskList(storage.loadTasks());
        }
        catch (DavidException e) {
            ui.showLoadingError();
            tasks = new TaskList();
        }
        parser = new Parser(ui, tasks, storage);
    }

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

    public static void main(String[] args) {
        new David("./data/tasks.txt").run();
    }
}




