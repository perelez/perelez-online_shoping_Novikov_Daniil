public enum PaymentType {
    CASH("Наличные"), 
    CARD("Карта"), 
    CRYPTO("Криптовалюта");

    private final String description;
    PaymentType(String description) { this.description = description; }
    public String getDescription() { return description; }
}