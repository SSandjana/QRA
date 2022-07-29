package com.quick.response.application.client.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VoertuigDto {
    private String merk;
    private Long voertuigType;
    private Long userId;
    private Long bouwJaar;
    private String kentekenNummer;
}
