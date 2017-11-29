import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class SimpleCalc {

    private static double scanNumInput() {
        double value;

        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(Locale.ENGLISH);

        try {
            value = scanner.nextDouble();
        } catch (InputMismatchException e) {
            System.out.print("Wrong input current value. Use digits only: ");
            return scanNumInput();
        }

        return value;
    }

    private static char scanCharInput() {
        String value;
        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(Locale.ENGLISH);

        try {
            String pattern = "[*/+-]";
            value = scanner.next(pattern);
        } catch (InputMismatchException e) {
            System.out.print("Wrong input operation symbol. Use *, /, + or -. Please retype it: ");
            return scanCharInput();
        }

        return value.charAt(0);
    }

    public static void main(String[] args) {
        double firstNumber;
        char operation;
        double secondNumber;

        System.out.print("Please input first number: ");
        firstNumber = scanNumInput();

        System.out.print("Please input operation symbol: ");
        operation = scanCharInput();

        System.out.print("Please input second number: ");
        for (;;) {
            secondNumber = scanNumInput();
            if (operation == '/' && secondNumber == 0) {
                System.out.print("Second value can't be 0 for operation /. Please retype it: ");
                continue;
            }
            break;
        }

        double res = 0;
        switch (operation) {
            case '+':
                res = firstNumber + secondNumber;
                break;
            case '-':
                res = firstNumber - secondNumber;
                break;
            case '*':
                res = firstNumber * secondNumber;
                break;
            case '/':
                res = firstNumber / secondNumber;
                break;
        }

        System.out.println("Your result: " + firstNumber + " " + operation + " " + secondNumber + " = " + res);
    }
}
