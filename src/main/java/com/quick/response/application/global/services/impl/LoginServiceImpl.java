package com.quick.response.application.global.services.impl;

import com.quick.response.application.global.dto.LoginDto;
import com.quick.response.application.global.entities.User;
import com.quick.response.application.global.repositories.UserRepository;
import com.quick.response.application.global.services.LoginService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;

@AllArgsConstructor(onConstructor = @__({@Autowired}))
public final class LoginServiceImpl implements LoginService {
    private final UserRepository userRepository;

/*    @Autowired
    public LoginServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }*/

    @Override
    public User authenticate(LoginDto loginRequest) {
        User user = userRepository.findUserByUsername(loginRequest.getUsername());
        if (user != null) {
            Boolean isAuthenticated = BCrypt.checkpw(loginRequest.getPassword(), user.getPassword());
            if (isAuthenticated) {
                return user;
            }
            return null;
        }
        return null;
    }
}
