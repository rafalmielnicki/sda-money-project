import java.math.BigDecimal;

public class Wallet {

    private Money money;

    public Money getMoney() {
        return money;
    }

    public void setMoney(Money money) {
        this.money = money;
    }

    public Wallet(Money money) {
        this.money = money;
    }

    public Wallet() {
        this.money = new Money();
    }

    public void addMoney(Money money) {
        this.money.addMoney(money);
    }

    public void removeMoney(Money money) {
        this.money.removeMoney(money);
    }

    @Override
    public String toString() {
        return "Wallet{" +
                "money=" + money.getAmount() +
                '}';
    }

}
