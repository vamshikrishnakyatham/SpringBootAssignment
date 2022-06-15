package com.example.springboot.assignment.supermarket.supermarket.repository;

import com.example.springboot.assignment.supermarket.supermarket.entity.Items;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface ItemsRepository extends JpaRepository<Items,Integer> {

}
