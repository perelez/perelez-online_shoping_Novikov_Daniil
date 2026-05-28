import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Category {
    private String name;
    private List<String> subcategories;
    private List<abProduct> items;

    private static int categoryCount = 0;
    private static int subcategoryCount = 0;

    public Category(String name) {
        this.name = name;
        this.subcategories = new ArrayList<>();
        this.items = new ArrayList<>();
        categoryCount++;
    }

    public void addSubcategory(String subcategory) {
        if (subcategory != null && !subcategory.isEmpty()) {
            subcategories.add(subcategory);
            subcategoryCount++;
        }
    }

    public void addItem(abProduct item) {
        if (item != null) {
            items.add(item);
        }
    }

    public double getFinalPrice() {
        double total = 0;
        for (abProduct item : items) {
            total += item.getFinalPrice();
        }
        return total;
    }

    public String getName() { return name; }
    public List<abProduct> getItems() { return items; }
    public List<String> getSubcategories() { return subcategories; }

    public static int getCategoryCount() { return categoryCount; }
    public static int getSubcategoryCount() { return subcategoryCount; }

    @Override
    public String toString() {
        return "Категория: '" + name + "' | Подкатегории: " + subcategories + " | Товаров: " + items.size() + " | Сумма: " + getFinalPrice() + " руб.";
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) return false;
        if (this == o) return true;
        if (!(o instanceof Category)) return false;
        Category category = (Category) o;
        return Objects.equals(name, category.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}

