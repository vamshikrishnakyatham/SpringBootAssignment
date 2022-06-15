package com.example.springboot.assignment.supermarket.supermarket.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ItemsDTO {

    private int itemId;

    private String itemName;

    private int cost;

    private String company;

}
