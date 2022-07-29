package com.quick.response.application.global.repositories;

import com.quick.response.application.global.entities.Document;
import org.springframework.data.jpa.repository.JpaRepository;


public interface DocumentRepository extends JpaRepository<Document, Long> {
}
