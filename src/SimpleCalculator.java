import java.util.Scanner;

class Operations{
    public double add(int l){
        double sum = 0;
        double a;
        for(int i = 0; i < l; i++){
        System.out.println("Enter a number...");
            a=sc.nextDouble();
            sum=sum+a;
        }
        return sum ;
    }
    public double sub(double a, double b){
        if(a>b)
            return a-b;
        else
            return b-a;
    }
    public double mul(int l){
        double pro = 1;
        double a;
        for(int i = 0 ; i < l ; i++){
            System.out.println("Enter a number...");
            a=sc.nextDouble();
            pro=pro*a;
        }
        return pro;
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
        int l;
        
        System.out.println("Basic Calculator");
        while (true){
            System.out.println("Press 1 for Addition");
            System.out.println("Press 2 for Subtraction");
            System.out.println("Press 3 for Multiplication");
            System.out.println("Press 4 for Divition");
            System.out.println("Press 5 to Exit");
            int choice = sc.nextInt();
            switch (choice) {
                case 1 -> {
                    System.out.println("How many numbers do you want to add? :");
                    l=sc.nextInt();
                    answer = op.add(l);
                }
                case 2 -> {
                    System.out.println("Enter two numbers:");
                    a = sc.nextDouble();
                    b = sc.nextDouble();
                    answer = op.sub(a, b);
                }
                case 3 -> {
                    System.out.println("How many numbers do you want to multiply? :");
                    l=sc.nextInt();
                    answer = op.mul(l);
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
