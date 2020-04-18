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

    private boolean isCurrencyInWallet(BigDecimal other, Currency currency, String addOrSubstract)
            throws NoEnoughMoneyException {
        boolean isCurrencyInWallet = false;
        for (int i = 0; i < monies.size(); i++) {
            if (monies.get(i).checkCurrency(currency)) {
                if (addOrSubstract.equals("add")) {
                    monies.get(i).addMoney(other);
                } else if (addOrSubstract.equals("substract")) {
                    monies.get(i).substractMoney(other);
                }
                isCurrencyInWallet = true;
            }
        }
        return isCurrencyInWallet;
    }

    public void putMoney(BigDecimal other, Currency currency)
            throws NoEnoughMoneyException {//włóż pieniądze do portfela
        boolean isCurrencyInWallet = isCurrencyInWallet(other, currency, "add");
        if (!isCurrencyInWallet) {
            this.monies.add(new Money(other, currency));
        }
    }

    public void takeMoney(BigDecimal other, Currency currency)
            throws NoEnoughMoneyException {//wyciągnij pieniądze z portfela
        boolean isCurrencyInWallet = isCurrencyInWallet(other, currency, "substract");
            if (!isCurrencyInWallet) {
                System.out.println("Nie ma dostępnej takiej waluty w źródłowym portfelu");
                throw new InputMismatchException();
            }
    }

    public String toString() {
        return String.format("Wallet with:\n%s", monies);
    }

}
