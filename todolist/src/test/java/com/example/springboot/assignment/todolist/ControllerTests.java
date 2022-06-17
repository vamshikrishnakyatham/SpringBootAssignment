package com.example.springboot.assignment.todolist;

import com.example.springboot.assignment.todolist.controller.TodoController;
import com.example.springboot.assignment.todolist.dao.TodoRepo;
import com.example.springboot.assignment.todolist.entity.TodoItem;
import com.example.springboot.assignment.todolist.service.TodoServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Matchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;

import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.contains;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@RunWith(SpringRunner.class)
@SpringBootTest
class ControllerTests {

    private MockMvc mockMvc;
    @Autowired
    private TodoServiceImpl todoService;

    @MockBean
    private TodoRepo todoRepo;

    TodoController basicController;

    @org.junit.jupiter.api.BeforeEach
    public void setup()
    {
        basicController = new TodoController(todoService);
        mockMvc= MockMvcBuilders.standaloneSetup(basicController).build();
    }

    @Test
    void contextLoads()
    {
        assertThat(basicController).isNotNull();
    }

//    @Test
//    void login() throws Exception {
//        mockMvc.perform(MockMvcRequestBuilders.get("/todolist/showMyLoginPage"))
//                .andExpect(status().isOk())
//                .andExpect(view().name("fancy-login"));
//    }
    @Test
    void shouldReturnIndexView() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/todolist/list"))
                .andExpect(status().isOk())
                .andExpect(view().name("todolist/list-items"));
    }
    @Test
    void shouldReturnTodosView() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/todolist/showFormForAdd"))
                .andExpect(status().isOk())
                .andExpect(view().name("todolist/todos"));
    }

    @Test
    void saveView() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/todolist/showFormForAdd"))
                .andExpect(status().isOk())
                .andExpect(view().name("todolist/todos"));
    }

}