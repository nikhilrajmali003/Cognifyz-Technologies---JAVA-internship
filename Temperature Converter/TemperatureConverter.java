import java.util.InputMismatchException;
import java.util.Scanner;

public class TemperatureConverter {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    printMenu();
    int choice = readUserInput(scanner);

    double temperature = readTemperature(scanner);

    performConversion(choice, temperature);
  }

  private static void printMenu() {
    System.out.println("Temperature Converter");
    System.out.println("1. Celsius to Fahrenheit");
    System.out.println("2. Fahrenheit to Celsius");
    System.out.print("Enter your choice (1/2): ");
  }

  private static int readUserInput(Scanner scanner) {
    while (true) {
      try {
        int choice = scanner.nextInt();
        if (choice == 1 || choice == 2) {
          return choice;
        } else {
          System.out.println("Invalid choice. Please enter 1 or 2.");
        }
      } catch (InputMismatchException e) {
        System.out.println("Invalid input. Please enter a number.");
        scanner.next(); // discard invalid input
      }
    }
  }

  private static double readTemperature(Scanner scanner) {
    while (true) {
      try {
        double temperature = scanner.nextDouble();
        return temperature;
      } catch (InputMismatchException e) {
        System.out.println("Invalid input. Please enter a number.");
        scanner.next(); // discard invalid input
      }
    }
  }

  private static void performConversion(int choice, double temperature) {
    String result = switch (choice) {
      case 1 -> String.format("%.2f°C is equal to %.2f°F", temperature, convertCelsiusToFahrenheit(temperature));
      case 2 -> String.format("%.2f°F is equal to %.2f°C", temperature, convertFahrenheitToCelsius(temperature));
      default -> "Invalid choice";
    };
    System.out.println(result);
  }

  private static double convertCelsiusToFahrenheit(double celsius) {
    return (celsius * 9/5) + 32;
  }

  private static double convertFahrenheitToCelsius(double fahrenheit) {
    return (fahrenheit - 32) * 5/9;
  }
}