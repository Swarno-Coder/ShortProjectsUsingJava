import java.util.Random;

public class RandomNameGenerator {
    public static void main(String[] args) {
        String[] firstNames = {
                "John", "Alice", "Michael", "Emma", "David", "Sophia", "Daniel", "Olivia", "James", "Emily"
        };

        String[] lastNames = {
                "Smith", "Johnson", "Brown", "Davis", "Wilson", "Lee", "Clark", "Harris", "Young", "Walker"
        };

        Random random = new Random();

        String randomFirstName = firstNames[random.nextInt(firstNames.length)];
        String randomLastName = lastNames[random.nextInt(lastNames.length)];

        System.out.println("Random Name: " + randomFirstName + " " + randomLastName);
    }
}
