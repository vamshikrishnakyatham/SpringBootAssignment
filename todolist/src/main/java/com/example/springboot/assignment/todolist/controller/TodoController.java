package com.example.springboot.assignment.todolist.controller;

import com.example.springboot.assignment.todolist.entity.TodoItem;
import com.example.springboot.assignment.todolist.service.TodoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/todolist")
public class TodoController {
    private TodoService todoService;
    public TodoController(TodoService theTodoService) {
        todoService = theTodoService;
    }
    @GetMapping("/showMyLoginPage")
    public String showMyLoginPage(){
        //return "plain-login";
        return "fancy-login";
    }

    // add mapping for "/list"

    @GetMapping("/list")
    public String listTodoItems(Model theModel) {

        // get employees from db
        List<TodoItem> theTodos = todoService.findAll();

        // add to the spring model
        theModel.addAttribute("todolist", theTodos);

        return "todolist/list-items";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel) {

        // create model attribute to bind form data
        TodoItem theTodoItem = new TodoItem();

        theModel.addAttribute("item", theTodoItem);

        return "todolist/todos";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("itemId") int theId, Model theModel){
        //get employee from the service
        TodoItem theTodoItem=todoService.findById(theId);

        //set employee as model attribute to prepopulate the form
        theModel.addAttribute("item",theTodoItem);

        //send to our from
        return "todolist/todos";
    }

    @GetMapping("/showFormForUpdateStatus")
    public String showFormForUpdateStatus(@RequestParam("itemId") int theId, Model theModel){
        //get employee from the service
        TodoItem theTodoItem=todoService.findById(theId);

        //set employee as model attribute to prepopulate the form
        theModel.addAttribute("item",theTodoItem);

        //send to our from
        return "status-page";
    }

    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("item") TodoItem theTodoitem) {

        // save the employee
        todoService.save(theTodoitem);

        // use a redirect to prevent duplicate submissions
        return "redirect:/todolist/list";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("itemId") int theId){
        //delete the employee
        todoService.deleteById(theId);

        //redirect to /employees/list
        return "redirect:/todolist/list";
    }

}
