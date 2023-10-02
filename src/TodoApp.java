import java.util.LinkedList;
import java.util.Scanner;

public class TodoList {
    private LinkedList<String> tasks;

    public TodoList() {
        tasks = new LinkedList<>();
    }

    public void addTask(String task) {
        tasks.add(task);
    }

    public void removeTask(int index) {
        if(index >= 0 && index < tasks.size()) {
            tasks.remove(index);
        }
    }

    public void viewTasks() {
        for(int i = 0; i < tasks.size(); i++) {
            System.out.println((i + 1) + ". " + tasks.get(i));
        }
    }

    public static void main(String[] args) {
        TodoList todoList = new TodoList();
        Scanner scanner = new Scanner(System.in);

        while(true) {
            System.out.println("1. Add task");
            System.out.println("2. Remove task");
            System.out.println("3. View tasks");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch(choice) {
                case 1:
                    System.out.print("Enter a task: ");
                    String task = scanner.nextLine();
                    todoList.addTask(task);
                    break;
                case 2:
                    System.out.print("Enter the task number to remove: ");
                    int index = scanner.nextInt();
                    todoList.removeTask(index - 1);
                    break;
                case 3:
                    todoList.viewTasks();
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 4.");
            }
        }
    }
}
