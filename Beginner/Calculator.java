import java.util.*;

public class Calculator {

    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("*** Enhanced Console Calculator ***");
            System.out.println("1. Basic Arithmetic Operations");
            System.out.println("2. Scientific Calculations");
            System.out.println("3. Unit Conversions");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    ArithmeticOperations();
                    break;
                case 2:
                    ScientificCalculations();
                    break;
                case 3:
                    UnitConversions();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid option. Please choose again.");
            }
        } while (choice != 4);

        sc.close();
    }

    public static void ArithmeticOperations() {
        System.out.println("*** Basic Arithmetic Operations ***");
        System.out.print("Enter first number: ");
        double num1 = sc.nextDouble();
        System.out.print("Enter second number: ");
        double num2 = sc.nextDouble();

        System.out.println("Choose an operation:");
        System.out.println("1. Addition (+)");
        System.out.println("2. Subtraction (-)");
        System.out.println("3. Multiplication (*)");
        System.out.println("4. Division (/)");
        System.out.print("Your choice: ");
        int operation = sc.nextInt();

        // double result = 0;
        switch (operation) {
            case 1:
                System.out.println("Result: " + (num1 + num2));
                break;
            case 2:
                System.out.println("Result: " + (num1 - num2));
                break;
            case 3:
                System.out.println("Result: " + (num1 * num2));
                break;
            case 4:
                if (num2 != 0) {
                    System.out.println("Result: " + (num1 / num2));
                } else {
                    System.out.println("Error: Division by zero is not allowed.");
                    return;
                }
                break;
            default:
                System.out.println("Invalid operation.");
                return;
        }

        // System.out.println(result);
    }

    public static void ScientificCalculations() {
        System.out.println("*** Scientific Calculations ***");
        System.out.println("1. Square Root");
        System.out.println("2. Exponentiation");
        System.out.print("Choose a calculation: ");
        int operation = sc.nextInt();

        switch (operation) {
            case 1:
                System.out.print("Enter a number: ");
                double num = sc.nextDouble();
                if (num >= 0) {
                    System.out.println("Square Root: " + Math.sqrt(num));
                } else {
                    System.out.println("Error: Cannot calculate the square root of a negative number.");
                }
                break;
            case 2:
                System.out.print("Enter the base: ");
                double base = sc.nextDouble();
                System.out.print("Enter the exponent: ");
                double exponent = sc.nextDouble();
                System.out.println("Result: " + Math.pow(base, exponent));
                break;
            default:
                System.out.println("Invalid calculation.");
        }
    }

    public static void UnitConversions() {
        System.out.println("*** Unit Conversions ***");
        System.out.println("1. Temperature Conversion ");
        System.out.println("2. Currency Conversion ");
        System.out.print("Choose a conversion: ");
        int conversion = sc.nextInt();

        switch (conversion) {
            case 1:
                temperatureConversion();
                break;
            case 2:
                currencyConversion();
                break;
            default:
                System.out.println("Invalid conversion.");
        }
    }

    public static void temperatureConversion() {
        System.out.println("*** Temperature Conversion ***");
        System.out.println("1. Celsius to Fahrenheit");
        System.out.println("2. Fahrenheit to Celsius");
        System.out.print("Choose an option: ");
        int option = sc.nextInt();

        System.out.print("Enter temperature: ");
        double temperature = sc.nextDouble();

        switch (option) {
            case 1:
                double fahrenheit = (temperature * 9/5) + 32;
                System.out.println("Fahrenheit: " + fahrenheit);
                break;
            case 2:
                double celsius = (temperature - 32) * 5/9;
                System.out.println("Celsius: " + celsius);
                break;
            default:
                System.out.println("Invalid option.");
        }
    }

    public static void currencyConversion() {
        System.out.println("*** Currency Conversion ***");
        System.out.println("1. USD to INR");
        System.out.println("2. INR to USD");
        System.out.print("Choose an option: ");
        int option = sc.nextInt();

        System.out.print("Enter amount: ");
        double amount = sc.nextDouble();

        final double conversionRate = 82.0;  

        switch (option) {
            case 1:
                double inr = amount * conversionRate;
                System.out.println("Amount in INR: ₹" + inr);
                break;
            case 2:
                double usd = amount / conversionRate;
                System.out.println("Amount in USD: $" + usd);
                break;
            default:
                System.out.println("Invalid option.");
        }
    }
}
