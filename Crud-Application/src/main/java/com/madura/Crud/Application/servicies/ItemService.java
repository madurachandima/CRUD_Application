package com.madura.Crud.Application.servicies;

import com.madura.Crud.Application.entities.Item;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface ItemService {

    void deleteItem(int id);

    Item saveItem(Item item);

    List<Item> getAllItems();

    Optional<Item> searchItemById(int id);

    //update Item;
    @Transactional
    void updateItemQuantity(int quantity , int  id);
}
