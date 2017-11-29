import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class HomeTask2 {

    private static double scanDoubleInput() {
        double value;

        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(Locale.ENGLISH);

        try {
            value = scanner.nextDouble();
        } catch (InputMismatchException e) {
            System.out.print("Wrong input current value. Use digits only: ");
            return scanDoubleInput();
        }

        return value;
    }

    private static int scanIntInput() {
        int value;

        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(Locale.ENGLISH);

        try {
            value = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.print("Wrong input current value. Use digits only: ");
            return scanIntInput();
        }

        return value;
    }

    private static String scanStringInput() {
        String value;

        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(Locale.ENGLISH);

        try {
            value = scanner.next();
        } catch (InputMismatchException e) {
            System.out.print("Wrong input current value. Retype it: ");
            return scanStringInput();
        }

        return value;
    }

    private static void average() {
        double firstNumber;
        double secondNumber;

        System.out.println("****** Average ******");
        System.out.print("Please input first number: ");
        firstNumber = scanDoubleInput();

        System.out.print("Please input second number: ");
        secondNumber = scanDoubleInput();

        System.out.println("Your result: " + ((Math.abs(firstNumber)  + Math.abs(secondNumber)) / 2));
    }

    private static void averageCount() {
        double sum = 0;
        int counter = 0;

        System.out.println("****** Average Count ******");
        System.out.println("Enter digit then press Enter, for stop any not digit value: ");

        while (true) {
            try {
                sum += Double.valueOf(scanStringInput());
            } catch (NumberFormatException e) {
                break;
            }
            counter++;
        }

        if (counter > 0) {
            System.out.println("Your result: " + (sum / counter));
        } else {
            System.out.println("Your result: 0");
        }
    }

    private static void bank() {
        double sum;
        double percent;
        int year;

        System.out.println("****** Bank ******");
        System.out.print("Please enter sum of your contribution (uah): ");
        sum = scanDoubleInput();

        System.out.print("Please enter bank % per year: ");
        percent = scanDoubleInput();

        System.out.print("Please enter quantity of years: ");
        year = scanIntInput();

        for (int i = 1; i < year; i++) {
            double newFee = (sum / 100) * percent;
            sum += newFee;
            System.out.println("For year: " + i + " your %: " + newFee + ", your current contribution sum: " + sum);
        }
    }

    private static void graphRectangle() {
        int height;
        int width;
        System.out.println("****** Print rectangle ******");
        System.out.print("Please enter height: ");
        height = scanIntInput();

        System.out.print("Please enter width: ");
        width = scanIntInput();

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (i == 0 || i == height-1 || j == 0 || j == width-1) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println("");
        }
    }

    private static void graphEnvelope() {
        int height;
        int width;
        System.out.println("****** Print envelope ******");
        System.out.print("Please enter height: ");
        height = scanIntInput();

        System.out.print("Please enter width: ");
        width = scanIntInput();

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                int k = i * width / height;
                if (i == 0 || j == 0 ||
                    i == height-1 || j == width-1 ||
                    (j == k) || (width-j-1 == k)) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println("");
        }
    }

    private static void graphСhess() {
        int height, width;
        System.out.println("****** Print chess ******");
        System.out.print("Please enter height: ");
        height = scanIntInput();

        System.out.print("Please enter width: ");
        width = scanIntInput();

        boolean print;
        for (int i = 0; i < height; i++) {
            print = i % 2 == 0;
            for (int j = 0; j < width; j++) {
                System.out.print(print ? "*" : " ");
                print = !print;
            }
            System.out.println("");
        }
    }

    private static void graph() {
        graphRectangle();
        graphEnvelope();
        graphСhess();
    }

    private static void checkEven() {
        int number;
        System.out.println("****** Check even ******");
        System.out.print("Please enter number: ");
        number = scanIntInput();

        System.out.println("Number is " + ((number % 2 == 0) ? "even" : "not even"));
    }

    private static boolean isPrime(int value) {
        boolean res = true;
        for (int i = 3; i <= Math.sqrt((double) value); i++) {
            res = value % i != 0;
        }

        return res;
    }

    private static void checkPrime() {
        int number;
        System.out.println("****** Check prime ******");
        System.out.print("Please enter number: ");
        number = scanIntInput();

        boolean res = isPrime(number);
        System.out.print("Number " + number + " is " + (res ? "prime" : "NOT prime"));
    }

    private static void checkMultiplicity() {
        int number;
        int counter = 0;
        System.out.println("****** Check multiplicity ******");
        System.out.print("Please enter number: ");
        number = scanIntInput();

        System.out.println("Multiplicity numbers for " + number);
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                System.out.println(++counter + ". " + i);
            }
        }
    }

    public static void main(String[] args) {
        average();
        averageCount();
        bank();
        graph();
        checkEven();
        checkPrime();
        checkMultiplicity();
    }
}
