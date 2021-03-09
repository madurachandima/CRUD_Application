package com.madura.Crud.Application.entities;

public class ItemCollection {
    private int id;
    private String itemName;
    private int itemQuantity;
    private float itemPrice;
    private float itemLotPrice;
    private int sellItemQuantity;


    public ItemCollection(int id, String itemName, int itemQuantity, float itemPrice, float itemLotPrice) {
        this.id = id;
        this.itemName = itemName;
        this.itemQuantity = itemQuantity;
        this.itemPrice = itemPrice;
        this.itemLotPrice = itemLotPrice;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getItemQuantity() {
        return itemQuantity;
    }

    public void setItemQuantity(int itemQuantity) {
        this.itemQuantity = itemQuantity;
    }

    public float getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(float itemPrice) {
        this.itemPrice = itemPrice;
    }

    public float getItemLotPrice() {
        return itemLotPrice;
    }

    public void setItemLotPrice(float itemLotPrice) {
        this.itemLotPrice = itemLotPrice;
    }

    public int getSellItemQuantity() {
        return sellItemQuantity;
    }

    public void setSellItemQuantity(int sellItemQuantity) {
        this.sellItemQuantity = sellItemQuantity;
    }

    @Override
    public String toString() {
        return "ItemCollection{" +
                "id=" + id +
                ", itemName='" + itemName + '\'' +
                ", itemQuantity=" + itemQuantity +
                ", itemPrice=" + itemPrice +
                ", itemLotPrice=" + itemLotPrice +
                ", sellItemQuantity=" + sellItemQuantity +
                '}';
    }
}
