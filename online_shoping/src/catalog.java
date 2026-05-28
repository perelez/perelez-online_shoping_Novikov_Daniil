import java.util.ArrayList;
import java.util.List;

public class catalog {
    private List<Category> categories = new ArrayList<>();

    public void addCategory(Category category) {
        categories.add(category);
    }

    public void showCatalog() {
        System.out.println("========== КАТАЛОГ МAГАЗИНА ==========");
        for (Category cat : categories) {
            System.out.println(cat);
            for (abProduct item : cat.getItems()) {
                System.out.println("  -> " + item);
            }
        }
        System.out.println("======================================");
        System.out.println("Всего категорий: " + Category.getCategoryCount());
        System.out.println("Всего подкатегорий: " + Category.getSubcategoryCount());
        System.out.println("======================================\n");
    }
}
