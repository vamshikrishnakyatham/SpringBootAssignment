package com.example.springboot.assignment.todolist.dao;
import com.example.springboot.assignment.todolist.entity.TodoItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepo extends JpaRepository<TodoItem,Integer> {


}
