package com.sda.money;

public class Wallet {

    private Money money = new Money();

    public void putMoney(Money other) {
        money.addMoney(other);
    }

    public void takeMoney(Money other) {
        money.substractMoney(other);
    }

    public String toString() {
        return String.format("Wallet with:\n%s", money);
    }

}
