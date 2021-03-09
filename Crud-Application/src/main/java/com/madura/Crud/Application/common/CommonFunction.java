package com.madura.Crud.Application.common;

import com.madura.Crud.Application.entities.Item;
import com.madura.Crud.Application.entities.ItemCollection;

import java.util.ArrayList;
import java.util.List;

public class CommonFunction {

    public List returnItemList(List<Item> itemList) {
        List<ItemCollection> itemCollectionList = new ArrayList<>();

        for (int i = 0; i < itemList.size(); i++) {

            Item collection = itemList.get(i);
//            ItemCollection itemCollection =
//                    new ItemCollection
//                            (collection.getId(), collection.getItemName(),
//                                    collection.getItemQuantity(), collection.getItemPrice(),
//                                    calculateAllItemsPrice(collection.getItemQuantity(),
//                                            collection.getItemPrice()));
            itemCollectionList.add(new ItemCollection
                    (collection.getId(), collection.getItemName(),
                            collection.getItemQuantity(), collection.getItemPrice(),
                            calculateAllItemsPrice(collection.getItemQuantity(),
                                    collection.getItemPrice())));
        }
        return itemCollectionList;
    }

    private float calculateAllItemsPrice(int availableItems, float itemPrice) {
        return availableItems * itemPrice;
    }

    public int sellItemQuantity(int all_itemsQuantity,int sell_itemsQuantity){
        return all_itemsQuantity-sell_itemsQuantity;
    }
}
