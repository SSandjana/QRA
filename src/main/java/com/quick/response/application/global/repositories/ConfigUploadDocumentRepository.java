package com.quick.response.application.global.repositories;

import com.quick.response.application.global.entities.ConfigUploadDocument;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository


public interface ConfigUploadDocumentRepository extends JpaRepository<ConfigUploadDocument, Long> {
    List<ConfigUploadDocument> findAll();
}
