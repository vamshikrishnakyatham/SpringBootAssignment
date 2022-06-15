package com.example.springboot.assignment.todolist.service;

import com.example.springboot.assignment.todolist.entity.TodoItem;

import java.util.List;


public interface TodoService {
    public List<TodoItem> findAll();

    public TodoItem findById(int theId);
    public void save(TodoItem theTodoItem);
    public void deleteById(int theId);
}
