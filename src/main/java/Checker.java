import java.util.Scanner;

public class Checker {
    public static int checkInt(Scanner scanner) {
        while (true) {
            if (scanner.hasNextInt()) {
                int number = scanner.nextInt();
                return number;
            } else {
                System.out.println("Введено нецелое число. Попробуйте ещё раз:");
                scanner.next();
            }
        }
    }

    public static double checkCost(Scanner scanner) {
        while (true) {
            if (scanner.hasNextDouble()) {
                double number = scanner.nextDouble();
                if (number < 0) {
                    System.out.println("Введено отрицательное число. Попробуйте ещё раз:");
                } else {
                    return number;
                }
            } else {
                System.out.println("Введено некорректное значение. Попробуйте ещё раз:");
                scanner.next();
            }
        }
    }
}
