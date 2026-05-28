public class Electro extends abProduct {
    private String brand;
    private String model;

    public Electro(String title, double price, String category, String brand, String model) {
        super(title, price, category);
        this.brand = brand;
        this.model = model;
    }

    @Override
    public String getProductType() {
        return "Электроника";
    }

    @Override
    public String toString() {
        return super.toString() + " (" + brand + " " + model + ")";
    }
}