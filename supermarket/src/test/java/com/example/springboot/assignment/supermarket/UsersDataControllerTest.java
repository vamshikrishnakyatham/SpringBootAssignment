package com.example.springboot.assignment.supermarket;
import com.example.springboot.assignment.supermarket.supermarket.controller.UsersDataController;
import com.example.springboot.assignment.supermarket.supermarket.converter.ItemsConverter;
import com.example.springboot.assignment.supermarket.supermarket.converter.UsersConverter;
import com.example.springboot.assignment.supermarket.supermarket.service.UsersService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


@RunWith(SpringRunner.class)
@SpringBootTest
class UsersDataControllerTest {

    UsersDataController usersDataController;

    @Autowired
    ItemsConverter itemsConverter;

    @Autowired
    UsersConverter usersConverter;

    @MockBean
    UsersService usersService;

    @BeforeEach
    void setup()
    {
        usersDataController = new UsersDataController();
    }

    @Test
    void contextLoads()
    {
        assertThat(usersDataController).isNotNull();
    }


}