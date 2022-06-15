package com.example.springboot.assignment.supermarket.supermarket.service;

import com.example.springboot.assignment.supermarket.supermarket.entity.Roles;

public interface RolesService {
    //read in CRUD
    public Roles getRolesById(String id);
    //create in CRUD
    public void saveRole(Roles role);
}
