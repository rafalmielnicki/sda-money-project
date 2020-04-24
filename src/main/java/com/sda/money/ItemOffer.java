package com.sda.money;

import java.util.List;

public class ItemOffer {
    private String itemName;
    private List<Money> moneyList;

    public ItemOffer(String itemName, List<Money> moneyList) {
        this.itemName = itemName;
        this.moneyList = moneyList;
    }

    public String getItemName() {
        return itemName;
    }

    public void setName(String itemName) {
        this.itemName = itemName;
    }

    public List<Money> getMoneyList() {
        return moneyList;
    }

    public void setMoneyList(List<Money> moneyList) {
        this.moneyList = moneyList;
    }

    //porównanie ofert
    public static Money isOfferIsAcceptable(ItemOffer offerBuy, ItemOffer offerSell) {
        return offerBuy.getMoneyList().stream()
                .filter(money -> enoughMoneyForItem(offerSell, money))
                .findFirst()
                .orElse(null);
    }

    private static boolean enoughMoneyForItem(ItemOffer offerSell, Money money) {
        for (int i = 0; i < offerSell.getMoneyList().size(); i++) {
            Money tempMoney = offerSell.getMoneyList().get(i);
            if(tempMoney.checkCurrency(money) && money.isEnoughAmount((tempMoney))) return true;
        }
        return false;
    }

}
