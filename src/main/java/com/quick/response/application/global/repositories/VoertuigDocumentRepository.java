package com.quick.response.application.global.repositories;

import com.quick.response.application.client.entities.VoertuigDocument;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VoertuigDocumentRepository extends JpaRepository<VoertuigDocument, Long> {
}
