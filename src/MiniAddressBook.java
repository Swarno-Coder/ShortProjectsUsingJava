import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

class Contact{
    private String name;
    private int number;
    public void setName(String name) {
        this.name = name;
    }
    public void setNumber(int number) {
        this.number = number;
    }
    public String getName() {
        return name;
    }
    public int getNumber() {
        return number;
    }
}
public class MiniAddressBook {
    public static void main(String[] args) {
        ArrayList<Contact> contacts = new ArrayList<>();
        Contact contact = new Contact();
        Scanner sc = new Scanner(System.in);
        String name;
        int number;
        do {
            System.out.println("--Mini Address Book--");
            System.out.println("1. Add a number");
            System.out.println("2. Delete a number");
            System.out.println("3. Search a number");
            System.out.println("4. Exit");
            short choice = sc.nextShort();
            switch (choice) {
                case 1 -> {
                    System.out.println("Enter the number: ");
                    number = sc.nextInt();
                    System.out.println("Enter the name: ");
                    name = sc.next();
                    contact.setNumber(number);
                    contact.setName(name);
                    contacts.add(contact);
                    System.out.println("Number added: " + name + " -> " + number);
                }
                case 2 -> {
                    System.out.println("Delete by number(1) or name(2)?");
                    choice = sc.nextShort();
                    switch (choice) {
                        case 1 -> {
                            System.out.println("Enter the number: ");
                            number = sc.nextInt();
                            for (int i = 0; i < contacts.size(); i++) {
                                if (number == contacts.get(i).getNumber()) {
                                    contacts.remove(i);
                                }
                            }
                        }
                        case 2 -> {
                            System.out.println("Enter the name: ");
                            name = sc.next();
                            for (int i = 0; i < contacts.size(); i++) {
                                if (Objects.equals(name, contacts.get(i).getName())) {
                                    contacts.remove(i);
                                }
                            }
                        }
                        default -> {
                            System.out.println("Invalid Choice");
                        }
                    }
                }
                case 3 -> {
                    System.out.println("Search by number(1) or name(2)?");
                    choice = sc.nextShort();
                    switch (choice) {
                        case 1 -> {
                            System.out.println("Enter the number: ");
                            number = sc.nextInt();
                            for (int i = 0; i < contacts.size(); i++) {
                                if (number == contacts.get(i).getNumber()) {
                                    System.out.println("Number found: \n" + contacts.get(i).getName() + " " + contacts.get(i).getNumber());
                                }
                            }
                        }
                        case 2 -> {
                            System.out.println("Enter the name: ");
                            name = sc.next();
                            for (int i = 0; i < contacts.size(); i++) {
                                if (Objects.equals(name, contacts.get(i).getName())) {
                                    System.out.println("Number found: \n" + contacts.get(i).getName() + " " + contacts.get(i).getNumber());
                                }
                            }
                        }
                        default -> {
                            System.out.println("Invalid Choice");
                        }
                    }
                }
                case 4 -> {
                    System.out.println("Exiting...");
                    sc.close();
                    System.exit(0);
                }
                default -> {
                    System.out.println("Invalid Choice...");
                }
            }
        }while (true);
    }
}
