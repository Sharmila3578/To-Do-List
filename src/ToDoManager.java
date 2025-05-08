import java.io.*;
import java.util.*;

public class TodoManager {
    private List<Task> tasks = new ArrayList<>();
    private final String fileName = "tasks.txt";

    public void addTask(String desc) {
        tasks.add(new Task(desc));
    }

    public void listTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks available.");
            return;
        }
        int i = 1;
        for (Task task : tasks) {
            System.out.println(i++ + ". " + task);
        }
    }

    public void completeTask(int index) {
        if (index >= 0 && index < tasks.size()) {
            tasks.get(index).markCompleted();
        }
    }

    public void deleteTask(int index) {
        if (index >= 0 && index < tasks.size()) {
            tasks.remove(index);
        }
    }

    public void saveTasks() throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
        for (Task task : tasks) {
            writer.write(task.toDataString());
            writer.newLine();
        }
        writer.close();
    }

    public void loadTasks() throws IOException {
        File file = new File(fileName);
        if (!file.exists()) return;
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String line;
        while ((line = reader.readLine()) != null) {
            tasks.add(Task.fromDataString(line));
        }
        reader.close();
    }
}
