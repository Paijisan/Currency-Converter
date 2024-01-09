import java.util.Scanner;

// Create a new Java class and call it CurrencyConverter
public class CurrencyConverter {
    
    public static void main(String[] args) {
        // Accept user input
        Scanner scanner = new Scanner(System.in); // Create the Scanner object

        // Prompt for user input
        System.out.println("Enter the amount: ");
        double amount = scanner.nextDouble(); // Create amount variable for user

        // Prompt user to select the 'from' country
        System.out.println("Please select the 'from' country: (USD, EUR, GBP, JPY): ");
        String fromCurrency = scanner.next().toUpperCase();

        // Prompt user to select the 'to' country
        System.out.println("Please select the 'to' country: (USD, EUR, GBP, JPY): ");
        String toCurrency = scanner.next().toUpperCase();

        // Display the results
        double exchangeRate = getExchangeRates(fromCurrency, toCurrency);

        // Test that it is a valid input
        if (exchangeRate != -1) {
            double result = convertCurrency(amount, exchangeRate);
            System.out.printf("%.2f %s is equal to %.2f %s%n", amount, fromCurrency, result, toCurrency);
        }
        else
        {
            System.out.println("Invlaid currencies selected.");
        }

        scanner.close();
    }

    // Implement currency conversion logic
    public static double getExchangeRates(String fromCurrency, String toCurrency) {
        switch (fromCurrency) {
            case "USD":
                switch (toCurrency) {
                    case "EUR":
                        return 0.9124;
                    case "GBP":
                        return 0.784253;
                    case "JPY":
                        return 144.10;
                }
                break;
            case "EUR":
                switch (toCurrency) {
                    case "USD":
                        return 1.095796;
                    case "GBP":
                        return 0.8595;
                    case "JPY":
                        return 157.896275;
                }
                break;
            case "GBP":
                switch (toCurrency) {
                    case "USD":
                        return 1.274;
                    case "EUR":
                        return 1.163;
                    case "JPY":
                        return 183.695920;
                }
                break;
            case "JPY":
                switch (toCurrency) {
                    case "USD":
                        return 0.006938;
                    case "EUR":
                        return 0.006334;
                    case "GBP":
                        return 0.005444;
                }
                break;
        }
        return -1;
    }

    // Create a method to convert the amount multiplied by the rate
    private static double convertCurrency(double amount, double exchangeRate) {
        return amount * exchangeRate;
    }
}
