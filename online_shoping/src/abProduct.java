import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public abstract class abProduct implements Payable {

    private final Long id;
    private String title;
    private double price;
    private String category;
    private boolean paid;

    private static Long counter = 1L;
    private static Map<Integer, String> staticCategories = new HashMap<>();
    private OrderStatus orderStatus = OrderStatus.NEW;

    public void setOrderStatus(OrderStatus status) { this.orderStatus = status; }
    public OrderStatus getOrderStatus() { return orderStatus; }


    static {
        staticCategories.put(1, "Бытовая техника");
        staticCategories.put(2, "Смартфоны");
        staticCategories.put(3, "Ноутбуки");
        staticCategories.put(4, "Телевизоры");
    }

    public abProduct(String title, double price, String category) {
        this.id = generateId();
        this.title = title;
        this.price = price;
        this.category = category;
        this.paid = false;
    }

    private Long generateId() {
        return counter++;
    }

    private double calculatePrice() {
        return price;
    }

    public abstract String getProductType();

    public Long getId() { return id; }
    public String getTitle() { return title; }
    public double getPrice() { return price; }
    public static Map<Integer, String> getStaticCategories() {
        return staticCategories;
    }


    @Override
    public double getFinalPrice() {
        return calculatePrice();
    }

    @Override
    public void pay(double amount) {
        if (amount >= getFinalPrice()) {
            paid = true;
        }
    }


    @Override
    public String toString() {
        return "id=" + id + ", title=" + title + ", price=" + price + ", paid=" + paid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof abProduct)) return false;
        abProduct p = (abProduct) o;
        return Objects.equals(id, p.id);
    }
    @Override
    public boolean isPaid() {
        return paid;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}