import java.util.Scanner;

public class Main {
    public static int friend;
    public static double amount;
    public static double bill;
    public static String rub;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Hа сколько человек необходимо разделить счёт?");
        while (true) {
            if (scan.hasNextInt()) {
                friend = scan.nextInt();
                if (friend == 1) {
                    System.out.println("Мог бы и дома поесть! Плати теперь сам за всё!\nКоличество гостей должно быть > 1.");
                } else if (friend < 1) {
                    System.out.println("Вот и правильно, дома то вкуснее!\nКоличество гостей должно быть > 1.");
                } else {
                    System.out.println("Ok, давай считать..");
                    break;
                }
            } else {
                System.out.println("Введите число.");
                scan.next();
            }
        }
        Menu scroll = new Menu();
        scroll.toMenu();
        amount = scroll.getAmount();
        bill = amount / friend;

        int z = ((int) bill) % 100;
        if (z >= 11 && z <= 14) {
            rub = String.format("%d", z);
            switch (rub) {
                case "11":
                case "12":
                case "13":
                case "14":
                    rub = "рублей";
                    break;
            }
        } else{
            z = ((int) bill) % 10;
            rub = String.format("%d", z);
            switch (rub) {
                case "0":
                case "5":
                case "6":
                case "7":
                case "8":
                case "9":
                    rub = "рублей";
                    break;
                case "1":
                    rub = "рубль";
                    break;
                case "2":
                case "3":
                case "4":
                    rub = "рубля";
                    break;
            }
        }
        System.out.format("\nИтого по %.2f " + rub + " на каждого из " + friend + " гостей.", bill);
    }
}
