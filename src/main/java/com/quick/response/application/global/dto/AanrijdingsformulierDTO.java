package com.quick.response.application.global.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AanrijdingsformulierDTO {
    private String name;
    private String idNumber;
    private String username;
    private String naam;
    private Long userId;
    private String afgehandeld;
}
