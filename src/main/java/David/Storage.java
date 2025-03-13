package David;


import java.util.ArrayList;


import David.task.Task;
import David.ui.DavidException;


/**
 * Handles the storage of tasks by reading from and writing to a file.
 * Uses StorageManager to perform actual file operations.
 */
public class Storage {
    private final String filePath;


    /**
     * Constructor for Storage.
     *
     * @param filePath The file path where tasks will be loaded from and saved to.
     */
    public Storage(String filePath) {
        this.filePath = filePath;
    }


    /**
     * Loads tasks from the specified file.
     *
     * @return An ArrayList of Task objects loaded from the file.
     * @throws DavidException If an error occurs during file reading.
     */
    public ArrayList<Task> loadTasks() throws DavidException {
        return StorageManager.loadTasks(filePath);
    }


    /**
     * Saves the list of tasks to the specified file.
     *
     * @param tasks The list of tasks to be saved.
     */
    public void saveTasks(ArrayList<Task> tasks) {
        StorageManager.saveTasks(tasks, filePath);
    }
}

