public enum ClientStatus {
    NEWBIE("Новичок", 0.0), 
    REGULAR("Постоянный", 0.05), // 5% скидка
    VIP("VIP-клиент", 0.15);      // 15% скидка

    private final String label;
    private final double discountRate;

    ClientStatus(String label, double discountRate) {
        this.label = label;
        this.discountRate = discountRate;
    }

    public String getLabel() { return label; }
    public double getDiscountRate() { return discountRate; }
}
