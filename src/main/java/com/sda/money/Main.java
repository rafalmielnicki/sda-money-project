package com.sda.money;

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
        jozef.giveMoney(martin, 400d, Currency.EUR);

        System.out.println("=============");
        System.out.println(frank);
        System.out.println(martin);
        System.out.println(jozef);

    }

}
