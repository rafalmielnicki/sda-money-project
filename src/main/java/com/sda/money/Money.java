package com.sda.money;

import java.math.BigDecimal;

public class Money {

    private BigDecimal amount;
    private Currency currency = Currency.PLN;

    public Money() {
        this.amount = BigDecimal.ZERO;
    }

    public Money(BigDecimal amount) {
        this.amount = amount;
    }

    public Money(double amount) {
        this.amount = BigDecimal.valueOf(amount);
    }

    public Money(long amount) {
        this.amount = BigDecimal.valueOf(amount);
    }

    public void addMoney(Money other) {
        amount = amount.add(other.amount);
    }

    public void substractMoney(Money other) {
        amount = amount.subtract(other.amount);
    }

    public String toString() {
        return String.format("%s %s", amount.toString(), currency.toString());
    }

}
