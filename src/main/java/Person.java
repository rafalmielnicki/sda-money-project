public class Person {

    private String name;
    private String surname;
    private Wallet wallet;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Wallet getWallet() {
        return wallet;
    }

    public void setWallet(Wallet wallet) {
        this.wallet = wallet;
    }

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
        this.wallet = new Wallet();
    }

    public void payOut(Person targerPerson, Money moneyGiven) {
        this.wallet.removeMoney(moneyGiven);
        targerPerson.wallet.addMoney(moneyGiven);
    }

    /*public void takeOut(Person sourcePerson, Money moneyGiven) {
        sourcePerson.wallet.removeMoney(moneyGiven);
        this.wallet.addMoney(moneyGiven);
    }*/

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", wallet=" + wallet +
                '}';
    }
}

