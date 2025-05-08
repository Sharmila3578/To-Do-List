public class Task {
    private String description;
    private boolean completed;

    public Task(String description) {
        this.description = description;
        this.completed = false;
    }

    public void markCompleted() {
        this.completed = true;
    }

    public boolean isCompleted() {
        return completed;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return (completed ? "[x] " : "[ ] ") + description;
    }

    public String toDataString() {
        return description + ";" + completed;
    }

    public static Task fromDataString(String data) {
        String[] parts = data.split(";");
        Task task = new Task(parts[0]);
        if (parts.length > 1 && Boolean.parseBoolean(parts[1])) {
            task.markCompleted();
        }
        return task;
    }
}
