import java.util.Scanner;

public class HangmanGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] words = {"apple", "banana", "cherry", "grape", "orange"};
        String word = words[(int) (Math.random() * words.length)];
        char[] guessedWord = new char[word.length()];
        int attempts = 6;

        for (int i = 0; i < guessedWord.length; i++) {
            guessedWord[i] = '_';
        }

        System.out.println("Welcome to Hangman!");
        while (attempts > 0) {
            System.out.println("Word: " + String.valueOf(guessedWord));
            System.out.println("Attempts left: " + attempts);
            System.out.print("Guess a letter: ");
            char guess = scanner.next().charAt(0);

            boolean found = false;
            for (int i = 0; i < word.length(); i++) {
                if (word.charAt(i) == guess) {
                    guessedWord[i] = guess;
                    found = true;
                }
            }

            if (!found) {
                attempts--;
            }

            if (word.equals(String.valueOf(guessedWord))) {
                System.out.println("Congratulations! You guessed the word: " + word);
                break;
            }
        }

        if (attempts == 0) {
            System.out.println("You ran out of attempts. The word was: " + word);
        }

        scanner.close();
    }
}
