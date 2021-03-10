package com.madura.Crud.Application.controller;


import com.madura.Crud.Application.common.CommonFunction;
import com.madura.Crud.Application.entities.Item;
import com.madura.Crud.Application.entities.ItemCollection;
import com.madura.Crud.Application.servicies.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ItemController {

    @Autowired
    ItemService service;

    @RequestMapping("/items")
    public String showItems(ModelMap modelMap) {
        List<Item> itemList = service.getAllItems();
        modelMap.addAttribute("ItemCollection", new CommonFunction().returnItemList(itemList));
        return "showitems";
    }

    @RequestMapping("/save")
    public String insertItem(@RequestBody Item item, ModelMap modelMap) {
        service.saveItem(item);
        List<Item> itemList = service.getAllItems();
        modelMap.addAttribute("ItemCollection", new CommonFunction().returnItemList(itemList));
        return "redirect:/items";
    }

    @RequestMapping("/sell")
    public String sellItem(@RequestBody ItemCollection collection) {
        Item item = service.searchItemById(collection.getId()).get();
        service.updateItemQuantity(new CommonFunction().sellItemQuantity(item.getItemQuantity(), collection.getSellItemQuantity()), collection.getId());
        return "redirect:/items";
    }

    @RequestMapping("/delete")
    public String deleteItem(@RequestBody ItemCollection collection) {
        service.deleteItem(collection.getId());
        return "redirect:/items";
    }

    @RequestMapping("/update")
    public String updateItem(@RequestBody Item collection) {
        System.out.println(" To String :" + collection.toString());
        service.updateItem(collection);
        return "redirect:/items";
    }

    @PostMapping("/loadSingleItem")
    @ResponseBody
    public Item loadOneItem(@RequestBody Item item) {
        Item ItemCollection = service.searchItemById(item.getId()).get();
        return ItemCollection;
    }
}
