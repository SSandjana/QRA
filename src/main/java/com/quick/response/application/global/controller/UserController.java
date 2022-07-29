package com.quick.response.application.global.controller;

import com.quick.response.application.global.dto.ChangePasswordDto;
import com.quick.response.application.global.dto.RegisterDto;
import com.quick.response.application.global.entities.User;
import com.quick.response.application.global.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {
    private UserService userService;

    @GetMapping("/all")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.findAllUsers();
        return new ResponseEntity<>(users, OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") Long id) {
        User user = userService.findUserById(id);
        return new ResponseEntity<>(user, OK);
    }

    @GetMapping("/finduser/{userName}")
    public ResponseEntity<User> getUserByName(@PathVariable("userName") String userName) {
        User user = userService.findUserByUsername(userName);
        return new ResponseEntity<>(user, OK);
    }

    @GetMapping("/findallusers/{firstName}")
    public ResponseEntity<List<User>> getAllUsersByFirstName(@PathVariable("firstName") String firstName) {
        List<User> userWithNameList = userService.findUserByFirstNameContaining(firstName);
        return new ResponseEntity<>(userWithNameList, OK);
    }

    @PutMapping("/update")
    public ResponseEntity<User> updateUser(@RequestBody User user) {
        User updatedUser = userService.updateUser(user);
        return new ResponseEntity<>(updatedUser, OK);
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterDto registerRequest) {
        User user = userService
                .registerUser(registerRequest);
        String getUsernameAfterRegistration = user
                .getUsername();
        User returnObject = new User();
        returnObject.setUsername(getUsernameAfterRegistration);
        returnObject.setId(user.getId());
        return new ResponseEntity<>(returnObject, CREATED);
    }

    @PostMapping("/user_password")
    public ResponseEntity<String> changePassword(@RequestBody ChangePasswordDto changePasswordDto) {
        String output = userService.changePassword(changePasswordDto);
        return new ResponseEntity<>(output, OK);
    }
}
