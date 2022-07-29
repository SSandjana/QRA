package com.quick.response.application.global.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterDto {

    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private String email;
    private String idNumber;
    private TelephoneDTO telephone;
    private Date dob;
    private Long roleId;

}
