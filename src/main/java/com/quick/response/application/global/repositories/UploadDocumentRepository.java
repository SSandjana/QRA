package com.quick.response.application.global.repositories;

import com.quick.response.application.global.entities.UploadDocument;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UploadDocumentRepository extends JpaRepository<UploadDocument, Long> {
}
