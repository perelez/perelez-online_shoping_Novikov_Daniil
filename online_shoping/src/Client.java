public class Client implements Financeable {
    private String name;
    private double balance;
    private ClientStatus status;

    public Client(String name, double balance, ClientStatus status) {
        this.name = name;
        this.balance = balance;
        this.status = status;
    }

    public void payForProduct(abProduct product) {
        // Вычисляем цену с учетом персональной скидки клиента
        double rawPrice = product.getFinalPrice();
        double discount = rawPrice * status.getDiscountRate();
        double finalPriceWithDiscount = rawPrice - discount;

        System.out.println("\n[Запрос оплаты] " + name + " (Скидка " + (status.getDiscountRate()*100) + "%) хочет купить " + product.getTitle());
        System.out.println("Цена без скидки: " + rawPrice + " руб. К оплате: " + finalPriceWithDiscount + " руб.");

        if (checkBalance(finalPriceWithDiscount)) {
            balance -= finalPriceWithDiscount;
            product.pay(rawPrice); // Передаем базовую стоимость для закрытия чека продукта
            System.out.println("==> УСПЕХ: " + name + " оплатил товар. Остаток баланса: " + balance + " руб.");
        } else {
            System.out.println("==> ОТКАЗ: У " + name + " недостаточно средств! Необходимо еще " + (finalPriceWithDiscount - balance) + " руб.");
        }
    }

    public String getName() { return name; }
    public double getBalance() { return balance; }
    public ClientStatus getStatus() { return status; }

    @Override
    public boolean checkBalance(double amount) {
        return balance >= amount;
    }

    @Override
    public String getFinancialStatus() {
        return "Клиент: " + name + ", Статус: " + status.getLabel() + ", Баланс: " + balance + " руб.";
    }
}
