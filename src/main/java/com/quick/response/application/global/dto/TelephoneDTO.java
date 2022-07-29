package com.quick.response.application.global.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TelephoneDTO {

    String countryCode;
    String dialCode;
    String e164Number;
    String internationalNumber;
    String nationalNumber;
    String number;

}
