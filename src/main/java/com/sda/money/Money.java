package com.sda.money;

import java.math.BigDecimal;

public class Money {

    private BigDecimal amount;
    private Currency currency;

    public Currency getCurrency() {
        return currency;
    }

    public Money(BigDecimal amount, Currency currency) {
        this.amount = amount;
        this.currency = currency;
        validateMoney();
    }

    public Money(Currency currency) {
        this(BigDecimal.ZERO, currency);
    }

    public Money(Double amount, Currency currency) {
        this(BigDecimal.valueOf(amount), currency);
    }

    public Money(Long amount, Currency currency) {
        this(BigDecimal.valueOf(amount), currency);
    }

    public void addMoney(BigDecimal amount) {//dodanie pieniędzy do kupki
        this.amount = this.amount.add(amount);
    }

    public void addMoney(Money moneyToAdd) {
        this.amount = this.amount.add(moneyToAdd.amount);
    }

    public boolean isEnoughAmount(Money money) {
        return this.amount.compareTo(money.amount)>=0;
    }

    public boolean isEnoughAmount(BigDecimal amount) {
        return this.amount.compareTo(amount)>=0;
    }

    public boolean substractMoney(BigDecimal amount) throws NoEnoughMoneyException {//dodanie pieniędzy do kupki
        if (isEnoughAmount(amount)) {
        this.amount = this.amount.add(amount.negate());
        return true;
    } else {
            System.out.println("Nie masz wystarczającej gotówki do wykonania transakcji");
            throw new NoEnoughMoneyException();
        }
    }

    public boolean substractMoney(Money moneyToRemove) throws NoEnoughMoneyException {
        if (isEnoughAmount(moneyToRemove)) {
            this.amount = this.amount.add(moneyToRemove.amount.negate());
            return true;
        } else {
            System.out.println("Nie masz wystarczającej gotówki do wykonania transakcji");
            throw new NoEnoughMoneyException();
        }
    }

    public boolean checkCurrency(Currency currency) {
        return currency.equals(this.currency);
    }

    public String toString() {
        return String.format("%s %s", amount.toString(), currency.toString());
    }

    private void validateMoney() {
        if (BigDecimal.ZERO.compareTo(this.amount) > 0) {
            throw new InwalidAmountException();
        }
    }

}
