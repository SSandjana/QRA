package com.quick.response.application.global.services.impl;

import com.quick.response.application.global.dto.AanrijdingsformulierDTO;
import com.quick.response.application.global.dto.ChangePasswordDto;
import com.quick.response.application.global.entities.Aanrijdingsformulieren;
import com.quick.response.application.global.entities.User;
import com.quick.response.application.global.repositories.AanrijdingsformulierRepository;
import com.quick.response.application.global.services.AanrijdingsformulierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class AanrijdingsformulierImpl implements AanrijdingsformulierService {

    private final AanrijdingsformulierRepository aanrijdingsformulierRepository;

    private final AanrijdingsformulierService aanrijdingsformulierService;

    @Autowired
    public AanrijdingsformulierImpl(AanrijdingsformulierRepository aanrijdingsformulierRepository,
                                    AanrijdingsformulierService aanrijdingsformulierService) {
        this.aanrijdingsformulierRepository = aanrijdingsformulierRepository;
        this.aanrijdingsformulierService = aanrijdingsformulierService;
    }

    @Override
    public Aanrijdingsformulieren findAanrijdingsformulierenByNaam(String naam) {
        return aanrijdingsformulierRepository.findAanrijdingsformulierenByNaamContaining(naam);
    }

    @Override
    public List<Aanrijdingsformulieren> findAll() {
        return aanrijdingsformulierRepository.findAll();
    }

    @Transactional
    @Override
    public Aanrijdingsformulieren registreerAanrijdingsformulier(AanrijdingsformulierDTO formulier) {
        Aanrijdingsformulieren invoegFormulier = Aanrijdingsformulieren.builder()
                .name(formulier.getName())
                .idNumber(formulier.getIdNumber())
                .username(formulier.getUsername())
                .naam(formulier.getNaam())
                .afgehandeld(formulier.getAfgehandeld())
                .user(User.builder().id(formulier.getUserId()).build())
                .build();
        return aanrijdingsformulierRepository.save(invoegFormulier);
    }

    @Override
    public boolean changeStatus(String naam) {
        Aanrijdingsformulieren formulier = aanrijdingsformulierRepository.findAanrijdingsformulierenByNaamContaining(naam);
        if (formulier != null){
            formulier.setAfgehandeld("accepted");
            aanrijdingsformulierRepository.save(formulier);
            return true;
        }
        return false;
    }

    @Override
    public void change(String status, String naam) {
        aanrijdingsformulierRepository.change(status, naam);
    }


}
