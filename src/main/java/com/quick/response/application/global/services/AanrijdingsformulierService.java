package com.quick.response.application.global.services;

import com.quick.response.application.global.dto.AanrijdingsformulierDTO;
import com.quick.response.application.global.dto.ChangePasswordDto;
import com.quick.response.application.global.entities.Aanrijdingsformulieren;

import java.util.List;

public interface AanrijdingsformulierService {

    Aanrijdingsformulieren findAanrijdingsformulierenByNaam(String naam);

    List<Aanrijdingsformulieren> findAll();

    Aanrijdingsformulieren registreerAanrijdingsformulier(AanrijdingsformulierDTO formulier);

    boolean changeStatus(String naam);

    void change(String status, String naam);

    List<Aanrijdingsformulieren> findAllByUserId(Long userId);
}
