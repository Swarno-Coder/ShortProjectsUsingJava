import java.util.Scanner;

class Operations{
    public double add(double a, double b){
        return a+b;
    }
    public double sub(double a, double b){
        return a-b;
    }
    public double mul(double a, double b){
        return a*b;
    }
    public double div(double a, double b){
        return a/b;
    }

}
public class SimpleCalculator {
    public static void main(String[] args) {
        Operations op = new Operations();
        Scanner sc = new Scanner(System.in);
        double a,b, answer=0;

        System.out.println("Basic Calculator");
        while (true){
            System.out.println("1. Addition");
            System.out.println("2. Subtraction");
            System.out.println("3. Multiplication");
            System.out.println("4. Divition");
            System.out.println("5. Exit");
            int choice = sc.nextInt();
            switch (choice) {
                case 1 -> {
                    System.out.println("Enter two numbers:");
                    a = sc.nextDouble();
                    b = sc.nextDouble();
                    answer = op.add(a, b);
                }
                case 2 -> {
                    System.out.println("Enter two numbers:");
                    a = sc.nextDouble();
                    b = sc.nextDouble();
                    answer = op.sub(a, b);
                }
                case 3 -> {
                    System.out.println("Enter two numbers:");
                    a = sc.nextDouble();
                    b = sc.nextDouble();
                    answer = op.mul(a, b);
                }
                case 4 -> {
                    System.out.println("Enter two numbers:");
                    a = sc.nextDouble();
                    b = sc.nextDouble();
                    answer = op.div(a, b);
                }
                case 5 -> {
                    sc.close();
                    System.exit(0);
                }
                default -> System.out.println("Invalid choice");
            }
            System.out.println("Answer is:"+ answer);
        }
    }
}
