package com.example.springboot.assignment.supermarket.supermarket.repository;

import com.example.springboot.assignment.supermarket.supermarket.entity.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolesRepository extends JpaRepository<Roles, String> {

}
