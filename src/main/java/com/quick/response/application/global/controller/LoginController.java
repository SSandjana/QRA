package com.quick.response.application.global.controller;

import com.quick.response.application.global.dto.LoginDto;
import com.quick.response.application.global.entities.User;
import com.quick.response.application.global.services.LoginService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/login")
@AllArgsConstructor
public class LoginController {

    private LoginService loginService;

    @PostMapping("/auth")
    public ResponseEntity<User> register(@RequestBody LoginDto loginRequest) {
        User user = loginService.authenticate(loginRequest);
        if (user != null) {
            return new ResponseEntity<>(user, OK);
        }
        return new ResponseEntity<>(null, OK);
    }

}

