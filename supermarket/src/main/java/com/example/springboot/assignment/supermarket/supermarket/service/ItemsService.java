package com.example.springboot.assignment.supermarket.supermarket.service;

import com.example.springboot.assignment.supermarket.supermarket.entity.Items;

import java.util.List;

public interface ItemsService {

    public void saveItem(Items items);

    public List<Items> getAllItemsList();

    public Items getItemById(int id);

    public void deleteItemById(int itemId);

}
