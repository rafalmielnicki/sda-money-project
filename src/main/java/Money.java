import java.math.BigDecimal;

public class Money {

    private BigDecimal amount;
    Currency currency;

    public BigDecimal getAmount() {
        return amount;
    }

    public Money() {
        this.amount = BigDecimal.ZERO;
        this.currency = Currency.PLN;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public void addMoney(Money moneyToAdd) {
        this.amount = this.amount.add(moneyToAdd.amount);
    }

    public void removeMoney(Money moneyToRemove) {
        this.amount = this.amount.add(moneyToRemove.amount.negate());
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }
}
