import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<String> operations = new ArrayList<>();
        operations.add("Добавить товар.");
        operations.add("Показать все покупки.");
        operations.add("Удалить товар.");

        ArrayList<String> purchases = new ArrayList<>();

        while (true) {
            System.out.println("Выберите операцию: (введите 'end' для выхода из программы)");
            for (int i = 0; i < operations.size(); i++) {
                System.out.println((i + 1) + ". " + operations.get(i));
            }
            String line = scanner.nextLine();
            if (line.equals("end")) {
                break;
            }
            switch (line) {
                case ("1"): {
                    System.out.println("Какой товар хотите добавить?");
                    String addPurchase = scanner.nextLine();
                    purchases.add(addPurchase);
                    System.out.println(addPurchase + " - добавлен в Вашу корзину.");
                    System.out.println("Итого в спике покупок: " + purchases.size());
                }
                break;

                case ("2"): {
                    printListPurchases(purchases);
                }
                break;

                case ("3"): {
                    printListPurchases(purchases);
                    System.out.println("Какую покупку хотите удалить? Введите номер или название:");
                    String delPurchase = scanner.nextLine(); //Ввод номера или названия покупки
                    try {
                        int numDelPurchase = Integer.parseInt(delPurchase) - 1;  //преобразование введённого в число
                        if (numDelPurchase < 0 || numDelPurchase > operations.size()) {
                            System.out.println("Некорректный ввод!Вы вышли из списка подуктов, надо от 1 до " + operations.size());
                        }
                        purchases.remove(numDelPurchase);
                    } catch (NumberFormatException e) {
                        purchases.remove(delPurchase);
                    }
                    System.out.println("Позиция: " + (delPurchase) + " - Удалена из списка!");
                }
                break;
            }
        }
    }

    protected static void printListPurchases(ArrayList<String> purchases) {
        if (purchases.size() == 0) {
            System.out.println("Список покупок пуст!");
        } else {
            System.out.println("Список покупок:");
            for (int i = 0; i < purchases.size(); i++) {
                System.out.println((i + 1) + ". " + purchases.get(i));
            }
        }
    }
}
