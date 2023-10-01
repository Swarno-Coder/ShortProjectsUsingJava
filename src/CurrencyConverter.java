public class CurrencyConverter {
    public static void main(String[] args) {
        
        double usdToEurRate = 0.85;
        double usdToGbpRate = 0.74;
        double usdToJpyRate = 110.23;
        
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the amount in USD: ");
        double usdAmount = scanner.nextDouble();

        System.out.print("Enter the target currency (EUR, GBP, JPY): ");
        scanner.nextLine();
        
        String targetCurrency = scanner.nextLine().toUpperCase();
        double convertedAmount = 0.0;

        switch (targetCurrency) {
            case "EUR":
                convertedAmount = usdAmount * usdToEurRate;
                break;
            case "GBP":
                convertedAmount = usdAmount * usdToGbpRate;
                break;
            case "JPY":
                convertedAmount = usdAmount * usdToJpyRate;
                break;
            default:
                System.out.println("Invalid target currency.");
                return;
        }

        System.out.println(usdAmount + " USD is equivalent to " + convertedAmount + " " + targetCurrency);
    }
}
