package com.sda.money;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws NoEnoughMoneyException {
        Person frank = new Person("Frank");
        Person martin = new Person("Martin");
        Person jozef = new Person("Jozef");

        frank.receiveMoney(50d, Currency.PLN);
        frank.receiveMoney(100d, Currency.EUR);

        martin.receiveMoney(200d, Currency.PLN);
        jozef.receiveMoney(500d, Currency.EUR);

        System.out.println(frank);
        System.out.println(martin);
        System.out.println(jozef);

        frank.giveMoney(martin, 10d, Currency.PLN);
        martin.giveMoney(frank, 20d, Currency.PLN);
        jozef.giveMoney(frank, 100d, Currency.EUR);
        jozef.giveMoney(martin, 4000d, Currency.EUR);

        System.out.println("=============");
        System.out.println(frank);
        System.out.println(martin);
        System.out.println(jozef);

        frank.addItemToMyOwnList("bicycle");
        frank.addItemToMyOwnList("skuter");
        frank.addItemToMyOwnList("hulajnoga");

        Money moneyForBicyclePLN = new Money(500d, Currency.PLN);
        Money moneyForBicycleEUR = new Money(100d, Currency.EUR);
        Money moneyForBicycleUSD = new Money(110d, Currency.USD);

        List<Money> moneyForBicycle = new ArrayList<>();
        moneyForBicycle.add(moneyForBicyclePLN);
        moneyForBicycle.add(moneyForBicycleEUR);
        moneyForBicycle.add(moneyForBicycleUSD);

        frank.addItem(String.valueOf(new ItemOffer("bicycle", moneyForBicycle)));

        Money moneyBicycleEUR = new Money(100d, Currency.EUR);

        List<Money> moneyBicycle = new ArrayList<>();
        moneyBicycle.add(moneyBicycleEUR);

        martin.addItemToSell(new ItemOffer("bicycle", moneyBicycle));

        martin.buyItem(frank, "bicycle");

        System.out.println(martin);

    }

    //runtime exception używamy do wyjątku, którego się nie spodziewamy,
    // którego nigdy nie powinno być (jeżeli ktoś źle użyje naszego kodu)

}
