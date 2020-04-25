package com.sda.money;

import java.util.*;

public class Wallet {

    private Map<Currency, Money> monies = new HashMap<>();

    /*private boolean isCurrencyInWallet(BigDecimal other, Currency currency, String addOrSubstract)
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
    }*/

    public void putMoney(Money other) {
        getMoneyInCurrency(other.getCurrency()).addMoney(other);

    }

    public void takeMoney(Money other)
            throws NoEnoughMoneyException {//wyciągnij pieniądze z portfela
        getMoneyInCurrency(other.getCurrency()).substractMoney(other);
    }

    private Money getMoneyInCurrency(Currency currency) {
        if (!monies.containsKey(currency)) {
            monies.put(currency, new Money(currency));
        }
        return monies.get(currency);
    }

    public String toString() {
        return String.format("Wallet with:\n%s", monies);
    }

}
