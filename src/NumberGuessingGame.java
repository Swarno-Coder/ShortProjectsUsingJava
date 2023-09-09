import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        int upperBound = 100;
        int lowwerBound = 1;
        int numberToGuess = random.nextInt(lowwerBound,upperBound);
        int counter = 10;
        for(int i = 1 ; i <= counter ; i++) {
            System.out.print("Enter the number: ");
            int input = sc.nextInt();
            if (input == numberToGuess) {
                System.out.println("Success!!!");
                break;
            }
            else
                System.out.println("Alas!! Try Again!!   Remaining Try Left: " + (counter-i));
        }
    }
}
