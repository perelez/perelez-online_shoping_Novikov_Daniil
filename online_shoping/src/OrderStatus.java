public enum OrderStatus {
    NEW("Новый"), 
    PAID("Оплачен"), 
    SHIPPED("Отправлен"), 
    DELIVERED("Доставлен");

    private final String label;
    OrderStatus(String label) { this.label = label; }
    public String getLabel() { return label; }
}
