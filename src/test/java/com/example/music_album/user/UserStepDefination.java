package com.example.music_album.user;

import com.example.music_album.entity.dto.UserDTO;
import com.example.music_album.service.UserService;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest
public class UserStepDefination {
    @Autowired
    private UserService userService;
    private String username;
    private String password;
    private String email;
    private String errorMessage;

    @Given("I provide a valid username {string}, valid password {string}, valid email {string}")
    public void i_provide_a_valid_username_valid_password_valid_email(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    @When("I submit the user")
    public void i_submit_the_user() {
        try{
            userService.postUser(new UserDTO(username,password,email));
        }catch (Exception e){
            this.errorMessage = e.getMessage();
        }
    }

    @Then("the user should be created successfully")
    public void the_user_should_be_created_successfully() {
        assertNull(errorMessage);
    }

    @Given("I provide a valid username {string}, invalid password {string}, valid email {string}")
    public void i_provide_a_valid_username_invalid_password_valid_email(String username, String password, String email) {
        try{
            userService.postUser(new UserDTO(username,password,email));
        }catch (Exception e){
            this.errorMessage = e.getMessage();
        }
    }
    @Then("the user should not be created successfully")
    public void the_user_should_not_be_created_successfully() {
        assertEquals("Could not commit JPA transaction", errorMessage);
    }

}
