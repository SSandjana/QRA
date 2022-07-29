package com.quick.response.application.client.services.Impl;

import com.quick.response.application.client.dto.VoertuigDto;
import com.quick.response.application.client.entities.Voertuig;
import com.quick.response.application.client.entities.VoertuigType;
import com.quick.response.application.client.repositories.VoertuigRepository;
import com.quick.response.application.client.repositories.VoertuigTypeRepository;
import com.quick.response.application.client.services.VoertuigService;
import com.quick.response.application.global.entities.User;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@AllArgsConstructor(onConstructor = @__({@Autowired}))
public class VoertuigServiceImpl implements VoertuigService {

    private final VoertuigRepository voertuigRepository;
    private final VoertuigTypeRepository voertuigTypeRepository;

    @Override
    public List<Voertuig> findAllByUserId(Long userId) {
        return voertuigRepository.findAllByUserId(userId);
    }

    @Override
    public List<Voertuig> findAllByUserIdAndKentekenNummer(Long userId, String kentekenNummer) {
        return voertuigRepository.findAllByUserIdAndKentekenNummerContainingIgnoreCase(userId, kentekenNummer);
    }

    @Override
    public Voertuig findByKentekenNummer(String kentekenNummer) {
        return voertuigRepository.findByKentekenNummer(kentekenNummer);
    }

    @Transactional
    @Override
    public Voertuig registerVoertuig(VoertuigDto registerRequest) {
        Voertuig voertuig = Voertuig.builder()
                .user(User.builder().id(registerRequest.getUserId()).build())
                .bouwJaar(registerRequest.getBouwJaar())
                .voertuigType(VoertuigType.builder().id(registerRequest.getVoertuigType()).build())
                .merk(registerRequest.getMerk())
                .kentekenNummer(registerRequest.getKentekenNummer())
                .build();
        return voertuigRepository.save(voertuig);
    }

    @Override
    public List<VoertuigType> findAllVoertuigType() {
        return voertuigTypeRepository.findAll();
    }
}
