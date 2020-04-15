package com.sda.money;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

public class Wallet {

    private List<Money> monies;

    public Wallet() {
        this.monies = new ArrayList<>();
    }

    public void putMoney(BigDecimal other, Currency currency) {//włóż pieniądze do portfela
        boolean isCurrencyInWallet = false;
        for (int i = 0; i < monies.size(); i++) {
            if (monies.get(i).checkCurrency(currency)) {
                monies.get(i).addMoney(other);
                isCurrencyInWallet = true;
            }
        }
        if (!isCurrencyInWallet) {
            this.monies.add(new Money(other, currency));
        }
    }

    public void takeMoney(BigDecimal other, Currency currency) throws NoEnoughMoneyException {//wyciągnij pieniądze z portfela
        boolean isCurrencyInWallet = false;
        for (int i = 0; i < monies.size(); i++) {
            if (monies.get(i).checkCurrency(currency)) {
                monies.get(i).substractMoney(other);
                isCurrencyInWallet = true;
            }
        }
            if (!isCurrencyInWallet) {
                System.out.println("Nie ma dostępnej takiej waluty w źródłowym portfelu");
                throw new InputMismatchException();
            }
    }

    public String toString() {
        return String.format("Wallet with:\n%s", monies);
    }

}
