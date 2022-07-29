package com.quick.response.application.client.services;

import com.quick.response.application.client.dto.VoertuigDto;
import com.quick.response.application.client.entities.Voertuig;
import com.quick.response.application.client.entities.VoertuigType;

import java.util.List;

public interface VoertuigService {

    List<Voertuig> findAllByUserId(Long userId);

    List<Voertuig> findAllByUserIdAndKentekenNummer(Long userId, String kentekenNummer);
    Voertuig findByKentekenNummer(String kentekenNummer);

    Voertuig registerVoertuig(VoertuigDto registerRequest);

    List<VoertuigType> findAllVoertuigType();
}
