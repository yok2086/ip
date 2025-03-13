package David;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;


import David.deadline.Deadline;
import David.event.Event;
import David.task.Task;
import David.todo.Todo;


public class StorageManager {
    public static void saveTasks(ArrayList<Task> task, String filePath) {
        try {
            Files.createDirectories(Paths.get("./data")); // Ensure directory exists
            BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));
            for (Task t : task) {
                writer.write(t.toFileFormat());
                writer.newLine();
            }
            writer.close();
            System.out.println("Tasks saved to " + filePath);
        } catch (IOException e) {
            System.err.println("Error saving tasks: " + e.getMessage());
        }
    }


    /**
     * Loads the list of tasks from the specified file.
     *
     * @param filePath The path of the file to load tasks from.
     * @return The list of tasks loaded from the file.
     */
    public static ArrayList<Task> loadTasks(String filePath) {
        File file = new File(filePath);
        ArrayList<Task> tasks = new ArrayList<>();
        if (!file.exists()) {
            System.out.println("File not found. Returning an empty task list.");
            return tasks;
        }


        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(" \\| ");
                if (parts.length < 3) {
                    System.out.println("Skipping invalid task entry: " + line);
                    continue;
                }


                String taskType = parts[0];
                boolean isDone = "1".equals(parts[1]);
                String description = parts[2];
                Task task;
                // Create tasks based on the task type
                if ("T".equals(taskType)) {
                    task = new Todo(description);
                } else if ("D".equals(taskType) && parts.length > 3) {
                    task = new Deadline(description, parts[3]);
                } else if ("E".equals(taskType) && parts.length > 4) {
                    task = new Event(description, parts[3], parts[4]);
                } else {
                    System.out.println("Unknown task type: " + taskType);
                    continue;
                }
                tasks.add(task);
            }
        } catch (IOException e) {
            // Print an error message if there's an issue while reading the file
            System.err.println("Error while reading tasks: " + e.getMessage());
        }
        return tasks;
    }
}

