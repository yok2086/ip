package David;
import java.util.ArrayList;
import David.task.Task;
import David.ui.DavidException;


public class Storage {
    private final String filePath;

    public Storage(String filePath) {
        this.filePath = filePath;
    }

    public ArrayList<Task> loadTasks() throws DavidException {
        return StorageManager.loadTasks(filePath);
    }

    public void saveTasks(ArrayList<Task> tasks) {
        StorageManager.saveTasks(tasks, filePath);
    }
}
