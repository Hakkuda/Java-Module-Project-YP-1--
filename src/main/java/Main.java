
import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        // Блок 1. Принимаем от пользователя кол-во человек:
        int numberPeople = getNumberPeople();

        // Блок 2. Принимаем от пользователя каждый товар и его стоимость:
        ArrayList<Product> allProducts = getArrayOfProducts();

        // Блок 3. Вывод:
        System.out.println("Добавленные товары:");
        double sumCost = 0;
        for (Product product : allProducts) {
            System.out.println(String.format("%s - %.2f %s.", product.name, product.cost, Formater.getWordRuble(product.cost)));
            sumCost += product.cost;
        }

        double payFromEveryPerson = sumCost / numberPeople;
        String wordRuble = Formater.getWordRuble(payFromEveryPerson);
        System.out.println(String.format("Каждый человек должен заплатить \"%.2f\" %s.", payFromEveryPerson, wordRuble));

    }

    public static int getNumberPeople() {
        System.out.println("На скольких человек необходимо разделить счёт:");
        while (true) {
            Scanner scanner = new Scanner(System.in);
            int numberPeople = Checker.checkInt(scanner);
            if (numberPeople < 2) {
                if (numberPeople == 1)
                    System.out.println("Количество человек, введённых пользователем, равно 1. Нечего делить. Попробуйте снова:");
                else
                    System.out.println("Некорректное значение для подсчёта. Попробуйте ещё раз:");
            } else
                return numberPeople;
        }
    }

    public static ArrayList<Product> getArrayOfProducts() {
        ArrayList<Product> allProducts = new ArrayList<>();
        while (true) {
            System.out.println("Введите название товара:");
            Scanner scanner = new Scanner(System.in);
            String goodName = scanner.nextLine();
            System.out.println("Введите стоимость товара:");
            scanner = new Scanner(System.in);
            double goodCost = Checker.checkCost(scanner);

            Product product = new Product(goodName, goodCost);
            allProducts.add(product);

            System.out.println("Товар успешно добавлен.");
            System.out.println("Хотите добавить ещё один товар?");
            scanner = new Scanner(System.in);
            String isItEnd = scanner.nextLine();
            if (isItEnd.equalsIgnoreCase("завершить"))
                break;

        }
        return allProducts;
    }

}
class Product {
    String name = "без названия";
    double cost = 0.00f;
    Product(String name, double cost) {
        this.name = name;
        this.cost = cost;
    }
}

class Checker {
    public static int checkInt(Scanner scanner) {
        while (true) {
            if (scanner.hasNextInt()) {
                int number = scanner.nextInt();
                return number;
            } else {
                System.out.println("Введено нецелое число. Попробуйте ещё раз:");
                scanner = new Scanner(System.in);
            }
        }
    }

    public static double checkCost(Scanner scanner) {
        while (true) {
            if (scanner.hasNextDouble()) {
                double number = scanner.nextDouble();
                if (number < 0) {
                    System.out.println("Введено отрицательное число. Попробуйте ещё раз:");
                    scanner = new Scanner(System.in);
                } else {
                    return number;
                }
            } else {
                System.out.println("Введено некорректное значение. Попробуйте ещё раз:");
                scanner = new Scanner(System.in);
            }
        }
    }
}

class Formater {
    public static String getWordRuble(double number) {
        int num = (int) number;
        int remainderOf10 = num % 10;
        int remainderOf100 = num % 100;

        if (remainderOf100 == 11 || remainderOf100 == 12 || remainderOf100 == 13 || remainderOf100 == 14)
            return "рублей";
        if (remainderOf10 == 1)
            return "рубль";
        if (remainderOf10 == 2 || remainderOf10 == 3 || remainderOf10 == 4)
            return "рубля";
        else
            return "рублей";
        }
}
