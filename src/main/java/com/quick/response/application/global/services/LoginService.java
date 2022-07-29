package com.quick.response.application.global.services;

import com.quick.response.application.global.dto.LoginDto;
import com.quick.response.application.global.entities.User;


public interface LoginService {
    User authenticate(LoginDto loginRequest);
}
