import java.util.Scanner;

public class Menu {
    public static String food;
    public static String foodList = "Добавленные товары:";
    public static double price;
    private double amount;

    public void toMenu() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите название товара.");
        while (true) {
            food = scan.nextLine();
            if (food.equalsIgnoreCase("завершить")) {
                break;
            } else {
                foodList = String.format("%s\n%s", foodList, food);
                System.out.println("Введите цену товара.");
            } while (true) {
                if (scan.hasNextDouble()) {
                    price = scan.nextDouble();
                    scan.nextLine();
                    if (price < 0) {
                        System.out.println("Введите число > 0.");
                    } else {
                        amount += price;
                        System.out.println("Товар " + food + " по цене " + price + " руб. успешно добавлен.");
                        System.out.format("Текущая сумма: %.2f руб.", amount);
                        System.out.println("\nВведите название товара или напишите \"завершить\" для вывода результата.");
                        break; }
                } else {
                    System.out.println("Введите число.");
                    scan.nextLine();
                }
            }
        }
        System.out.format(foodList + "\nОбщая сумма %.2f руб.", amount);
    }
    public double getAmount() {
        return amount;
    }
}