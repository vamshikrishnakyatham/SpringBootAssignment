package com.example.springboot.assignment.supermarket.supermarket.controller;

import com.example.springboot.assignment.supermarket.supermarket.converter.ItemsConverter;
import com.example.springboot.assignment.supermarket.supermarket.converter.UsersConverter;
import com.example.springboot.assignment.supermarket.supermarket.dto.ItemsDTO;
import com.example.springboot.assignment.supermarket.supermarket.dto.UsersDTO;
import com.example.springboot.assignment.supermarket.supermarket.entity.Users;
import com.example.springboot.assignment.supermarket.supermarket.service.ItemsService;
import com.example.springboot.assignment.supermarket.supermarket.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import javax.validation.Valid;
import java.security.Principal;

@Controller
@RequestMapping("/staff")
public class StaffDataController {

    @Autowired
    private UsersService usersServiceObject;

    private ItemsService itemsServiceObject;

    public StaffDataController(UsersService usersServiceObject) {
        this.usersServiceObject = usersServiceObject;
    }

    @Autowired
    public void setItemsServiceObject(ItemsService itemsServiceObject)
    {
        this.itemsServiceObject=itemsServiceObject;
    }

    private ItemsConverter itemsConverterObject;

    @Autowired
    public void setItemsConverterObject(ItemsConverter itemsConverterObject)
    {
        this.itemsConverterObject=itemsConverterObject;
    }

    @Autowired
    private UsersConverter usersConverterObject;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoderObject;

    static final String SUCCESS_HANDLER = "redirect:/successHandler";

    @GetMapping("/stockList")
    public String stockList(Model theModel)
    {
        theModel.addAttribute("allItems", itemsConverterObject.entityToDto(itemsServiceObject.getAllItemsList()));
        return "stock-list";
    }

    @PostMapping("/deleteItem")
    public ModelAndView deleteItem(@RequestParam int id)
    {
        itemsServiceObject.deleteItemById(id);
        return new ModelAndView("redirect:/staff/stockList");
    }

    @GetMapping("/updateStaffPage")
    public String updatePage(Model model,Principal loggedUser)
    {
        UsersDTO tempUser = usersConverterObject.entityToDto(usersServiceObject.findByUsername(loggedUser.getName()));
        model.addAttribute("user",tempUser);
        return "update-staff-page";
    }

    @PostMapping("/saveUser")
    public String saveUser(@Valid @ModelAttribute("user") UsersDTO user, BindingResult bindingResult, Model model,Principal loggedUser)
    {
        if(bindingResult.hasErrors())
        {
            model.addAttribute("error",bindingResult.getFieldError("id"));
            model.addAttribute("user",user);
            return "update-staff-page";
        }
        Users tempUser = usersConverterObject.dtoToEntity(user);
        String encodedPassword = bCryptPasswordEncoderObject.encode(tempUser.getPassword());
        usersServiceObject.updateUser(loggedUser.getName(),encodedPassword,tempUser.getEmail(),tempUser.getPhoneNumber(),tempUser.getAddress());
        return SUCCESS_HANDLER;
    }

    @GetMapping("/addItem")
    public String addNewItem()
    {
        return "item-form";
    }

    @PostMapping("/saveItem")
    public String saveNewItem(@ModelAttribute("item") ItemsDTO itemsDTO)
    {
        itemsServiceObject.saveItem(itemsConverterObject.dtoToEntity(itemsDTO));
        return SUCCESS_HANDLER;
        //return "duplicate-item";
    }

    @PostMapping("/updateItem")
    public String updateItem(@RequestParam("itemId") int itemId, Model model)
    {
        model.addAttribute("item",itemsConverterObject.entityToDto(itemsServiceObject.getItemById(itemId)));
        return "item-update";
    }
}
