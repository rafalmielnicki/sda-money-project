package com.sda.money;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws NoEnoughMoneyException {
        Person frank = new Person("Frank");
        Person martin = new Person("Martin");
        Person jozef = new Person("Jozef");

        frank.receiveMoney(new Money(10, Currency.PLN));
        frank.receiveMoney(new Money(100, Currency.EUR));

        martin.receiveMoney(new Money(200, Currency.PLN));
        jozef.receiveMoney(new Money(500, Currency.EUR));

        System.out.println(frank);
        System.out.println(martin);
        System.out.println(jozef);

        frank.giveMoney(martin, new Money(10, Currency.PLN));
        martin.giveMoney(frank, new Money(20, Currency.PLN));
        jozef.giveMoney(frank, new Money(100, Currency.EUR));
        jozef.giveMoney(martin, new Money(4000, Currency.EUR));

        System.out.println("=============");
        System.out.println(frank);
        System.out.println(martin);
        System.out.println(jozef);

        martin.addItemToMyOwnList("bicycle");
        martin.addItemToMyOwnList("skuter");
        martin.addItemToMyOwnList("hulajnoga");

        Money moneyForBicyclePLN = new Money(500d, Currency.PLN);
        Money moneyForBicycleEUR = new Money(100d, Currency.EUR);
        Money moneyForBicycleUSD = new Money(110d, Currency.USD);

        List<Money> moneyForBicycle = new ArrayList<>();
        moneyForBicycle.add(moneyForBicyclePLN);
        moneyForBicycle.add(moneyForBicycleEUR);
        moneyForBicycle.add(moneyForBicycleUSD);

        frank.addItemToWishList(new ItemOffer("bicycle", moneyForBicycle));

        Money moneyBicycleEUR = new Money(100d, Currency.EUR);

        List<Money> moneyBicycle = new ArrayList<>();
        moneyBicycle.add(moneyBicycleEUR);

        martin.addItemToSell(new ItemOffer("bicycle", moneyBicycle));


        frank.buyItem(martin, "bicycle");

        System.out.println(martin);

    }

    //runtime exception używamy do wyjątku, którego się nie spodziewamy,
    // którego nigdy nie powinno być (jeżeli ktoś źle użyje naszego kodu)

}
