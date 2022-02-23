package com.upper.entity;

public class Card {

    private int quantity;
    private Items cardItems;

    public Card(int quantity, Items cardItems) {
        this.quantity = quantity;
        this.cardItems = cardItems;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Items getCardItems() {
        return cardItems;
    }

    public void setCardItems(Items cardItems) {
        this.cardItems = cardItems;
    }
}
