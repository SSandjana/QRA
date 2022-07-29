package com.quick.response.application.global.services;


import com.quick.response.application.global.dto.ChangePasswordDto;
import com.quick.response.application.global.dto.RegisterDto;
import com.quick.response.application.global.entities.User;

import java.util.List;

public interface UserService {
    List<User> findAllUsers();

    User updateUser(User user);

    User findUserById(Long id);

    List<User> findUserByFirstNameContaining(String firstName);

    User findUserByUsername(String username);

    Boolean checkIfUserExists(String username);

    User registerUser(RegisterDto registerRequest);

    String changePassword(ChangePasswordDto updateRequest);
}
