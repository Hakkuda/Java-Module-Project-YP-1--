
import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Блок 1. Принимаем от пользователя кол-во человек:
        int numberPeople = getNumberPeople(scanner);

        // Блок 2. Принимаем от пользователя каждый товар и его стоимость:
        ArrayList<Product> allProducts = getArrayOfProducts(scanner);

        // Блок 3. Вывод:
        System.out.println("Добавленные товары:");
        double sumCost = 0;
        for (Product product : allProducts) {
            System.out.printf("%s - %.2f %s.\n", product.name, product.cost, Formater.getWordRuble(product.cost));
            sumCost += product.cost;
        }

        double payFromEveryPerson = sumCost / numberPeople;
        String wordRuble = Formater.getWordRuble(payFromEveryPerson);
        System.out.printf("Каждый человек должен заплатить \"%.2f\" %s.", payFromEveryPerson, wordRuble);

    }

    public static int getNumberPeople(Scanner scanner) {
        System.out.println("На скольких человек необходимо разделить счёт:");
        while (true) {
            int numberPeople = Checker.checkInt(scanner);
            if (numberPeople == 1) {
                System.out.println("Количество человек, введённых пользователем, равно 1. Нечего делить. Попробуйте снова:");
            } else if (numberPeople < 1) {
                System.out.println("Некорректное значение для подсчёта. Попробуйте ещё раз:");
            } else
                return numberPeople;
        }
    }

    public static ArrayList<Product> getArrayOfProducts(Scanner scanner) {
        scanner.nextLine();
        ArrayList<Product> allProducts = new ArrayList<>();
        while (true) {
            System.out.println("Введите название товара:");
            String goodName = scanner.nextLine();
            if (goodName.trim().isEmpty()) {
                System.out.println("Название товара не должно быть пустым или содержать только пробелы.");
            } else {
                System.out.println("Введите стоимость товара:");
                double goodCost = Checker.checkCost(scanner);

                Product product = new Product(goodName.trim(), goodCost);
                allProducts.add(product);
                System.out.println("Товар успешно добавлен.");

                System.out.println("Хотите добавить ещё один товар?");
                scanner.nextLine();
                String isItEnd = scanner.nextLine();

                if (isItEnd.equalsIgnoreCase("завершить"))
                    break;
            }
        }
        return allProducts;
    }

}

