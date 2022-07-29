package com.quick.response.application.client.repositories;

import com.quick.response.application.client.entities.Voertuig;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VoertuigRepository extends JpaRepository<Voertuig, Long> {
    List<Voertuig> findAllByUserId(Long userId);

    List<Voertuig> findAllByUserIdAndKentekenNummerContainingIgnoreCase(Long userId, String kentekenNummer);

    Voertuig findByKentekenNummer(String kentekenNummer);
}
