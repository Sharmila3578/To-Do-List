import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TodoManager manager = new TodoManager();
        Scanner sc = new Scanner(System.in);

        try {
            manager.loadTasks();
        } catch (Exception e) {
            System.out.println("Could not load saved tasks.");
        }

        while (true) {
            System.out.println("\nTo-Do List Menu");
            System.out.println("1. Add Task");
            System.out.println("2. List Tasks");
            System.out.println("3. Mark Task Completed");
            System.out.println("4. Delete Task");
            System.out.println("5. Exit");
            System.out.print("Choose: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Task description: ");
                    String desc = sc.nextLine();
                    manager.addTask(desc);
                    break;
                case 2:
                    manager.listTasks();
                    break;
                case 3:
                    System.out.print("Task number to complete: ");
                    manager.completeTask(sc.nextInt() - 1);
                    break;
                case 4:
                    System.out.print("Task number to delete: ");
                    manager.deleteTask(sc.nextInt() - 1);
                    break;
                case 5:
                    try {
                        manager.saveTasks();
                    } catch (Exception e) {
                        System.out.println("Failed to save tasks.");
                    }
                    System.out.println("Goodbye!");
                    return;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }
}
