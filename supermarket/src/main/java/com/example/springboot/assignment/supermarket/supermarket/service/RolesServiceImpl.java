package com.example.springboot.assignment.supermarket.supermarket.service;

import com.example.springboot.assignment.supermarket.supermarket.entity.Roles;
import com.example.springboot.assignment.supermarket.supermarket.repository.RolesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RolesServiceImpl implements RolesService{

    @Autowired
    RolesRepository rolesRepository;

    @Override
    public Roles getRolesById(String id) {
        return rolesRepository.getById(id);
    }

    @Override
    public void saveRole(Roles role) {
        rolesRepository.save(role);
    }
}
