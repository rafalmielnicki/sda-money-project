package com.sda.money;

import java.math.BigDecimal;

public class Person {

    private String name;
    private Wallet wallet;

    public Wallet getWallet() {
        return wallet;
    }

    public Person(String name) {
        this.name = name;
        this.wallet = new Wallet();
    }

    public void receiveMoney(Double money, Currency currency) {
        this.wallet.putMoney(BigDecimal.valueOf(money), currency);
    }

    public void giveMoney(Person other, Double money, Currency currency) throws NoEnoughMoneyException {
        System.out.println(
                String.format("%s gives %s%s to %s", name, money, currency.toString(), other.name));
        wallet.takeMoney(BigDecimal.valueOf(money), currency);//wyciągamy pieniądze z portfela
        other.receiveMoney(money, currency);//dajemy je wybranej osobie
    }

    public String toString() {
        return "Person " + name + " has wallet:\n" + wallet.toString();
    }

}
