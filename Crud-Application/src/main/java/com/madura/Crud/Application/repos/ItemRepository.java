package com.madura.Crud.Application.repos;

import com.madura.Crud.Application.entities.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface ItemRepository extends JpaRepository<Item, Integer> {

    @Modifying
    @Query(value = "UPDATE crud_test_grocery.grocery_items SET item_quantity=?1 where id=?2", nativeQuery = true)
    void updateItemQuantity(int quantity, int id);

    @Modifying
    @Query(value = "UPDATE crud_test_grocery.grocery_items SET item_name=?1,item_quantity=?2,single_item_price=?3 where id=?4", nativeQuery = true)
    void updateItem(String itemName, int quantity, float itemPrice, int id);
}
