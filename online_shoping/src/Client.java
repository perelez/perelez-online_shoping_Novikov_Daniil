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
        double sum = product.getFinalPrice();

        if (checkBalance(sum)) {
            balance -= sum;
            product.pay(sum);
            System.out.println(name + " оплатил товар " + product.getTitle());
        } else {
            System.out.println(name + " не может оплатить товар " + product.getTitle());
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
        return "Клиент: " + name + ", Статус: " + status.getLabel() + ", Баланс: " + balance;
    }

}