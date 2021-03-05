package com.madura.Crud.Application.controller;

import com.madura.Crud.Application.servicies.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ItemController {

    @Autowired
    ItemService service;

    @RequestMapping("/items")
    public String showItems() {
        return "showitems";
    }
}
