package com.madura.Crud.Application.servicies;

import com.madura.Crud.Application.entities.Item;
import com.madura.Crud.Application.repos.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class ItemServiceImpl implements ItemService {

    @Autowired
    ItemRepository itemRepository;

    public ItemRepository getItemRepository() {
        return itemRepository;
    }

    public void setItemRepository(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    public void deleteItem(int id) {
        itemRepository.deleteById(id);
    }

    @Override
    public Item saveItem(Item item) {
        return itemRepository.save(item);
    }

    @Override
    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

    @Override
    public Optional<Item> searchItemById(int id) {
        return itemRepository.findById(id);
    }
}
