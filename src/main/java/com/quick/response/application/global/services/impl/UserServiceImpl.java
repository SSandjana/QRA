package com.quick.response.application.global.services.impl;

import com.quick.response.application.global.dto.ChangePasswordDto;
import com.quick.response.application.global.dto.RegisterDto;
import com.quick.response.application.global.entities.User;
import com.quick.response.application.global.repositories.UserRepository;
import com.quick.response.application.global.services.RoleService;
import com.quick.response.application.global.services.UserService;
import com.quick.response.application.global.utilities.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

public final class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RoleService roleService;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, RoleService roleService) {
        this.userRepository = userRepository;
        this.roleService = roleService;
    }

    @Override
    public List<User> findAllUsers() {
        return userRepository.findAllByRoleTypeNot(Constants.ADMIN_TYPE);
    }

    @Override
    public User updateUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User findUserById(Long id) {
        return userRepository.findUserById(id);
    }

    @Override
    public List<User> findUserByFirstNameContaining(String firstName) {
        return userRepository.findUserByFirstNameContaining(firstName);
    }

    @Override
    public User findUserByUsername(String username) {

        return userRepository.findUserByUsername(username);
    }

    @Override
    public Boolean checkIfUserExists(String username) {
        boolean check = false;
        if (username != null && !username.isEmpty()) {
            User userObj = findUserByUsername(username);
            if (userObj != null) {
                check = true;
            }
        }
        return check;
    }

    @Override
    public User registerUser(RegisterDto registerRequest) {

        User newUser = new User();

        if (!checkIfUserExists(registerRequest.getUsername())) {

            newUser.setFirstName(registerRequest.getFirstName());
            newUser.setLastName(registerRequest.getLastName());
            newUser.setUsername(registerRequest.getUsername());
            newUser.setPassword(BCrypt.hashpw(registerRequest.getPassword(), BCrypt.gensalt()));
            newUser.setEmail(registerRequest.getEmail());
            newUser.setIdNumber(registerRequest.getIdNumber());
            newUser.setDob(registerRequest.getDob());
            newUser.setRegistrationDate(Date.valueOf(LocalDate.now()));
            newUser.setRole(roleService.getRoleById(registerRequest.getRoleId()));
            newUser.setTelephone(registerRequest.getTelephone().getInternationalNumber());

            userRepository.save(newUser);
        }

        return newUser;
    }

    @Override
    public String changePassword(ChangePasswordDto changePasswordDto) {
        User user = userRepository.findUserById(changePasswordDto.getId());
        if (BCrypt.checkpw(changePasswordDto.getPassword(), user.getPassword())) {
            user.setPassword(BCrypt.hashpw(changePasswordDto.getNewPassword(), BCrypt.gensalt()));
            userRepository.save(user);
            return "Password changed";
        } else {
            return "Current password doesn't match";
        }
    }
}
