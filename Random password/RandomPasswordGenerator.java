import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class RandomPasswordGenerator {
    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()_+-=";

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int passwordLength;
            while (true) {
                System.out.print("Enter the desired password length (min 8, max 128): ");
                try {
                    passwordLength = scanner.nextInt();
                    if (passwordLength < 8 || passwordLength > 128) {
                        System.out.println("Password length must be between 8 and 128 characters.");
                        continue;
                    }
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a numeric value.");
                    scanner.next(); // Consume the invalid input
                }
            }

            String password = generatePassword(passwordLength);
            System.out.println("Generated password: " + password);
        }
    }

    public static String generatePassword(int length) {
        Random random = new Random();
        StringBuilder password = new StringBuilder();

        for (int i = 0; i < length; i++) {
            password.append(CHARACTERS.charAt(random.nextInt(CHARACTERS.length())));
        }

        return password.toString();
    }
}