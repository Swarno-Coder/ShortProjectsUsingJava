import java.util.Scanner;

public class SimplePaint {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[][] canvas = new char[10][10];

        for (int i = 0; i < canvas.length; i++) {
            for (int j = 0; j < canvas[i].length; j++) {
                canvas[i][j] = ' ';
            }
        }

        while (true) {
            System.out.println("\nCanvas:");
            for (int i = 0; i < canvas.length; i++) {
                for (int j = 0; j < canvas[i].length; j++) {
                    System.out.print(canvas[i][j]);
                }
                System.out.println();
            }

            System.out.print("\nEnter X, Y, and character (e.g., 2 3 *) or 'q' to quit: ");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("q")) {
                break;
            }

            String[] parts = input.split(" ");
            if (parts.length == 3) {
                try {
                    int x = Integer.parseInt(parts[0]);
                    int y = Integer.parseInt(parts[1]);
                    char character = parts[2].charAt(0);

                    if (x >= 0 && x < canvas.length && y >= 0 && y < canvas[0].length) {
                        canvas[x][y] = character;
                    } else {
                        System.out.println("Invalid coordinates.");
                    }
                } catch (NumberFormatException | IndexOutOfBoundsException e) {
                    System.out.println("Invalid input. Use format: X Y character");
                }
            } else {
                System.out.println("Invalid input. Use format: X Y character");
            }
        }

        System.out.println("Goodbye!");
        scanner.close();
    }
}
