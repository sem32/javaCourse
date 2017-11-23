import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class SimpleCalc {

    private static int retryCounter = 3;

    private static double scanInput() throws InputMismatchException {
        double value;

        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(Locale.ENGLISH);
        retryCounter--;

        try {
            value = scanner.nextDouble();
            retryCounter = 3;
        } catch (InputMismatchException e) {
            if (retryCounter <= 0 ) {
                throw new InputMismatchException("Wrong input data");
            }
            System.out.println("You have " + retryCounter + " attempts.\n" +
                    "Please retype current number:");
            return scanInput();
        }

        return value;
    }

    public static void main(String[] args) {
        double firstNumber;
        double secondNumber;

        try {
            System.out.println("Please input first number:");
            firstNumber = scanInput();
            System.out.println("Your input " + firstNumber + " as a first number.");

            System.out.println("Please input second number:");
            secondNumber = scanInput();
            System.out.println("Your input " + secondNumber + " as a second number.");
        } catch (InputMismatchException e) {
            System.out.println(e.getMessage());
            return;
        }

        System.out.println("Your");
        System.out.println("Sum is " + (firstNumber + secondNumber));
        System.out.println("Difference is " + (firstNumber > secondNumber ? firstNumber - secondNumber : secondNumber - firstNumber));
        System.out.println("Multiplication is " + (firstNumber * secondNumber));
        System.out.println("Division is " + (secondNumber == 0 ? "ERROR: \"Can't have division by zero\"" : firstNumber / secondNumber));
    }
}
