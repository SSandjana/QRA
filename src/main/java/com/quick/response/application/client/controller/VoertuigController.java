package com.quick.response.application.client.controller;

import com.quick.response.application.client.dto.VoertuigDto;
import com.quick.response.application.client.entities.Voertuig;
import com.quick.response.application.client.entities.VoertuigType;
import com.quick.response.application.client.services.VoertuigService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/voertuig")
@AllArgsConstructor
public class VoertuigController {

    private VoertuigService voertuigService;

    @GetMapping("/find/all/by/userid/{userId}")
    public ResponseEntity<List<Voertuig>> getVoertuigenById(@PathVariable("userId") Long userId) {
        List<Voertuig> voertuigen = voertuigService.findAllByUserId(userId);
        return new ResponseEntity<>(voertuigen, HttpStatus.OK);
    }

    @GetMapping("/find/all/by/userid/kentekennummer")
    public ResponseEntity<List<Voertuig>> getVoertuigenById(@RequestParam("userId") Long userId,
                                                            @RequestParam("kentekenNummer") String kentekenNummer) {
        List<Voertuig> voertuigen = voertuigService.findAllByUserIdAndKentekenNummer(userId, kentekenNummer);
        return new ResponseEntity<>(voertuigen, HttpStatus.OK);
    }

    @GetMapping("/find/voertuig/by/kentekennummer")
    public ResponseEntity<Voertuig> getVoertuigById(@RequestParam("kentekenNummer") String kentekenNummer) {
        Voertuig voertuig = voertuigService.findByKentekenNummer(kentekenNummer);
        return new ResponseEntity<>(voertuig, HttpStatus.OK);
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerVoertuig(@RequestBody VoertuigDto registerRequest) {
        Voertuig voertuig = voertuigService
                .registerVoertuig(registerRequest);
        return new ResponseEntity<>(voertuig, CREATED);
    }

    @GetMapping("/voertuigtype/all")
    public ResponseEntity<List<VoertuigType>> getAllVoertuigType() {
        List<VoertuigType> allVoertuigType = voertuigService.findAllVoertuigType();
        return new ResponseEntity<>(allVoertuigType, HttpStatus.OK);
    }

}
