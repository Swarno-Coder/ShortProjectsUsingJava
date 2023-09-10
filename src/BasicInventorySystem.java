import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
class InventoryItem {
    private final String name;
    private final String description;
    private int quantity;

    public InventoryItem(String name, String description, int quantity) {
        this.name = name;
        this.description = description;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }


    public String getDescription() {
        return description;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}


public class BasicInventorySystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<InventoryItem> inventory = new ArrayList<>();

        while (true) {
            System.out.println("\nInventory System Menu:");
            System.out.println("1. Add Item");
            System.out.println("2. View Inventory");
            System.out.println("3. Update Quantity");
            System.out.println("4. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter item name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter item description: ");
                    String description = scanner.nextLine();
                    System.out.print("Enter item quantity: ");
                    int quantity = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character
                    InventoryItem item = new InventoryItem(name, description, quantity);
                    inventory.add(item);
                    System.out.println("Item added to inventory.");
                }
                case 2 -> {
                    System.out.println("\nInventory:");
                    for (InventoryItem i : inventory) {
                        System.out.println("Name: " + i.getName());
                        System.out.println("Description: " + i.getDescription());
                        System.out.println("Quantity: " + i.getQuantity());
                        System.out.println();
                    }
                }
                case 3 -> {
                    System.out.print("Enter item name to update quantity: ");
                    String itemName = scanner.nextLine();
                    System.out.print("Enter new quantity: ");
                    int newQuantity = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character
                    for (InventoryItem i : inventory) {
                        if (i.getName().equalsIgnoreCase(itemName)) {
                            i.setQuantity(newQuantity);
                            System.out.println("Quantity updated.");
                            break;
                        }
                    }
                }
                case 4 -> {
                    System.out.println("Goodbye!");
                    scanner.close();
                    System.exit(0);
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
