
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

        System.out.println("HashCode ноутбука: " + laptop.hashCode());
        System.out.println("HashCode смартфона: " + phone.hashCode());

        abProduct testProduct = new Product("Test", 100.0);
        System.out.println("HashCode: " + testProduct.hashCode());

        laptop.addItem(mouse);

        System.out.println("Цена ноутбука: " + laptop.getFinalPrice());

        Client c = new Client("hakan", 120000);

        System.out.println(c.getFinancialStatus());

        c.payForProduct(laptop);

        System.out.println("Оплачен? " + laptop.isPaid());
        System.out.println("денег сейчас: " + c.getBalance());

    }
}