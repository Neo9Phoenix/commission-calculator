import java.util.Scanner;

class CommissionCalculator {

    public static final double BASE_SALARY = 5000.00;

    public static double computeIncome(double salesAmount) {
        double income = BASE_SALARY;

        if (salesAmount <= 5000) {
            income += salesAmount * 0.08;
        } else if (salesAmount <= 10000) {
            income += 5000 * 0.08;
            income += (salesAmount - 5000) * 0.10;
        } else {
            income += 5000 * 0.08;
            income += 5000 * 0.10;
            income += (salesAmount - 10000) * 0.12;
        }

        return income;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== COP Inc. Income Calculator ===");
        System.out.println("Type a sales amount (e.g., 8500) or type 'exit' to quit.");

        while (true) {
            System.out.print("\nEnter sales amount: $");

            String input = scanner.next();

            if (input.equalsIgnoreCase("exit")) {
                System.out.println("Goodbye!");
                break;
            }

            try {
                double sales = Double.parseDouble(input);

                if (sales < 0) {
                    System.out.println("Sales amount cannot be negative.");
                } else {
                    double income = CommissionCalculator.computeIncome(sales);
                    System.out.printf("Total income for $%.2f in sales is: $%.2f%n", sales, income);
                }

            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number or 'exit'.");
            }
        }

        scanner.close();
    }
}
