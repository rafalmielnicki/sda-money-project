package com.sda.money;

import java.util.ArrayList;
import java.util.List;
import static com.sda.money.ItemOffer.setOnPrice;

public class Person {//klasa Person ma być odpowiedzialna za interakcję między osobami

    private String name;
    private Wallet wallet;
    private List<String> myOwnItemList = new ArrayList<>();
    private List<ItemOffer> wishList = new ArrayList<>();
    private List<ItemOffer> itemsForSale = new ArrayList<>();

    public Person(String name) {
        this.name = name;
        this.wallet = new Wallet();
    }

    public void receiveMoney(Money money){
        wallet.putMoney(money);
    }

    public void giveMoney(Person other, Money money) {
        System.out.println(
                String.format("%s gives %s to %s", name, money, other.name));
        try {
            wallet.takeMoney(money);//wyciągamy pieniądze z portfela
            other.receiveMoney(money);//dajemy je wybranej osobie
        } catch (NoEnoughMoneyException e) {
            System.out.println(
                    String.format("%s couldn't give %s to %s", name, money, other.name));
        }
    }

    public String toString() {
        return "Person " + name + " has wallet:\n" + wallet.toString();
    }

    public void addItemToMyOwnList(String nameItem) {
        this.myOwnItemList.add(nameItem);
    }

    public void addItemToWishList(ItemOffer item) {
        this.wishList.add(item);
    }

    public void addItemToSell(ItemOffer item) {
        if (this.myOwnItemList.contains(item.getItemName())) {
            this.itemsForSale.add(item);
        }
    }

    public void addItem(String name) {
        this.myOwnItemList.add(name);
        this.itemsForSale.remove(new ItemOffer(name, null));
    }

    public void removeItem(String name) {
        this.myOwnItemList.remove(name);
        this.itemsForSale.remove(new ItemOffer(name, null));
    }

    private ItemOffer findPurchaseOffer(String item) {
        for (ItemOffer offer : wishList) {
            if (item.equals(offer.getItemName())) {
                return offer;
            }
        }
        return null;
    }

    private ItemOffer findSaleOffer(String item) {
        for (ItemOffer offer : itemsForSale) {
            if (item.equals(offer.getItemName())) {
                return offer;
            }
        }
        return null;
    }

    public boolean buyItem(Person other, String item) {
        if (item == null) return false;
        ItemOffer sellOffer = other.findSaleOffer(item);
        ItemOffer buyOffer = this.findPurchaseOffer(item);
        if ((setOnPrice(buyOffer, sellOffer)) != null) {
            this.removeItem(item);
            other.addItemToMyOwnList(item);
        }
        return true;
    }

}
