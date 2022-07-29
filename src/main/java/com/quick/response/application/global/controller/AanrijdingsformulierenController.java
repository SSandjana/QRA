package com.quick.response.application.global.controller;

import com.quick.response.application.global.dto.AanrijdingsformulierDTO;
import com.quick.response.application.global.dto.ChangePasswordDto;
import com.quick.response.application.global.entities.Aanrijdingsformulieren;
import com.quick.response.application.global.services.AanrijdingsformulierService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/aanrijdingsformulier")
@AllArgsConstructor
public class AanrijdingsformulierenController {

    private AanrijdingsformulierService aanrijdingsformulierService;

    @GetMapping("/find/by/naam")
    public ResponseEntity<Aanrijdingsformulieren> findAanrijdingsformulierenByNaam(@RequestParam("naam") String naam) {
        Aanrijdingsformulieren aanrijdingsformulieren = aanrijdingsformulierService.findAanrijdingsformulierenByNaam(naam);
        return new ResponseEntity<>(aanrijdingsformulieren, HttpStatus.OK);
    }

    @GetMapping("/find/all/formulieren")
    public ResponseEntity<List<Aanrijdingsformulieren>> findAll() {
        List<Aanrijdingsformulieren> aanrijdingsformulieren = aanrijdingsformulierService.findAll();
        return new ResponseEntity<>(aanrijdingsformulieren, HttpStatus.OK);
    }

    @PostMapping("/register")
    public ResponseEntity<?> registreerAanrijdingsformulier(@RequestBody AanrijdingsformulierDTO aanrijdingsformulierDTO) {
        Aanrijdingsformulieren formulier = aanrijdingsformulierService
                .registreerAanrijdingsformulier(aanrijdingsformulierDTO);
        return new ResponseEntity<>(formulier, CREATED);
    }

    @PostMapping("/change_status")
    public ResponseEntity<Boolean> changeStatus(@RequestBody String naam) {
        boolean result = aanrijdingsformulierService.changeStatus(naam);
        return new ResponseEntity<>(result, OK);
    }

    @PutMapping("/update")
    public ResponseEntity<String> update(@RequestBody String status, String naam){
        aanrijdingsformulierService.change(status, naam);
        return new ResponseEntity<>("Success", OK);
    }

}
