package com.example.springboot.assignment.todolist.entity;
import lombok.Data;
@Data
public class TodoItemDto {
    private int id;
    private String title;
    private boolean done;

}
