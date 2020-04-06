import java.math.BigDecimal;

public class Main {

    public static void main(String[] args) {

        Person person1 = new Person("Jan", "Kowalski");
        Person person2 = new Person("Michał", "Anioł");

        Money money1 = new Money();
        money1.setAmount(BigDecimal.valueOf(500));
        Wallet wallet1 = new Wallet();

        System.out.println(person1);

        person1.payOut(person2, money1);

        System.out.println(person2);


    }
}
