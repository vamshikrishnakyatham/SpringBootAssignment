package com.example.springboot.assignment.supermarket.supermarket.service;

import com.example.springboot.assignment.supermarket.supermarket.entity.Items;
import com.example.springboot.assignment.supermarket.supermarket.entity.Users;

import java.util.List;

public interface UsersService {

    public void saveUser(Users theUser);

    public List<Items> getOrdersList(String username);

    public Users findByUsername(String username);

    public void updateUser(String username, String password, String email, String phoneNumber, String address);

    public void deleteUser(Users user);

}
