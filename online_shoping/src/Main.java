import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("   Создание товаров   ");
        abProduct mouse = new Product("mouse", 1500.0);
        abProduct pad = new Product("pad", 500.0);
        System.out.println(mouse);
        System.out.println("id генерируется: " + mouse.getId());

        System.out.println("  работа с электроникой  ");
        Electro laptop = new Electro("thinkpad", 100000.0, "Laptops", "lenovo", "amd");
        abProduct phone = new Electro("samsung 15", 90000.0, "Smartphones", "samsumg", "dragon");
        System.out.println("1 товара: " + laptop.getProductType());
        System.out.println("2 товара: " + phone.getProductType());

        System.out.println("   добавление аксессуаров в товар  ");
        System.out.println("Базовая цена ноутбука: " + laptop.getPrice());
        laptop.addItem(mouse);
        laptop.addItem(pad);
        System.out.println("цена ноутбука с аксессуарами: " + laptop.getFinalPrice());

        System.out.println("сравнение объектов");
        abProduct mouseDuplicate = new Product("Logitech Mouse", 1500.0);
        System.out.println("Мышь 1 и Мышь 2 равны по ID? " + mouse.equals(mouseDuplicate));

        if (laptop instanceof Electro) {
            System.out.println("laptop = Электроникой");
        }

        System.out.println(" каталог и счетчики  ");
        Category electroCat = new Category("Electronics");
        electroCat.addSubcategory("Laptops");
        electroCat.addSubcategory("Phones");
        Category foodCat = new Category("Food");

        catalog storeCatalog = new catalog();
        storeCatalog.addCategory(electroCat);
        storeCatalog.addCategory(foodCat);
        storeCatalog.showCatalog();

        System.out.println("проверка:");
        System.out.println("категорий создано: " + Category.getCategoryCount());
        System.out.println("подкатегорий создано: " + Category.getSubcategoryCount());

        System.out.println("Справочник категорий");
        abProduct.getStaticCategories().forEach((id, name) -> {
            System.out.println("Код категории: " + id + ", Название: " + name);
        });

        //НОВЫЙ ПОЛЬЗОВАТЕЛЬСКИЙ ИНТЕРФЕЙС И ЛЯМБДЫ
        
        Scanner scanner = new Scanner(System.in);
        // Создаем клиента с конкретным статусом из Enum
        Client c = new Client("hakan", 120000, ClientStatus.VIP);
        
        // Список товаров для работы в меню
        List<abProduct> storeItems = new ArrayList<>();
        storeItems.add(laptop);
        storeItems.add(phone);
        storeItems.add(mouse);

        // Реализация функционального интерфейса через лямбда 
        OrderProcessor discountInfo = (product) -> {
            double rate = c.getStatus().getDiscountRate();
            double finalSum = product.getFinalPrice() * (1 - rate);
            System.out.println(">> Проверка для " + c.getName() + " (Статус: " + c.getStatus().getLabel() + ")");
            System.out.println(">> Персональная скидка " + (rate * 100) + "% применена.");
            System.out.println(">> Цена к оплате: " + finalSum);
        };

        boolean exit = false;
        while (!exit) {
            System.out.println("\n========= МЕНЮ МАГАЗИНА =========");
            System.out.println("1. Просмотр товаров");
            System.out.println("2. Проверить скидку на товар");
            System.out.println("3. Оплатить товар");
            System.out.println("4. Проверить баланс и статус");
            System.out.println("0. Выход");
            System.out.print("Выберите действие: ");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("\n--- Только Электроника ---");
                    storeItems.stream()
                            .filter(p -> p instanceof Electro)
                            .forEach(p -> System.out.println("- " + p.getTitle() + " [" + p.getPrice() + " руб.]"));
                    break;

                case 2:
                    System.out.println("\nВыберите номер товара (0-" + (storeItems.size()-1) + "):");
                    int idxInfo = scanner.nextInt();
                    discountInfo.process(storeItems.get(idxInfo)); // Вызов лямбды
                    break;

                case 3:
                    System.out.println("\nЧто покупаем? (0-" + (storeItems.size()-1) + "):");
                    int idxBuy = scanner.nextInt();
                    abProduct selected = storeItems.get(idxBuy);

                    System.out.println("Выберите способ оплаты (1. " + PaymentType.CARD + " 2. " + PaymentType.CASH + "):");
                    int payChoice = scanner.nextInt();
                    PaymentType method = (payChoice == 1) ? PaymentType.CARD : PaymentType.CASH;

                    System.out.println("Используем метод: " + method.getDescription());
                    c.payForProduct(selected);

                    if (selected.isPaid()) {
                        selected.setOrderStatus(OrderStatus.PAID); // Используем Enum статуса
                        System.out.println("Статус заказа изменен на: " + selected.getOrderStatus().getLabel());
                    }
                    break;

                case 4:
                    System.out.println("\n" + c.getFinancialStatus());
                    break;

                case 0:
                    exit = true;
                    break;
                default:
                    System.out.println("Ошибка ввода!");
            }
        }
        System.out.println("Программа завершена.");
    }
}
